package a5adept;

public class IndirectFrame implements Frame {
	private Frame m;
	private int width;
	private int height;
	private String title;
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
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Pixel getPixel(int x, int y) {
		if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
			throw new RuntimeException("x,y coordinates out of bounds");
		}

		return m.getPixel(x+x_offset, y+y_offset);
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
	
	public ColorPixel getAverage() {
		double redSum = 0;
		double greenSum = 0;
		double blueSum = 0;
		
		for (int y=0; y<height; y++) {
			for (int x=0; x<width; x++) {
				redSum += this.getPixel(x, y).getRed();
				greenSum += this.getPixel(x, y).getGreen();
				blueSum += this.getPixel(x, y).getBlue();
			}
		}
		
		double redAvg = redSum/(height*width);
		double greenAvg = greenSum/(height*width);
		double blueAvg = blueSum/(height*width);
		
		ColorPixel c1 = new ColorPixel(redAvg, greenAvg, blueAvg);
		return c1;
		
	}
	
	public String render() {
		String render = "";
		for (int y=0; y<height-1; y++) {
			for (int x=0; x<width; x++) {
				render += this.getPixel(x, y).asChar();
			}
			render += "\n";
		}
		for (int x=0; x<width; x++) {
			render += this.getPixel(x, height-1).asChar();
		}

		return render;
	}
	
	public String toString() {
		return "Indirect Frame: "+this.getTitle() + " (" + this.getWidth() + " x " + this.getHeight() +") at ("+ this.x_offset+", "+this.y_offset+")"; 
	
	}
	
	public IndirectFrame crop(int x, int y, int width, int height) {
		IndirectFrame i1 = new IndirectFrame(this, x, y, width, height);
		return i1;
	}


}
