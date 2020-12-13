package isota.clickable_map;

import java.util.List;
import java.util.Vector;

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

    public void add(int x, int y){
    	Position p = new Position(x, y);
    	cs.add(p);
    }

    private Position getPosition(int index) {
    	return cs.get(index);
    }

    public int size() {
        return cs.size();
    }

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
