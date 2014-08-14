package a6adept;

public class test {
	
	public static void main(String[] args) {
		SimpleFrameObserver o1 = new SimpleFrameObserver();
		SimpleFrameObserver o2 = new SimpleFrameObserver();

		ColorFrame c_f = new ColorFrame(100, 100);
		IndirectFrame i_f = new IndirectFrame(c_f, 50, 50, 10, 10);

		c_f.registerFrameObserver(o1);
		i_f.registerFrameObserver(o2);
		
		c_f.setPixel(49,50, new ColorPixel(1,1,1));
	//	i_f.setPixel(0,0, new ColorPixel(1,1,1));
	//	String s = c_f.getPixel(50, 50).asChar();
	System.out.println(c_f.getPixel(50, 50).asChar());
		System.out.println(c_f.getPixel(10, 50).asChar());
		System.out.println(c_f.getPixel(0, 50).asChar());
	}

}
