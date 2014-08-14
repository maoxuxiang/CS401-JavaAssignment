package a8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class PixelInspectorTool implements Tool, ActionListener {

	private PixelInspectorUI ui;
	private ImageEditorModel model;
	private int x;
	private int y;
	
	public PixelInspectorTool(ImageEditorModel model) {
		this.model = model;
		ui = new PixelInspectorUI();
		ui.addActionListener(this);
		x = 0;
		y = 0;
	}
	
//	@Override
	public void mouseClicked(MouseEvent e) {
	}

//	@Override
	public void mousePressed(MouseEvent e) {
		try {
			ui.setInfo(e.getX(), e.getY(), model.getPixel(e.getX(), e.getY()));
			x = e.getX();
			y = e.getY();
			ui.editFrameView(magnifyFrame());
		//	System.out.println(model.getColor()[0]);
			
		}
		catch (Exception ex) {
			// Click may have been out of bounds. Do nothing in this case.
		}
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

//	@Override
	public String getName() {
		return "Pixel Inspector";
	}

//	@Override
	public JPanel getUI() {
		return ui;
	}

//	@Override
	public void mouseDragged(MouseEvent e) {
		try {
			ui.setInfo(e.getX(), e.getY(), model.getPixel(e.getX(), e.getY()));
			x = e.getX();
			y = e.getY();
			ui.editFrameView(magnifyFrame());
		}
		catch (Exception ex) {
			// Click may have been out of bounds. Do nothing in this case.
		}
	}

//	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public Frame magnifyFrame() {
		
		Frame lao = model.getCurrent();
		
		ColorFrame xin = new ColorFrame(90, 90);
		for(int i=0; i<90; i++) {
			for(int j=0; j<90; j++) {
				xin.setPixel(i, j, lao.getPixel(x-15+i/3, y-15+j/3));
			}
		}
		
		return xin;
	
	}

	public void actionPerformed(ActionEvent e) {
		
		model.setColor(x,y);
		
	}

}
