package isota.clickable_map;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import isota.util.Template;
import isota.util.Utils;

/**
 * HTML ファイル
 * 
 * @author isota
 */
public class HTMLFile {
    private Vector<ImageFile> imgFiles = new Vector<>();
    private File tpl = null;

    /**
     * オブジェクトを生成します。
     * 
     * @param tpl テンプレートファイル
     */
    public HTMLFile(File tpl) {
	this.tpl = tpl;
    }

    /**
     * 画像ファイルを追加します。
     * 
     * @param imgFile 画像ファイル
     */
    public void addImageFile(ImageFile imgFile) {
	imgFiles.add(imgFile);
    }

    /**
     * 保存します。
     * 
     * @param path 保存先のパス
     * @throws IOException 入出力エラー
     */
    public void save(File path) throws IOException {
	Template tplObj = new Template(Utils.readAllLinesString(tpl));
	for (ImageFile imgFile : imgFiles) {
	    String name = imgFile.getName();
	    String value = imgFile.getTag(path);
	    tplObj.setParam(name, value);
	}
	String html = tplObj.getResult();
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path)));
	out.print(html);
	out.close();
    }

}
