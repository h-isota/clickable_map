package isota.clickable_map;

import java.awt.Font;
import java.awt.Graphics2D;

public class Text extends AreaShape {
    private String value;
    private Font font;

    public Text(String alt, String href, String value, Font font, int x, int y) {
    	super(alt, href);
    }

	@Override
	public String getTag() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Area getArea() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
