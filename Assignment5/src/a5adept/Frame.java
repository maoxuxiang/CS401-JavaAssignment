package a5adept;

public interface Frame {
	int getWidth();
	int getHeight();
	Pixel getPixel(int x, int y);
	void setPixel(int x, int y, Pixel p);
	String getTitle();
	void setTitle(String new_title);
	boolean equals(Frame f);
	ColorPixel getAverage();
	String render();
	IndirectFrame crop(int x, int y, int width, int height);
}
