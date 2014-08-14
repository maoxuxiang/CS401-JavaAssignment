package a4jedi;


public class ColorFrame extends FrameImpl {

	private static final Pixel DEFAULT_PIXEL_VALUE = new ColorPixel(0.5, 0.5, 0.5);


	public ColorFrame(int width, int height, Pixel init_color, String title) {
		super( width,  height,  init_color,  title);
	}
	
	public ColorFrame(int width, int height) {
		super(width, height, ColorFrame.DEFAULT_PIXEL_VALUE, "untitled");
	}
	
	public void setPixel(int x, int y, Pixel p) {
		if (!(p instanceof ColorPixel)) {
			throw new RuntimeException("ColorFrame can only accept ColorPixel");
		}

		if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
			throw new RuntimeException("x,y coordinates out of bounds");
		}
		
		pixels[y][x] = p;
	}
	
	public GrayFrame[] separate() {
		GrayFrame[] g = new GrayFrame[3];
		
		GrayFrame redFrame = new GrayFrame(this.getWidth(),this.getHeight());
		for (int y = 0; y<height; y++) {
			for (int x = 0; x<width; x++) {
				redFrame.setPixel(x, y, new GrayPixel(this.getPixel(x, y).getRed()));
			}
		}
		
		GrayFrame greenFrame = new GrayFrame(this.getWidth(),this.getHeight());
		for (int y = 0; y<height; y++) {
			for (int x = 0; x<width; x++) {
				greenFrame.setPixel(x, y, new GrayPixel(this.getPixel(x, y).getGreen()));
			}
		}
		
		GrayFrame blueFrame = new GrayFrame(this.getWidth(),this.getHeight());
		for (int y = 0; y<height; y++) {
			for (int x = 0; x<width; x++) {
				blueFrame.setPixel(x, y, new GrayPixel(this.getPixel(x, y).getBlue()));
			}
		}
		
		g[0] = redFrame;
		g[1] = greenFrame;
		g[2] = blueFrame;
		
		return g;
	}

	
}
