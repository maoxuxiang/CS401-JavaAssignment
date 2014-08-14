package a6novice;

public class IndirectFrame extends FrameImpl {
	
	private Frame m;
	private int x_offset;
	private int y_offset;
	
	public IndirectFrame (Frame source,int x_offset, int y_offset, int width, int height) {
		if(x_offset > source.getWidth()-1 || y_offset > source.getHeight()-1)
			throw new IllegalArgumentException("X_offset or y_offset Out of Bounds");
		if(x_offset + width > source.getWidth() || y_offset + height > source.getHeight()) 
			throw new IllegalArgumentException("width or height out of bounds");
		if (width < 1 || height < 1) {
			throw new RuntimeException("Illegal dimensions.");
		}
		
		this.width = width;
		this.height = height;
		this.title = source.getTitle();
		this.x_offset = x_offset;
		this.y_offset = y_offset;
		
		m = source;
		for (int y = 0; y<height; y++) {
			for (int x = 0; x<width; x++) {
				m.getPixel(x+x_offset, y+y_offset);
			}
		}
	}
	
	public void setPixel(int x, int y, Pixel p) {
		if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
			throw new RuntimeException("x,y coordinates out of bounds");
		}
		
		m.setPixel(x+x_offset, y+y_offset, p);
	} 
	
	public void setTitle(String new_title) {
		if (new_title == null) {
			throw new RuntimeException("Title can't be NULL");
		}
		m.setTitle(new_title);;
	}
	
	public Pixel getPixel(int x, int y) {
		if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
			throw new RuntimeException("x,y coordinates out of bounds");
		}

		return m.getPixel(x+x_offset, y+y_offset);
	}
	
	public boolean equals(Frame f) {
		int i = 0;
		
		if (f.getHeight() != this.getHeight()||
			f.getWidth() != this.getHeight()) 
			return false;
		else
			for (int y = 0; y<height; y++) {
				for (int x = 0; x<width; x++) {
					if(!m.getPixel(x+x_offset, y+y_offset).equals(f.getPixel(x, y)))
						i ++;
				}
			}
			if (i == 0)
			    return true;
			else
				return false;
	}
	
	
	public String toString() {
		return "Indirect Frame: "+this.getTitle() + " (" + this.getWidth() + " x " + this.getHeight() +") at ("+ this.x_offset+", "+this.y_offset+")"; 
	
	}
	
	


}
