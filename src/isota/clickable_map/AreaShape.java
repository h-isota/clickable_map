package isota.clickable_map;

public abstract class AreaShape extends Shape {
    protected String alt;
    protected String href;

    public AreaShape(String alt, String href){
    	this.alt = alt;
    	this.href = href;
    }

    public abstract String getTag();

}
