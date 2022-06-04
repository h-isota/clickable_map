/**
 *
 */
package isota.test;

import static org.junit.Assert.*;

import org.junit.Test;

import isota.util.Area;
import isota.util.Coords;

/**
 * @author isota
 *
 */
public class CoordsTest {

    /**
     * {@link isota.util.Coords#size()} のためのテスト・メソッド。
     */
    @Test
    public void testSize() {
	Coords cs = new Coords();
	assertEquals(0, cs.size());
	cs.add(10, 15);
	assertEquals(1, cs.size());
	cs.add(100, 150);
	assertEquals(2, cs.size());
    }

    /**
     * {@link isota.util.Coords#toString()} のためのテスト・メソッド。
     */
    @Test
    public void testToString() {
	Coords cs = new Coords();
	assertEquals("", cs.toString());
	cs.add(10, 15);
	assertEquals("10,15", cs.toString());
	cs.add(100, 150);
	assertEquals("10,15,100,150", cs.toString());
    }

    /**
     * {@link isota.util.Coords#getArea()} のためのテスト・メソッド。
     */
    @Test
    public void testGetArea() {
	Coords cs = new Coords();
	assertEquals(null, cs.getArea());
	cs.add(10, 15);
	assertEquals(10, cs.getArea().getX());
	assertEquals(new Area(10, 15, 0, 0), cs.getArea());
	cs.add(100, 150);
	assertEquals(new Area(10, 15, 90, 135), cs.getArea());
    }

}
