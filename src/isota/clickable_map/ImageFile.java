package isota.clickable_map;

import java.awt.Graphics2D;
import java.io.File;

public class ImageFile {
    private File path;
    private String name;

    public ImageFile(File path, String name) {
    	this.path = path;
    	this.name = name;
    }

    public void draw(){
        Graphics2D g;
    }

    public void close(){
    }

}
