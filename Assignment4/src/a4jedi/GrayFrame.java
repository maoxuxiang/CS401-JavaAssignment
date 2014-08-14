package a4jedi;


public class GrayFrame extends FrameImpl {

	private static final Pixel DEFAULT_PIXEL_VALUE = new GrayPixel(0.5);

	
	public GrayFrame(int width, int height, Pixel init_color, String title) {
		super( width,  height,  init_color,  title);
	}
	
	public GrayFrame(int width, int height) {
		super(width, height, DEFAULT_PIXEL_VALUE, "untitled");
	}
	
	public void setPixel(int x, int y, Pixel p) {
		if (!(p instanceof GrayPixel)) {
			throw new RuntimeException("GrayFrame can only accept GrayPixel");
		}

		if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
			throw new RuntimeException("x,y coordinates out of bounds");
		}
		
		pixels[y][x] = p;
	}
	
	public GrayFrame[] separate() {
		GrayFrame[] g = new GrayFrame[1];
		
		GrayFrame itsFrame = new GrayFrame(this.getWidth(),this.getHeight());
		for (int y = 0; y<height; y++) {
			for (int x = 0; x<width; x++) {
				itsFrame.setPixel(x, y, new GrayPixel(this.getPixel(x, y).getBlue()));
			}
		}
		
		g[0] = itsFrame;
		return g;  
	
	}
}
