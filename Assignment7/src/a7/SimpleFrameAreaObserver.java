package a7;

public class SimpleFrameAreaObserver implements FrameAreaObserver {
	private FrameObserver simpleObserver;
	private FrameArea area;
	
	public SimpleFrameAreaObserver(FrameObserver o, FrameArea a ) {
		simpleObserver = o;
		area = a;
	}
	
	public void update(Frame frame, FrameArea frame_area) {
		if(frame_area.isIntersect(area))
			simpleObserver.update(frame, frame_area);
		else
			return;
		
	}
	
	public FrameArea getFrameArea() {
		return area;
	}
	

}
