/**
 *
 */
package isota.test.clickable_map;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.junit.Test;

import isota.clickable_map.Circle;
import isota.clickable_map.Default;
import isota.clickable_map.HTMLFile;
import isota.clickable_map.ImageFile;
import isota.clickable_map.Poly;
import isota.clickable_map.Rect;
import isota.clickable_map.Text;
import isota.test.PrivateAccessor;

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
		ImageFile imgFile = new ImageFile("test1");
		Rect r = new Rect("リンク1", "map1.html");
		r.add(22, 11);
		r.add(122, 62);
		imgFile.addShape(r);
		Rect r2 = new Rect("リンク2", "map2.html");
		r2.add(22, 71);
		r2.add(120, 82);
		imgFile.addShape(r2);
		imgFile.addShape(new Text("文字列1", "map3.html", "ヤッホー", 22, 102));
		imgFile.addShape(new Circle("円", "map4.html", 150, 30, 20));
		//87,78,30,110,81,139,69,113
		Poly p = new Poly("多角形", "map5.html");
		p.add(87, 78);
		p.add(30, 110);
		p.add(81, 139);
		p.add(69, 113);
		imgFile.addShape(p);
		imgFile.addShape(new Default("デフォルト", "map6.html"));
		imgFile.save(new File("test/HTMLFileTest_save.png"));
		HTMLFile hf = new HTMLFile(new File("index.html.tpl"));
		hf.addImageFile(imgFile);
		hf.save(new File("test/HTMLFileTest_save.html"));
	}

}
