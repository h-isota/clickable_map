package isota.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * プライベートメンバーにアクセスするクラス
 * 
 * @author isota
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class PrivateAccessor {
    private Object obj = null;
    private Class cls;

    /**
     * static メンバーのみにアクセスする場合
     * 
     * @param cls クラスの型
     */
    public PrivateAccessor(Class cls) {
	this.cls = cls;
    }

    /**
     * オブジェクトにアクセスする場合
     * 
     * @param obj オブジェクト
     */
    public PrivateAccessor(Object obj) {
	this(obj.getClass());
	this.obj = obj;
    }

    private static <T> T call(Class cls, Object obj, String name, Object... objects) {
	T ret = null;
	try {
	    Class[] pt = new Class[objects.length];
	    for (int i = 0; i < objects.length; i++) {
		pt[i] = objects[i].getClass();
	    }
	    Method m;
	    m = cls.getDeclaredMethod(name, pt);
	    m.setAccessible(true);
	    // static な場合は、obj が null
	    ret = (T) m.invoke(obj, objects);
	} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
	    throw new Error(e);
	}
	return ret;
    }

    /**
     * static メソッドにアクセスします。
     * 
     * @param <T>     返り値の型
     * @param cls     クラスの型
     * @param name    メソッド名
     * @param objects 引数
     * @return 返り値
     */
    public static <T> T call(Class cls, String name, Object... objects) {
	return call(cls, null, name, objects);
    }

    /**
     * static またはインスタンスメソッドにアクセスします。
     * 
     * @param <T>     返り値の型
     * @param name    メソッド名
     * @param objects 引数
     * @return 返り値
     */
    public <T> T call(String name, Object... objects) {
	return call(cls, obj, name, objects);
    }

    /**
     * フィールドの値を取得します。
     * 
     * @param <T>  フィールドの型
     * @param name フィールド名
     * @return フィールド
     */
    public <T> T getField(String name) {
	T ret = null;
	try {
	    Field f = cls.getDeclaredField(name);
	    f.setAccessible(true);
	    ret = (T) f.get(obj);
	} catch (NoSuchFieldException | IllegalAccessException e) {
	    throw new Error(e);
	}
	return ret;
    }

    /**
     * フィールドに値を設定します。
     * 
     * @param name  フィールド名
     * @param value 設定する値
     */
    public void setField(String name, Object value) {
	try {
	    Field f = cls.getDeclaredField(name);
	    f.setAccessible(true);
	    f.set(obj, value);
	} catch (NoSuchFieldException | IllegalAccessException e) {
	    throw new Error(e);
	}
    }
}
