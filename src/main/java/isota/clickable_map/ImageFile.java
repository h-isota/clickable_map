package isota.clickable_map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

import isota.util.Area;
import isota.util.Utils;

/**
 * 画像ファイル
 * @author isota
 *
 */
public class ImageFile {
    private String name;
    private Vector<Shape> shapes = new Vector<>();
    private File path;

    /**
     * オブジェクトを生成します。
     * @param name 画像名
     */
    public ImageFile(String name) {
    	this.name = name;
    }

    /**
     * 図形を追加します。
     * @param s 図形
     */
    public void addShape(Shape s) {
    	shapes.add(s);
    }

    /**
     * 名前を取得します。
     * @return 名前
     */
    public String getName() {
    	return name;
    }

    private Area getArea() {
    	if (shapes.size() == 0) {
    		return null;
    	}
    	int x1 = Integer.MAX_VALUE;
    	int x2 = Integer.MIN_VALUE;
    	int y1 = Integer.MAX_VALUE;
    	int y2 = Integer.MIN_VALUE;
    	for (Shape s: shapes) {
    		Area sa = s.getArea();
    		if (sa == null) continue;
    		if (sa.getX() < x1) { x1 = sa.getX(); }
    		if (sa.getX() + sa.getWidth() > x2) { x2 = sa.getX() + sa.getWidth(); }
    		if (sa.getY() < y1) { y1 = sa.getY(); }
    		if (sa.getY() + sa.getHeight() > y2) { y2 = sa.getY() + sa.getHeight(); }
    	}
    	Area result = new Area(x1, y1, x2 - x1, y2 - y1);
    	return result;
    }

    /**
     * ファイルに保存します。
     * @param path 保存先のパス
     * @throws IOException 入出力エラー
     */
    public void save(File path) throws IOException {
    	this.path = path;
    	final int MARGIN = 10;
    	Area a = getArea();
    	BufferedImage bi = new BufferedImage(a.getX() + a.getWidth() + MARGIN,
    										a.getY() + a.getHeight() + MARGIN, BufferedImage.TYPE_INT_RGB);
    	Graphics2D g = bi.createGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, a.getX() + a.getWidth() + MARGIN, a.getY() + a.getHeight() + MARGIN);
		g.setColor(Color.black);
    	for (Shape s: shapes) {
    		s.draw(g);
    	}
    	ImageIO.write(bi, "png", path);
    }

    /**
     * クリッカブルマップタグを取得します。
     * @param src 画像ファイルへの相対パス
     * @return クリッカブルマップタグ
     */
    public String getTag(String src) {
    	StringBuilder sb = new StringBuilder();
    	sb.append(String.format("<img src=\"%s\" alt=\"%s\" usemap=\"#%s\">", src, name, name)).append(Utils.getLineCd());
    	sb.append(String.format("<map name=\"%s\">", name)).append(Utils.getLineCd());
    	for (Shape ts: shapes) {
    		sb.append(ts.getTag()).append(Utils.getLineCd());
    	}
    	sb.append(String.format("</map>", name)).append(Utils.getLineCd());
    	return sb.toString();
    }

    private static String getRelative(File parentFile, File childFile) {
    	File parentDir = parentFile.getParentFile();
    	if (parentDir == null) {
    		parentDir = new File(".");
    	}
    	String relative = parentDir.toURI().relativize(childFile.toURI()).toString();
    	return relative;
    }

    /**
     * クリッカブルマップタグを取得します。
     * {@link #save(File)} で保存した後に呼び出す必要があります。
     * 画像ファイルへの相対パスを自動で設定します。
     * @param htmlFile リンク元 HTML ファイル
     * @return クリッカブルマップタグ
     */
    public String getTag(File htmlFile) {
    	if (path == null) {
    		throw new RuntimeException("not saved");
    	}
    	return getTag(getRelative(htmlFile, path));
    }

}
