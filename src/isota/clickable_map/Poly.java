package isota.clickable_map;

public abstract class Poly extends AreaShape {
	private Coords cs = new Coords();

    public void add(int x, int y){
    	cs.add(x, y);
    }

    public Poly(String alt, String href) {
    	super(alt, href);
    }

}
