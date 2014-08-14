package a6jedi;

import java.util.List;


public class FrameImpl implements Frame {
	protected Pixel pixels[][];
	protected int width;
	protected int height;
	protected String title;
	
	protected List<FrameObserver> observers;
	
	protected boolean notify;
	protected FrameArea f;
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Pixel getPixel(int x, int y) {
		if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
			throw new RuntimeException("x,y coordinates out of bounds");
		}

		return pixels[y][x];
	}
	
	public void setPixel(int x, int y, Pixel p) {
		if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
			throw new RuntimeException("x,y coordinates out of bounds");
		}
		
		pixels[y][x] = p;
		
		FrameArea s = new FrameArea(x,y,x,y);
		
		if(notify)
			notifyObservers(s);
		else
			f = f.union(s);
	}
	
	public void suspendNotifications() {
		notify = false;
	}
	
	
	public void resumeNotifications() {
		notify = true;
		notifyObservers(f);
	}
	
	public void setTitle(String new_title) {
		if (new_title == null) {
			throw new RuntimeException("Title can't be NULL");
		}
		this.title = new_title;
	}
	
	public boolean equals(Frame f) {
		int i = 0;
		
		if (f.getHeight() != this.getHeight()||
			f.getWidth() != this.getHeight()) 
			return false;
		else
			for (int y = 0; y<height; y++) {
				for (int x = 0; x<width; x++) {
					if(!pixels[y][x].equals(f.getPixel(x, y)))
						i ++;
				}
			}
			if (i == 0)
			    return true;
			else
				return false;
	}
	
	public ColorPixel getAverage() {
		double redSum = 0;
		double greenSum = 0;
		double blueSum = 0;
		
		for (int y=0; y<height; y++) {
			for (int x=0; x<width; x++) {
				redSum += this.getPixel(x, y).getRed();
				greenSum += this.getPixel(x, y).getGreen();
				blueSum += this.getPixel(x, y).getBlue();
			}
		}
		
		double redAvg = redSum/(height*width);
		double greenAvg = greenSum/(height*width);
		double blueAvg = blueSum/(height*width);
		
		ColorPixel c1 = new ColorPixel(redAvg, greenAvg, blueAvg);
		return c1;
		
	}
	
	public String render() {
		String render = "";
		for (int y=0; y<height-1; y++) {
			for (int x=0; x<width; x++) {
				render += this.getPixel(x, y).asChar();
			}
			render += "\n";
		}
		for (int x=0; x<width; x++) {
			render += this.getPixel(x, height-1).asChar();
		}

		return render;
	}
	
	public IndirectFrame crop(int x, int y, int width, int height) {
		IndirectFrame i1 = new IndirectFrame(this, x, y, width, height);
		return i1;
	}
	
	public IndirectFrame[][] makeTiles(int num_across, int num_down) {
				
		int x = width / num_across;
		int y = height / num_down;
		int x_remainder = width % num_across;
		int y_remainder = height % num_down;
		
		IndirectFrame[][] i1 = new IndirectFrame[num_across][num_down];
				
		for (int i=0; i<num_across; i++) {
			for(int j=0; j<num_down; j++) {
				if (x_remainder == 0 && y_remainder == 0)
					i1[i][j] = new IndirectFrame(this, i*x, j*y, x, y);
				if (x_remainder != 0 && y_remainder == 0) {
					if(i < x_remainder) 
						i1[i][j] = new IndirectFrame(this, i*(x+1), j*y, x+1, y);
					else
						i1[i][j] = new IndirectFrame(this, x_remainder*(x+1)+(i-x_remainder+1)*x, j*y, x, y);
				}
				if (x_remainder ==0 && y_remainder != 0) {
					if(j < y_remainder) 
						i1[i][j] = new IndirectFrame(this, i*x, j*(y+1), x, y+1);
					else
						i1[i][j] = new IndirectFrame(this, i*x, y_remainder*(y+1)+(j-y_remainder+1)*y, x, y);
				}
				if (x_remainder !=0 && y_remainder != 0) {
					if(i < x_remainder && j < y_remainder)
						i1[i][j] = new IndirectFrame(this, i*(x+1), j*(y+1), (x+1), y+1);
					if(i < x_remainder && j >= y_remainder)
						i1[i][j] = new IndirectFrame(this, i*(x+1), y_remainder*(y+1)+(j-y_remainder)*y, x+1, y);
					if(i >= x_remainder && j < y_remainder)
						i1[i][j] = new IndirectFrame(this, x_remainder*(x+1)+(i-x_remainder)*x, j*(y+1), x, y+1);
					if(i >= x_remainder && j >= y_remainder)
						i1[i][j] = new IndirectFrame(this, x_remainder*(x+1)+(i-x_remainder)*x, y_remainder*(y+1)+(j-y_remainder)*y, x, y);
				}
					
			}
		}
		return i1;
	}
	
	public void registerFrameObserver(FrameObserver observer) {
		observers.add(observer);
	}
	
	public void unregisterFrameObserver(FrameObserver observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers(FrameArea frame_area) {
		
		for(FrameObserver o : observers) {
			o.update(this, frame_area);
		}
	}
	
	public void registerFrameObserver(FrameObserver observer, FrameArea area_of_interest) {
		
		observers.add(new SimpleFrameAreaObserver(observer,area_of_interest));
	}

}
