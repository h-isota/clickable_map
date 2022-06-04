package isota.clickable_map.shape;

import java.awt.Graphics2D;

import isota.clickable_map.Shape;
import isota.util.Area;
import isota.util.Coords;

/**
 * 四角形
 * 
 * @author isota
 *
 */
public class Rect extends Shape {
    private Coords cs = new Coords();

    /**
     * オブジェクトを生成します。
     * 
     * @param alt  alt 属性
     * @param href href 属性
     * @param x1   左上の X 座標
     * @param y1   左上の Y 座標
     * @param x2   右下の X 座標
     * @param y2   右下の Y 座標
     */
    public Rect(String alt, String href, int x1, int y1, int x2, int y2) {
	super(alt, href);
	cs.add(x1, y1);
	cs.add(x2, y2);
    }

    @Override
    public Area getArea() {
	if (cs.size() != 2) {
	    throw new Error("cs.size(): " + cs.size());
	}
	return cs.getArea();
    }

    @Override
    public String getTag() {
	if (cs.size() != 2) {
	    throw new Error("cs.size(): " + cs.size());
	}
	return String.format("<area shape=\"rect\" coords=\"%s\" href=\"%s\" alt=\"%s\">", cs, href, alt);
    }

    @Override
    public void draw(Graphics2D g) {
	if (cs.size() != 2) {
	    throw new Error("cs.size(): " + cs.size());
	}
	Area a = getArea();
	g.drawRect(a.getX(), a.getY(), a.getWidth(), a.getHeight());
    }

}
