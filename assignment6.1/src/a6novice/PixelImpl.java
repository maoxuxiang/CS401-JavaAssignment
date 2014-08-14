package a6novice;

public class PixelImpl implements Pixel {
	private double red;
	private double green;
	private double blue;
	
	public PixelImpl(double red, double green, double blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
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
		return 0.2126*red + 0.7152*green + 0.0722*blue;
	}
	
	public boolean equals(Pixel p) {
		if ((this.getBrightness() - p.getBrightness()) < 0.01) {
			return true;
		}
		else
			return false;
		 
	}
	
	public char asChar() {
		if(this.getBrightness() < 0.1)
			return ' ';
		if(this.getBrightness() < 0.2 && this.getBrightness() >= 0.1)
			return '.';
		if(this.getBrightness() < 0.3 && this.getBrightness() >= 0.2)
			return ':';
		if(this.getBrightness() < 0.4 && this.getBrightness() >= 0.3)
			return '*';
		if(this.getBrightness() < 0.5 && this.getBrightness() >= 0.4)
			return '+';
		if(this.getBrightness() < 0.6 && this.getBrightness() >= 0.5)
			return '?';
		if(this.getBrightness() < 0.7 && this.getBrightness() >= 0.6)
			return 'X';
		if(this.getBrightness() < 0.8 && this.getBrightness() >= 0.7)
			return '%';
		if(this.getBrightness() < 0.9 && this.getBrightness() >= 0.8)
			return '#';
		else 
			return '@';
	}

}
