package isota.clickable_map;

public class Size {
    private int width;
    private int height;

    public Size(int width, int height){
    	this.width = width;
    	this.height = height;
    }

    public int getWidth() {
    	return width;
    }

    public int getHeight() {
    	return height;
    }

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Size)) {
			return false;
		}
		Size objs = (Size) obj;
		return width == objs.width && height == objs.height;
	}
}
