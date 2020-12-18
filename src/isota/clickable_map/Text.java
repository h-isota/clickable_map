package isota.clickable_map;

import java.awt.Font;
import java.awt.Graphics2D;

public class Text extends TaggedShape {
    private String value;
    private Font font;
    private int x;
    private int y;
    private TextAreaCalc tac = TextAreaCalc.getInstance();
    private Coords cs = new Coords();

    public Text(String alt, String href, String value, Font font, int x, int y) {
    	super(alt, href);
    	this.value = value;
    	this.font = font;
    	this.x = x;
    	this.y = y;
		Size s = tac.getSize(value, font);
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
		// TODO 自動生成されたメソッド・スタブ

	}

}
