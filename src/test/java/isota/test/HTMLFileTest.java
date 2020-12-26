/**
 *
 */
package isota.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.junit.Test;

import isota.clickable_map.HTMLFile;
import isota.clickable_map.ImageFile;
import isota.clickable_map.shape.Circle;
import isota.clickable_map.shape.Default;
import isota.clickable_map.shape.Poly;
import isota.clickable_map.shape.Rect;
import isota.clickable_map.shape.Text;
import isota.util.PrivateAccessor;

/**
 * @author isota
 *
 */
public class HTMLFileTest {

	/**
	 * {@link isota.clickable_map.HTMLFile#getHTML(java.util.Hashtable)} のためのテスト・メソッド。
	 */
	@Test
	public void testGetHTML() {
		HTMLFile hf = new HTMLFile(new File("index.html.tpl"));
		Hashtable<String, String> params = new Hashtable<>();
		params.put("test1", "<img src='aaa.png'>");
		PrivateAccessor pc = new PrivateAccessor(hf);
		assertTrue(((String) pc.call("getHTML", params)).length() > 0);
	}

	/**
	 * {@link isota.clickable_map.HTMLFile#save(java.io.File)} のためのテスト・メソッド。
	 * @throws IOException 入出力エラー
	 */
	@Test
	public void testSave() throws IOException {
		// 画像オブジェクトを作成。
		// 画像名は、HTML を作成する時のテンプレート中の名前に置き換わる。
		ImageFile imgFile = new ImageFile("test1");

		// 四角形
		Rect r = new Rect("リンク1", "map1.html", 22, 11, 122, 62);
		imgFile.addShape(r);

		// 円
		imgFile.addShape(new Circle("リンク2", "map2.html", 184, 86, 30));

		// 多角形
		Poly p = new Poly("多角形", "map3.html");
		p.add(87, 78);
		p.add(30, 110);
		p.add(81, 139);
		p.add(69, 113);
		imgFile.addShape(p);

		// 文字列
		imgFile.addShape(new Text("文字列1", "map5.html", "文字列", 22, 160));

		// デフォルト
		imgFile.addShape(new Default("リンク4", "map4.html"));

		// 画像を保存
		imgFile.save(new File("docs/test/HTMLFileTest_save.png"));

		// テンプレートファイルを指定して HTML オブジェクトを作成
		HTMLFile hf = new HTMLFile(new File("index.html.tpl"));

		// 画像オブジェクトを HTML オブジェクトに追加
		hf.addImageFile(imgFile);

		// HTML を保存
		hf.save(new File("docs/test/HTMLFileTest_save.html"));
	}

}
