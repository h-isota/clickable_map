package isota.clickable_map;

import java.awt.Graphics2D;

import isota.util.Area;

/**
 * 図形の抽象クラス
 * @author isota
 *
 */
public abstract class Shape {
	/**
	 * alt 属性
	 */
    protected String alt;
    /**
     * href 属性
     */
    protected String href;

    /**
     * タグを持つオブジェクトを生成します。
     * @param alt alt 属性
     * @param href href 属性
     */
    public Shape(String alt, String href){
    	this.alt = alt;
    	this.href = href;
    }

    /**
     * タグを持たないオブジェクトを生成します。
     */
    public Shape() {
    	this(null, null);
    }

    /**
     * 表示領域を取得します。
     * @return 表示領域
     */
    public abstract Area getArea();

    /**
     * 描画します。
     * @param g 描画先
     */
    public abstract void draw(Graphics2D g);

    /**
     * タグを取得します。
     * {@link Shape} では null を返します。
     * タグを出力する場合は、サブクラスでオーバーライドします。
     * @return タグ
     */
    public String getTag() {
    	return null;
    }

}
