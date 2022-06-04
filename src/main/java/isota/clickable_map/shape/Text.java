package isota.clickable_map.shape;

import java.awt.Graphics2D;

import isota.clickable_map.Shape;
import isota.util.Area;
import isota.util.Coords;
import isota.util.Size;
import isota.util.TextSizeCalc;

/**
 * テキスト
 * 
 * @author isota
 */
public class Text extends Shape {
    private String value;
    private Coords cs = new Coords();

    /**
     * オブジェクトを生成します。
     * 
     * @param alt   alt 属性
     * @param href  href 属性
     * @param value テキスト
     * @param x     左下の X 座標
     * @param y     左下の Y 座標
     */
    public Text(String alt, String href, String value, int x, int y) {
	super(alt, href);
	this.value = value;
	Size s = TextSizeCalc.getSize(value);
	cs.add(x, y - s.getHeight());
	cs.add(x + s.getWidth(), y);
    }

    @Override
    public Area getArea() {
	return cs.getArea();
    }

    @Override
    public String getTag() {
	return String.format("<area shape=\"rect\" coords=\"%s\" href=\"%s\" alt=\"%s\">", cs, href, alt);
    }

    @Override
    public void draw(Graphics2D g) {
	Area a = getArea();
	g.drawString(value, a.getX(), a.getY() + a.getHeight());
    }

}
