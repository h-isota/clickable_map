package isota.util;

/**
 * 大きさ
 * @author isota
 */
public class Size {
    private int width;
    private int height;

    /**
     * オブジェクトを生成します。
     * @param width 幅
     * @param height 高さ
     */
    public Size(int width, int height){
    	this.width = width;
    	this.height = height;
    }

    /**
     * 幅を取得します。
     * @return 幅
     */
    public int getWidth() {
    	return width;
    }

    /**
     * 高さを取得します。
     * @return 高さ
     */
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
