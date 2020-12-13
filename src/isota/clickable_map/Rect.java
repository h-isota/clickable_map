package isota.clickable_map;

import java.awt.Graphics2D;

public class Rect extends AreaShape {
	private Coords cs = new Coords();

    public void add(int x, int y){
    	if (cs.size() >= 2) {
    		throw new Error("size(): " + cs.size());
    	}
    	cs.add(x, y);
    }

    public Rect(String alt, String href){
    	super(alt, href);
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
		return "<area shape=\"rect\" coords=\"" + cs + "\" href=\"" + href + "\" alt=\"" + alt + "\">";
	}

	@Override
	public void draw(Graphics2D g) {
		if (cs.size() != 2) {
			throw new Error("cs.size(): " + cs.size());
		}
	}

}
