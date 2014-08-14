package a3jedi;

public interface Pixel {
	public double getRed();
	public double getGreen();
	public double getBlue();
	public double getBrightness();
	public Pixel lighten(double factor);
	public Pixel darken(double factor);
}
