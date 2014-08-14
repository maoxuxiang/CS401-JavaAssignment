package a3jedi;

public class GrayPixel implements Pixel {
	
	private double red;
	private double green;
	private double blue;
	
	public GrayPixel(double level) {
		this.red = level;
		this.green = level;
		this.blue = level;
	}
	
	public double getRed() {
		return red;
	}
	
	public double getGreen() {
		return green;
	}
	
	public double getBlue() {
		return blue;
	}
	
	public double getBrightness() {
		return  0.2126 * red + 0.7152 * green + 0.0722 * blue;
	}
	
	public Pixel lighten(double factor) {
	    double r = red * (1.0 - factor) + factor;
		double g = green * (1.0 - factor) + factor;
		double b = blue * (1.0 - factor) + factor;
		
		Pixel newPixel = new ColorPixel(r, g, b);
		return newPixel;
		
	}
	
	public Pixel darken(double factor) {
	    double r = red * (1.0 - factor);
		double g = green * (1.0 - factor);
		double b = blue * (1.0 - factor);
		
		Pixel newPixel = new ColorPixel(r, g, b);
		return newPixel;
		
	}

}
