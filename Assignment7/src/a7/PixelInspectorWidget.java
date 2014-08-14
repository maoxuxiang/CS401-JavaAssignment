package a7;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PixelInspectorWidget extends JPanel implements MouseListener {

	private FrameView frame_view;
	private JPanel infoPanel;
	private int x, y;
	private double r, g, b, bright;
	
	public PixelInspectorWidget(Frame f) {
		setLayout(new BorderLayout());
		
		frame_view = new FrameView(f);
		frame_view.addMouseListener(this);
		add(frame_view, BorderLayout.CENTER);
		
		paint();
		
		JLabel title_label = new JLabel(f.getTitle());
		add(title_label, BorderLayout.SOUTH);
	}
	
	private void paint() {
		
		java.text.DecimalFormat df =new java.text.DecimalFormat("#0.00");
		
		
		infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(6,1));
		infoPanel.add(new JLabel("X: " + x));
		infoPanel.add(new JLabel("Y: " + y));
		infoPanel.add(new JLabel("Red: " + df.format(r)));
		infoPanel.add(new JLabel("Green: " + df.format(g)));
		infoPanel.add(new JLabel("Blue: " + df.format(b)));
		infoPanel.add(new JLabel("Brightness: " + df.format(bright)));
		
		add(infoPanel, BorderLayout.WEST);
	}

//	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("You clicked on the frame at: " + e.getX() + "," + e.getY());
		x = e.getX();
		y = e.getY();
		r = ((FrameView)e.getSource()).getFrame().getPixel(e.getX(),e.getY()).getRed();
		g = ((FrameView)e.getSource()).getFrame().getPixel(e.getX(),e.getY()).getGreen();
		b = ((FrameView)e.getSource()).getFrame().getPixel(e.getX(),e.getY()).getBlue();
		bright = ((FrameView)e.getSource()).getFrame().getPixel(e.getX(),e.getY()).getBrightness();
		infoPanel.removeAll();
		paint();
		revalidate();
	//	
				
	}

//	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

//	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

//	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

//	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
