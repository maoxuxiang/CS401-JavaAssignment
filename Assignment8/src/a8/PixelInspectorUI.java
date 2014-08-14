package a8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PixelInspectorUI extends JPanel {

	private JPanel large;
	private JPanel sub;
	private JLabel x_label;
	private JLabel y_label;
	private JLabel pixel_info;
	private JButton setColor;
	private FrameView magnify;

	
	public PixelInspectorUI() {
		
		setLayout(new BorderLayout());
		large = new JPanel();
		large.setLayout(new GridLayout(4,1));
		x_label = new JLabel("X: ");
		y_label = new JLabel("Y: ");
		pixel_info = new JLabel("(r,g,b)");
		setColor = new JButton("Set Paintbrush Color");

//		setLayout(new GridLayout(4,1));
		large.add(x_label);
		large.add(y_label);
		large.add(pixel_info);
		large.add(setColor);
		
		add(large,BorderLayout.CENTER);
		magnify = new FrameView(new ColorFrame(90,90));
		add(magnify,BorderLayout.EAST);
		
	}
	
	public void setInfo(int x, int y, Pixel p) {
		x_label.setText("X: " + x);
		y_label.setText("Y: " + y);
		pixel_info.setText(String.format("(%3.2f, %3.2f, %3.2f)", p.getRed(), p.getBlue(), p.getGreen()));	

	}

	public void addActionListener(ActionListener e) {
		setColor.addActionListener(e);
	}
	
	public void editFrameView(Frame f) {
		
		for(int i=0; i<90; i++) {
			for(int j=0; j<90; j++) {
				magnify.getFrame().setPixel(i, j, f.getPixel(i,j));
			}
		}
	}
	
}
