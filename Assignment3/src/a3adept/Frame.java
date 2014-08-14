package a3adept;

import java.util.Iterator;

public interface Frame {
	
	public int getWidth();
	public int getHeight();
	public Pixel getPixel(int x, int y);
	public void setPixel(int x, int y, Pixel p);
	public Iterator<Pixel> iterator();

}
