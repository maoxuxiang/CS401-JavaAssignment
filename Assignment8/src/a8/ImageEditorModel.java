package a8;

public class ImageEditorModel {

	private Frame original;
	private Frame current;
	private double[] pixelColor;
	
	public ImageEditorModel(Frame f) {
		original = f;
		current = original.copy();
		pixelColor = new double[] {0,0,0};
	}

	public Frame getCurrent() {
		return current;
	}

	public Pixel getPixel(int x, int y) {
		return current.getPixel(x, y);
	}
	
	public double[] getColor() {
		
		return pixelColor;
	}
	
	public void setColor(int x, int y) {
		pixelColor[0] = current.getPixel(x, y).getRed();
		pixelColor[1] = current.getPixel(x, y).getGreen();
		pixelColor[2] = current.getPixel(x, y).getBlue();

	}

	public void paintAt(int x, int y, Pixel brushColor, int brush_size) {
		current.suspendNotifications();
		
		for (int xpos=x-brush_size+1; xpos <=x+brush_size-1; xpos++) {
			for (int ypos=y-brush_size+1; ypos <=y+brush_size-1; ypos++) {
				if (xpos >= 0 &&
					xpos < current.getWidth() &&
					ypos >= 0 &&
					ypos < current.getHeight()) {
					current.setPixel(xpos, ypos, brushColor);
				}
			}
		}
		current.resumeNotifications();
	}
}
