package isota.clickable_map.shape;

import java.awt.Graphics2D;

import isota.util.Area;
import isota.util.Coords;

/**
 * 多角形
 * @author isota
 */
public class Poly extends Shape {
	private Coords cs = new Coords();

    /**
     * オブジェクトを生成します。
     * @param alt alt 属性
     * @param href href 属性
     */
    public Poly(String alt, String href) {
    	super(alt, href);
    }

    /**
     * 座標を追加します。
     * @param x X 座標
     * @param y Y 座標
     */
    public void add(int x, int y){
    	cs.add(x, y);
    }

	@Override
	public Area getArea() {
		return cs.getArea();
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawPolygon(cs.getXs(), cs.getYs(), cs.size());
	}

	@Override
	public String getTag() {
		return String.format("<area shape=\"poly\" coords=\"%s\" href=\"%s\" alt=\"%s\">", cs, href, alt);
	}
}
