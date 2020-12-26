package isota.clickable_map.shape;

import java.awt.Graphics2D;

import isota.clickable_map.Shape;
import isota.util.Area;

/**
 * 円
 * @author isota
 */
public class Circle extends Shape {
	private int x;
	private int y;
	private int radius;

	/**
     * オブジェクトを生成します。
     * @param alt alt 属性
     * @param href href 属性
	 * @param x 中心の X 座標
	 * @param y 中心の Y 座標
	 * @param radius 半径
	 */
    public Circle(String alt, String href, int x, int y, int radius) {
    	super(alt, href);
    	this.x = x;
    	this.y = y;
    	this.radius = radius;
    }

	@Override
	public Area getArea() {
		return new Area(x - radius, y - radius, radius * 2, radius * 2);
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
	}

	@Override
	public String getTag() {
		return String.format("<area shape=\"circle\" coords=\"%d, %d, %d\" href=\"%s\" alt=\"%s\">", x, y, radius, href, alt);
	}
}
