package isota.clickable_map;

public class Area extends Size {
    private int x;
    private int y;

    public Area(int x, int y, int width, int height){
    	super(width, height);
    	this.x = x;
    	this.y = y;
    }

    public int getX() {
    	return x;
    }

    public int getY() {
    	return y;
    }

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Area)) {
			return false;
		}
		Area obja = (Area) obj;
		return x == obja.x && y == obja.y && super.equals(obja);
	}
}
