package isota.clickable_map.shape;

import java.awt.Graphics2D;

import isota.clickable_map.Shape;
import isota.util.Area;

/**
 * 図形を配置していない領域
 * @author isota
 */
public class Default extends Shape {

	/**
	 * オブジェクトを生成します。
	 * @param alt alt 属性
	 * @param href href 属性
	 */
    public Default(String alt, String href) {
    	super(alt, href);
    }

    /**
     * null を返します。
     */
	@Override
	public Area getArea() {
		return null;
	}

	/**
	 * 何もしません。
	 */
	@Override
	public void draw(Graphics2D g) {
	}

	/**
	 * デフォルトのリンクタグを取得します。
	 */
	@Override
	public String getTag() {
		return String.format("<area shape=\"default\" href=\"%s\" alt=\"%s\">", href, alt);
	}

}
