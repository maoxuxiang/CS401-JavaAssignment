package a3jedi;

import java.util.Iterator;

public class GrayFrame implements Frame {
	private int a;
	private int b;
	private GrayPixel[][] grayFrame;
	
	public GrayFrame(int width, int height, GrayPixel init_color) {
		a = width;
		b = height;
		grayFrame = new GrayPixel[b][a];
		for (int i=0; i<b; i++) {
			for (int j=0; j<a; j++)
				grayFrame[i][j] = init_color;
		}
	}
	
	public GrayFrame(int width, int height) {
		this(width,height,new GrayPixel(0.5));
	}
	
	public int getWidth() {
		return a;
	}
	
	public int getHeight() {
		return b;
	}
	
	public Pixel getPixel(int x, int y) {
		if (x >= a || y >= b) {
			throw new RuntimeException(" X or Y out of bound");
		}
		return grayFrame[y][x];
	}
	
	public void setPixel(int x, int y, Pixel p) {
		if (x >= a || y >= b) {
			throw new RuntimeException(" X or Y out of bound!");
		}
		if (p == null) {
			throw new RuntimeException(" Pixel cannot be NULL!");
		}
		grayFrame[y][x] = (GrayPixel)p;
	}
	
	public Iterator<Pixel> iterator() {
		Iterator<Pixel> iter = new PixelIterator(this);
		return iter;
	}
	
	public Iterator<Pixel> zigzag() {
		Iterator<Pixel> zigIter = new ZigZagIterator(this);
		return zigIter;
	
	
    }
}
