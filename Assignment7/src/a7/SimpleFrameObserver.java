package a7;

public class SimpleFrameObserver implements FrameObserver {
	
	public void update(Frame frame, FrameArea frame_area) {
 	      System.out.println(frame.toString() + " changed in area " + frame_area.toString());
	}

}
