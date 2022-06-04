package isota.util;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * テンプレート置換するクラス
 *
 * <p>
 * &lt;%-- と --%&gt; で囲まれた部分は、コメントとなる。<br>
 * &lt;%= 変数名 %&gt; の部分が、変数の値で置換される。
 * </p>
 *
 * @author isota
 *
 */
public class Template {
    private String tplContents = null;
    private Map<String, Integer> tplParams = new Hashtable<>();
    private Map<String, String> setParams = new Hashtable<>();

    /**
     * 初期化する。
     *
     * @param lines テンプレート文字列
     */
    private void init(String lines) {
	Pattern pc = Pattern.compile("<%--.*?--%>", Pattern.DOTALL);
	Matcher mc = pc.matcher(lines);
	while (mc.find()) {
	    lines = mc.replaceFirst("");
	    mc.reset(lines);
	}
	Pattern pp = Pattern.compile("<%=\\s*([a-zA-Z0-9]+)\\s*%>");
	Matcher mp = pp.matcher(lines);
	while (mp.find()) {
	    String key = mp.group(1);
	    if (!tplParams.containsKey(key)) {
		tplParams.put(key, 0);
	    }
	    int c = tplParams.get(key);
	    tplParams.put(key, ++c);
	}
	tplContents = lines;
    }

    /**
     * オブジェクトを生成する。
     *
     * @param tpl テンプレート文字列
     */
    public Template(String tpl) {
	init(tpl);
    }

    /**
     * テンプレートで要求されている変数を取得する。
     *
     * @return テンプレートで要求されている変数
     */
    public String[] getParamKeys() {
	String[] keys = tplParams.keySet().toArray(new String[0]);
	Arrays.sort(keys);
	return keys;
    }

    /**
     * テンプレートに埋め込む変数を指定する。
     *
     * @param key   変数名
     * @param value 変数の値
     */
    public void setParam(String key, String value) {
	if (!tplParams.containsKey(key)) {
	    throw new RuntimeException("No such key: " + key);
	}
	if (setParams.containsKey(key)) {
	    throw new RuntimeException("Already set key: " + key);
	}
	setParams.put(key, value);
    }

    /**
     * 置換された文字列を取得する。
     *
     * @return 置換された文字列
     */
    public String getResult() {
	String lines = tplContents;
	Pattern pp = Pattern.compile("<%=\\s*([a-zA-Z0-9]+)\\s*%>");
	Matcher mp = pp.matcher(lines);
	while (mp.find()) {
	    String key = mp.group(1);
	    if (!setParams.containsKey(key)) {
		String keys = "";
		for (String k : setParams.keySet()) {
		    if (keys.length() > 0)
			keys += ", ";
		    keys += k;
		}
		throw new Error("not contains key: " + key + Utils.getLineCd() + "You can use keys: " + keys);
	    }
	    lines = mp.replaceFirst(setParams.get(key));
	    mp.reset(lines);
	}
	return lines;
    }
}
