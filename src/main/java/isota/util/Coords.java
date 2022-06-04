package isota.util;

import java.util.List;
import java.util.Vector;

/**
 * 座標
 * 
 * @author isota
 */
public class Coords {
    private static class Position {
	private int x;
	private int y;

	public Position(int x, int y) {
	    this.x = x;
	    this.y = y;
	}

	public String toString() {
	    return "" + x + "," + y;
	}
    }

    private List<Position> cs = new Vector<>();

    /**
     * オブジェクトを生成します。
     */
    public Coords() {
    }

    /**
     * 座標を追加します。
     * 
     * @param x X 座標
     * @param y Y 座標
     */
    public void add(int x, int y) {
	Position p = new Position(x, y);
	cs.add(p);
    }

    private Position getPosition(int index) {
	return cs.get(index);
    }

    /**
     * 座標の個数を取得します。
     * 
     * @return 座標の個数
     */
    public int size() {
	return cs.size();
    }

    /**
     * 座標の文字列表現
     */
    @Override
    public String toString() {
	String result = "";
	for (int i = 0; i < size(); i++) {
	    if (result.length() > 0) {
		result += ",";
	    }
	    Position p = getPosition(i);
	    result += p;
	}

	return result;
    }

    /**
     * X 座標を取得します。
     * 
     * @return X 座標の配列
     */
    public int[] getXs() {
	int[] xs = new int[size()];
	for (int i = 0; i < size(); i++) {
	    Position p = getPosition(i);
	    xs[i] = p.x;
	}
	return xs;
    }

    /**
     * Y 座標を取得します。
     * 
     * @return Y 座標の配列
     */
    public int[] getYs() {
	int[] ys = new int[size()];
	for (int i = 0; i < size(); i++) {
	    Position p = getPosition(i);
	    ys[i] = p.y;
	}
	return ys;
    }

    /**
     * 全体の表示領域を取得します。
     * 
     * @return 全体の表示領域
     */
    public Area getArea() {
	if (size() == 0) {
	    return null;
	}
	int minX = Integer.MAX_VALUE;
	int minY = Integer.MAX_VALUE;
	int maxX = Integer.MIN_VALUE;
	int maxY = Integer.MIN_VALUE;
	for (int i = 0; i < size(); i++) {
	    Position p = getPosition(i);
	    if (p.x < minX) {
		minX = p.x;
	    }
	    if (p.y < minY) {
		minY = p.y;
	    }
	    if (p.x > maxX) {
		maxX = p.x;
	    }
	    if (p.y > maxY) {
		maxY = p.y;
	    }
	}
	return new Area(minX, minY, maxX - minX, maxY - minY);
    }
}
