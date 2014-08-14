package a4adept;

public class GrayPixel implements Pixel {

	private double level;

	public GrayPixel(double level) {
		this.level = level;
	}
	
	public double getRed() {
		return level;
	}

	public double getGreen() {
		return level;
	}

	public double getBlue() {
		return level;
	}

	public double getBrightness() {
		return level;
	}
	
	public boolean equals(Pixel p) {
		if ( /*this.getBlue() == p.getBlue()&&
			this.getRed() == p.getRed()&&
			this.getGreen() == p.getGreen()&&  */
			(this.getBrightness() - p.getBrightness()) < 0.01) {
			return true;
		}
		else
			return false;
		 
	}
}
