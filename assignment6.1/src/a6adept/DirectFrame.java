package a6adept;

import java.util.ArrayList;


public class DirectFrame extends FrameImpl {
	
	
	public DirectFrame(int width, int height, Pixel init_color, String title) {
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
		
		observers = new ArrayList<FrameObserver>();
	}
	
	
	public String toString() {
		return "Frame: "+this.getTitle() + " (" + this.getWidth() + " x " + this.getHeight() +")"; 
	}
	



}
