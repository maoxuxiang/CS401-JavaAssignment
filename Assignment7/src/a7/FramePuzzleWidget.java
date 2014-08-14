package a7;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FramePuzzleWidget extends JPanel implements KeyListener, MouseListener {

	private FrameView[][] frame_view;
	private IndirectFrame[][] indirect;
	private IndirectFrame[][] indirectSolid;
	private JPanel picPanel;
	private Frame solidColor;
	private FrameView initTile;
	
	
	public FramePuzzleWidget(Frame f) {
		setLayout(new BorderLayout());
		
		picPanel = new JPanel();
		picPanel.setLayout(new GridLayout(5,5));
		
		solidColor = new ColorFrame(f.getWidth(), f.getHeight());
		
		for(int y=0; y<f.getHeight(); y++) {
			for(int x=0; x<f.getWidth(); x++) {
				solidColor.setPixel(x, y, new ColorPixel(0, 1, 0));
			}
		}
		
		indirectSolid = solidColor.makeTiles(5, 5);
		
		indirect = f.makeTiles(5, 5);
		frame_view = new FrameView[5][5];
		
		for(int y=0; y<5; y++) {
			for(int x=0; x<5; x++) {
				if (x == 4 && y == 4) {
					frame_view[x][y] = new FrameView(indirectSolid[x][y]);
					frame_view[x][y].setX(4);
					frame_view[x][y].setY(4);
					picPanel.add(frame_view[x][y]);
				}
				else {
					frame_view[x][y] = new FrameView(indirect[x][y]);
					frame_view[x][y].setX(x);
					frame_view[x][y].setY(y);
					picPanel.add(frame_view[x][y]);
					
				}
			}
		}
		
		add(picPanel, BorderLayout.CENTER);
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				frame_view[i][j].addMouseListener(this);
				frame_view[i][j].addKeyListener(this);
				frame_view[i][j].setFocusable(true);
			}
		}
		
		initTile = frame_view[4][4];
	
	}
	
	private void swap(FrameView f1, FrameView f2) {
		
		Frame temp = f1.getFrame();
		f1.setFrame(f2.getFrame());
		f2.setFrame(temp);
	
	}
	

//	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(((FrameView)e.getSource()).getX() == initTile.getX()) {
			int y = ((FrameView)e.getSource()).getY();
			if(y < initTile.getY()) {
				for(int i=0; i<initTile.getY()-y; i++)
					swap(frame_view[initTile.getX()][initTile.getY()-i],
							frame_view[initTile.getX()][initTile.getY()-i-1]);
			} 
			if(y > initTile.getY()) {
				for(int i=0; i<y-initTile.getY(); i++)
					swap(frame_view[initTile.getX()][initTile.getY()+i],
							frame_view[initTile.getX()][initTile.getY()+1+i]);
			}
			
			initTile = (FrameView)e.getSource();
		}	
		if (((FrameView)e.getSource()).getY() == initTile.getY()) {
			int x = ((FrameView)e.getSource()).getX();
			if(x < initTile.getX()) {
				for(int i=0; i<initTile.getX()-x; i++)
					swap(frame_view[initTile.getX()-i][initTile.getY()],
							frame_view[initTile.getX()-i-1][initTile.getY()]);
			} 
			if(x > initTile.getX()) {
				for(int i=0; i<x-initTile.getX(); i++)
					swap(frame_view[initTile.getX()+i][initTile.getY()],
							frame_view[initTile.getX()+i+1][initTile.getY()]);
			}
			
			initTile = (FrameView)e.getSource();
		}


	}


	public void keyPressed(KeyEvent e) {
		try {
			switch(e.getKeyCode()) {
			
			case KeyEvent.VK_UP:
				swap(initTile,frame_view[initTile.getX()][initTile.getY()-1]);
				initTile = frame_view[initTile.getX()][initTile.getY()-1];
				break;
			case KeyEvent.VK_DOWN:
				swap(initTile,frame_view[initTile.getX()][initTile.getY()+1]);
				initTile = frame_view[initTile.getX()][initTile.getY()+1];
				break;
			case KeyEvent.VK_LEFT:
				swap(initTile,frame_view[initTile.getX()-1][initTile.getY()]);
				initTile = frame_view[initTile.getX()-1][initTile.getY()];
				break;
			case KeyEvent.VK_RIGHT:
				swap(initTile,frame_view[initTile.getX()+1][initTile.getY()]);
				initTile = frame_view[initTile.getX()+1][initTile.getY()];
				break;
			}
		} catch (RuntimeException e1) {
			
		}
	
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
	
		// TODO Auto-generated method stub
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
