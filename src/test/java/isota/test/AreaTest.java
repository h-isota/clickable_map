/**
 *
 */
package isota.test;

import static org.junit.Assert.*;

import org.junit.Test;

import isota.util.Area;

/**
 * @author isota
 *
 */
public class AreaTest {

    /**
     * {@link isota.util.Area#equals(java.lang.Object)} のためのテスト・メソッド。
     */
    @Test
    public void testEqualsObject() {
	Area a1 = new Area(10, 15, 100, 150);
	Area a2 = new Area(10, 15, 100, 150);
	assertTrue(a1.equals(a2));
	Area a3 = new Area(10, 15, 120, 150);
	assertFalse(a1.equals(a3));
    }

}
