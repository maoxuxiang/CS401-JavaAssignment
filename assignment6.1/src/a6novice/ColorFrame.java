package a6novice;


public class ColorFrame extends DirectFrame {

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
	
}
