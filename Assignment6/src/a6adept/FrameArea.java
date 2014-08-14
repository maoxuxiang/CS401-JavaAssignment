package a6adept;

public class FrameArea {
	
	protected int min_x;
	protected int min_y;
	protected int max_x;
	protected int max_y;

	
	public FrameArea(int min_x, int min_y, int max_x, int max_y) {
		if (min_x < 0 || min_y < 0) {
			throw new RuntimeException("Illegal dimensions.");
		}
		
		this.min_x = min_x;
		this.min_y = min_y;
		this.max_x = max_x;
		this.max_y = max_y;
		
	}
	
	public int getMinX() {
		return min_x;
	}
	public int getMaxX() {
		return max_x;
	}
	public int getMinY() {
		return min_y;
	}
	public int getMaxY() {
		return max_y;
	}
	
	public FrameArea intersect(FrameArea other) throws NoIntersectionException {
		if(other == null ||
		   other.getMaxX() < this.getMinX() ||
		   other.getMaxY() < this.getMinY() ||
		   other.getMinX() > this.getMaxX() ||
		   other.getMinY() > this.getMaxY())
			throw new NoIntersectionException("There is no intersection area between the two rectangle.");
		
		int newMin_y = other.getMinY() > this.getMinY() ? other.getMinY() : this.getMinY();
		int newMax_y = other.getMaxY() < this.getMaxY() ? other.getMaxY() : this.getMaxY();
		int newMin_x = other.getMinX() > this.getMinX() ? other.getMinX() : this.getMinX();
		int newMax_x = other.getMaxY() < this.getMaxY() ? other.getMaxY() : this.getMaxY();
		
		return new FrameArea(newMin_x, newMin_y, newMax_x, newMax_y);
		
	}
	
	public boolean isIntersect(FrameArea other) {
		if(other == null ||
		   other.getMaxX() < this.getMinX() ||
		   other.getMaxY() < this.getMinY() ||
		   other.getMinX() > this.getMaxX() ||
		   other.getMinY() > this.getMaxY())
			return false;
		
		else 
			return true;
		
	}
	
	public FrameArea union(FrameArea other) {
		if(other == null)
			return this;
		
		int newMax_y = other.getMaxY() > this.getMaxY() ? other.getMaxY() : this.getMaxY();
		int newMin_y = other.getMinY() < this.getMinY() ? other.getMinY() : this.getMinY();
		int newMin_x = other.getMinX() < this.getMinX() ? other.getMinX() : this.getMinX();
		int newMax_x = other.getMaxY() > this.getMaxY() ? other.getMaxY() : this.getMaxY();
		
		return new FrameArea(newMin_x, newMin_y, newMax_x, newMax_y);
	}
	
	public FrameArea translate(int dx, int dy) {
		
		return new FrameArea(min_x + dx, min_y + dy, max_x + dx, max_y + dy);
		
	}
	
	public String toString() {
		return "("+this.getMinX() + ", "+ this.getMinY() + ")::("+this.getMaxX() +", " +this.getMaxY()+")";
		 
	}


}
