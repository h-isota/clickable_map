package isota.clickable_map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HTML ファイル
 * @author isota
 */
public class HTMLFile {
	private Vector<ImageFile> imgFiles = new Vector<>();
	private File tpl = null;

	/**
	 * オブジェクトを生成します。
	 * @param tpl テンプレートファイル
	 */
	public HTMLFile(File tpl) {
		this.tpl = tpl;
	}

	/**
	 * 画像ファイルを追加します。
	 * @param imgFile 画像ファイル
	 */
    public void addImageFile(ImageFile imgFile) {
    	imgFiles.add(imgFile);
    }

    private String getHTML(Hashtable<String, String> params) throws IOException {
    	BufferedReader in = new BufferedReader(new FileReader(tpl));
    	StringBuilder sb = new StringBuilder();
    	String line = null;
    	while ((line = in.readLine()) != null) {
    		if (sb.length() > 0) {
    			sb.append('\n');
    		}
    		sb.append(line);
    	}
    	in.close();
    	String lines = sb.toString();
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
    		if (!params.containsKey(key)) {
    			String keys = "";
    			for (String k: params.keySet()) {
    				if (keys.length() > 0) keys += ", ";
    				keys += k;
    			}
    			throw new Error("not contains key: " + key + "\nYou can use keys: " + keys);
    		}
    		lines = mp.replaceFirst(params.get(key));
    		mp.reset(lines);
    	}
    	return lines;
    }

    /**
     * 保存します。
     * @param path 保存先のパス
     * @throws IOException 入出力エラー
     */
    public void save(File path) throws IOException {
		Hashtable<String, String> params = new Hashtable<>();
    	for (ImageFile imgFile: imgFiles) {
    		String name = imgFile.getName();
    		if (params.containsKey(name)) {
    			throw new Error("ImageFile#name exists: " + name);
    		}
    		params.put(name, imgFile.getTag(path));
    	}
    	String html = getHTML(params);
    	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path)));
    	out.print(html);
    	out.close();
    }

}
