package isota.clickable_map;

/**
 * 表示領域
 * @author isota
 */
public class Area extends Size {
    private int x;
    private int y;

    /**
     * オブジェクトを生成します。
     * @param x X 座標
     * @param y Y 座標
     * @param width 幅
     * @param height 高さ
     */
    public Area(int x, int y, int width, int height){
    	super(width, height);
    	this.x = x;
    	this.y = y;
    }

    /**
     * X 座標を取得します。
     * @return X 座標
     */
    public int getX() {
    	return x;
    }

    /**
     * Y 座標を取得します。
     * @return Y 座標
     */
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
