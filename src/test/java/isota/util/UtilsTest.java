/**
 *
 */
package isota.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author isota
 *
 */
public class UtilsTest {

	/**
	 * {@link isota.util.Utils#getLineCd()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetLineCd() {
		assertEquals(System.getProperty("line.separator"), Utils.getLineCd());
	}

}
