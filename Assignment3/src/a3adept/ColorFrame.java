package a3adept;

import java.util.Iterator;


public class ColorFrame implements Frame {
	private int a;
	private int b;
	private ColorPixel[][] frame; 
	
	public ColorFrame(int width, int height, ColorPixel init_color) {
		a = width;
		b = height;
		frame = new ColorPixel[b][a];
		for (int i=0; i<b; i++) {
			for (int j=0; j<a; j++)
				frame[i][j] = init_color;
		}
		
	}
	public ColorFrame (int width, int height) {
		this(width, height, new ColorPixel(0.5, 0.5, 0.5));
	/*	a = width;
		b = height;
		frame = new ColorPixel[b][a];
		for (int i=0; i<b; i++) {
			for (int j=0; j<a; j++)
				frame[i][j] = new ColorPixel(0.5, 0.5, 0.5);
		}  */
		
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
		return frame[y][x];
	}
	
	public void setPixel(int x, int y, Pixel p) {
		if (x >= a || y >= b) {
			throw new RuntimeException(" X or Y out of bound!");
		}
		if (p == null) {
			throw new RuntimeException(" Pixel cannot be NULL!");
		}
		frame[y][x] = (ColorPixel)p;
	}
	
	public Iterator<Pixel> iterator() {
		Iterator<Pixel> iter = new PixelIterator(this);
		return iter;
	}



}
