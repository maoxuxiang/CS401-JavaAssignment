package a3jedi;

import java.util.Iterator;

public class ZigZagIterator implements Iterator<Pixel> {
	private int width;
	private int height;
	private int maxWidth;
	private int maxHeight;
	private Frame f;
	
	public ZigZagIterator(Frame frame) {
		width = 0;
		height = 0;
		maxWidth = frame.getWidth();
		maxHeight = frame.getHeight();
		f = frame;

	}
	
	public boolean hasNext() {
    	if (width < maxWidth && height < maxHeight) {

    		return true;
    
    		}
    		else 
    			return false;
    	
    }
	
	public void remove() {
        throw new RuntimeException("Remove operation unsupported.");
    }
	
	  public Pixel next() {
	    	if (!hasNext()) {
	            throw new RuntimeException("No next Pixel in iteration.");
	    	}
	    	
	    	Pixel p = f.getPixel(width,height);
	    	
	    	if ((width + height)%2 == 0) {
	    		if (height == 0 && width < maxWidth -1)
	    			width += 1;
	    		else if (width == maxWidth - 1)
	    			height += 1;
	    		else {
	    			width += 1;
	    			height -= 1;
	    		}
	    	}
	    	
	    	else if ((width + height)%2 == 1) {
	    		if (width == 0 && height < maxHeight -1 )
	    			height += 1;
	    		else if (height == maxHeight - 1)
	    			width += 1;
	    		else {
	    			height += 1;
	    			width -= 1;
	    		}
	    	}
   	
	    	return p;

	    }

}
