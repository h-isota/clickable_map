package isota.util;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * テキストのサイズを取得するクラス
 * @author isota
 *
 */
public class TextSizeCalc {
	private static TextSizeCalc instance = new TextSizeCalc();
    private Graphics2D g;
    private FontRenderContext frc;

    private TextSizeCalc() {
    	BufferedImage bi = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    	g = bi.createGraphics();
    	frc = g.getFontRenderContext();

    }

    private static TextSizeCalc getInstance(){
        return instance;
    }

    /**
     * テキストのサイズを取得します。
     * @param value テキスト
     * @return サイズ
     */
    public static Size getSize(String value){
    	TextSizeCalc i = getInstance();
    	Font font = i.g.getFont();
    	TextLayout tl = new TextLayout(value, font, i.frc);
    	Rectangle2D r2d = tl.getBounds();
        return new Size((int) r2d.getWidth(), (int) r2d.getHeight());
    }

}
