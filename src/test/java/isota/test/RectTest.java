package isota.test;

import static org.junit.Assert.*;

import org.junit.Test;

import isota.clickable_map.shape.Rect;
import isota.util.Area;

public class RectTest {

    @Test
    public void testGetArea() {
	Rect r = new Rect("リンク1", "map1.html", 22, 11, 122, 62);
	assertEquals(new Area(22, 11, 100, 51), r.getArea());
    }

    @Test
    public void testGetTag() {
	Rect r = new Rect("リンク1", "map1.html", 22, 11, 122, 62);
	assertEquals("<area shape=\"rect\" coords=\"22,11,122,62\" href=\"map1.html\" alt=\"リンク1\">", r.getTag());
    }

}
