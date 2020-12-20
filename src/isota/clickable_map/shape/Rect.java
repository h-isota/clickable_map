package isota.clickable_map.shape;

import java.awt.Graphics2D;

import isota.util.Area;
import isota.util.Coords;

/**
 * 四角形
 * @author isota
 *
 */
public class Rect extends Shape {
	private Coords cs = new Coords();

    /**
     * オブジェクトを生成します。
     * @param alt alt 属性
     * @param href href 属性
     */
    public Rect(String alt, String href){
    	super(alt, href);
    }

	/**
	 * 座標を追加します。
	 * 左上と右下の 2 回呼び出す必要があります。
	 * @param x X 座標
	 * @param y Y 座標
	 */
    public void add(int x, int y){
    	if (cs.size() >= 2) {
    		throw new Error("size(): " + cs.size());
    	}
    	cs.add(x, y);
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
