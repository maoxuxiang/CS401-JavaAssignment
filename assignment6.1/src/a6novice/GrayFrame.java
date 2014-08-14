package a6novice;


public class GrayFrame extends DirectFrame {

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
}
