package isota.clickable_map;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class TextAreaCalc {
	private static TextAreaCalc instance = new TextAreaCalc();
    private Graphics2D g;
    private FontRenderContext frc;

    private TextAreaCalc() {
    	BufferedImage bi = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    	g = bi.createGraphics();
    	frc = g.getFontRenderContext();

    }
    public Size getSize(String value, Font font){
    	TextLayout tl = new TextLayout(value, font, frc);
    	Rectangle2D r2d = tl.getBounds();
        return new Size((int) r2d.getWidth(), (int) r2d.getHeight());
    }

    public static TextAreaCalc getInstance(){
        return instance;
    }

}
