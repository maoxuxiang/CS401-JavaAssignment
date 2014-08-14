package a5novice;

public class FrameImpl implements Frame {
	
	protected Pixel pixels[][];
	protected int width;
	protected int height;
	protected String title;
	
	public FrameImpl(int width, int height, Pixel init_color, String title) {
		if (width < 1 || height < 1) {
			throw new RuntimeException("Illegal dimensions.");
		}
		
		if (title == null) {
			throw new RuntimeException("Title can't be NULL");
		}

		this.width = width;
		this.height = height;
		this.title = title;

		if (init_color == null) {
			throw new RuntimeException("Illegal initial pixel: null");
		}
				
		pixels = new Pixel[height][width];
		for (int y = 0; y<height; y++) {
			for (int x = 0; x<width; x++) {
				pixels[y][x] = init_color;
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

		return pixels[y][x];
	}
	
	public void setPixel(int x, int y, Pixel p) {};
	
	public void setTitle(String new_title) {
		if (new_title == null) {
			throw new RuntimeException("Title can't be NULL");
		}
		this.title = new_title;
	}
	
	public boolean equals(Frame f) {
		int i = 0;
		
		if (f.getHeight() != this.getHeight()||
			f.getWidth() != this.getHeight()) 
			return false;
		else
			for (int y = 0; y<height; y++) {
				for (int x = 0; x<width; x++) {
					if(!pixels[y][x].equals(f.getPixel(x, y)))
						i ++;
				}
			}
			if (i == 0)
			    return true;
			else
				return false;
	}
	
	public String toString() {
		return "Frame: "+this.getTitle() + " (" + this.getWidth() + " x " + this.getHeight() +")"; 
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
	


}
