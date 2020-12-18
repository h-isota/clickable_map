package isota.clickable_map;

public abstract class TaggedShape extends Shape {
    protected String alt;
    protected String href;

    public TaggedShape(String alt, String href){
    	this.alt = alt;
    	this.href = href;
    }

    public abstract String getTag();

}
