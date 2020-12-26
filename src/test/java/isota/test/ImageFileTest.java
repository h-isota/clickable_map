/**
 *
 */
package isota.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import isota.clickable_map.ImageFile;
import isota.clickable_map.shape.Rect;
import isota.util.Area;
import isota.util.PrivateAccessor;

/**
 * @author isota
 *
 */
public class ImageFileTest {

	/**
	 * {@link isota.clickable_map.ImageFile#getArea()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetArea() {
		ImageFile imgFile = new ImageFile("test1");

		PrivateAccessor pa = new PrivateAccessor(imgFile);
		assertNull(pa.call("getArea"));
		Rect r = new Rect("リンク1", "map1.html", 22, 11, 122, 62);
		imgFile.addShape(r);
		Rect r2 = new Rect("リンク2", "map2.html", 22, 71, 120, 82);
		imgFile.addShape(r2);
		assertEquals(new Area(22, 11, 100, 71), pa.call("getArea"));
	}

	/**
	 * {@link isota.clickable_map.ImageFile#save(java.io.File)} のためのテスト・メソッド。
	 * @throws IOException 入出力エラー
	 */
	@Test
	public void testSave() throws IOException {
		ImageFile imgFile = new ImageFile("test1");
		Rect r = new Rect("リンク1", "map1.html", 22, 11, 122, 62);
		imgFile.addShape(r);
		Rect r2 = new Rect("リンク2", "map2.html", 22, 71, 120, 82);
		imgFile.addShape(r2);
		imgFile.addShape(r2);
		File path = new File("docs/test/ImageFileTest_save.png");
		imgFile.save(path);
		assertTrue(path.exists());
	}

	/**
	 * {@link isota.clickable_map.ImageFile#getTag(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testGetRelative() {
		PrivateAccessor pa = new PrivateAccessor(ImageFile.class);
		String relative = pa.<String>call("getRelative", new File("index.html"), new File("image/index.png"));
		assertEquals("image/index.png", relative);
		String relative2 = pa.<String>call("getRelative", new File("index.html"), new File("index.png"));
		assertEquals("index.png", relative2);
	}

	/**
	 * {@link isota.clickable_map.ImageFile#getTag(java.lang.String)} のためのテスト・メソッド。
	 * @throws IOException 入出力エラー
	 */
	@Test
	public void testGetTag() throws IOException {
		ImageFile imgFile = new ImageFile("test1");
		Rect r = new Rect("リンク1", "map1.html", 22, 11, 122, 62);
		imgFile.addShape(r);
		Rect r2 = new Rect("リンク2", "map2.html", 22, 71, 120, 82);
		imgFile.addShape(r2);
		assertTrue(imgFile.getTag("ImageFileTest_getTag.png").length() > 0);
	}

}
