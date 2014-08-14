package a7;

import java.awt.BorderLayout;
import java.awt.GridLayout;



import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ImageAdjusterWidget extends JPanel implements ChangeListener {

	private FrameView frame_view;
	private JPanel sliderPanel;
	private JPanel blurPanel;
	private JPanel saturationPanel;
	private JPanel brightnessPanel;
	private JSlider blurSlider;
	private JSlider saturationSlider;
	private JSlider brightnessSlider;
	private Frame origin;
	private Frame shuffled;
	
	
	
	public ImageAdjusterWidget(Frame f) {
		setLayout(new BorderLayout());
		origin = f;
		shuffled = new ColorFrame(origin.getWidth(), origin.getHeight());
		for(int y=0; y<origin.getHeight(); y++) {
			for(int x=0; x<origin.getWidth(); x++) {
				shuffled.setPixel(x, y, origin.getPixel(x, y));
			}
		}
		
		frame_view = new FrameView(shuffled);
		add(frame_view, BorderLayout.CENTER);
		
		sliderPanel = new JPanel();
		sliderPanel.setLayout(new GridLayout(3,1));
		
		blurPanel = new JPanel();
		saturationPanel = new JPanel();
		brightnessPanel = new JPanel();
		
		blurPanel.add(new JLabel("Blur: "));
		blurSlider = buildSlider(0,5,1) ;
		blurPanel.add(blurSlider);
		
		sliderPanel.add(blurPanel);
		
		saturationPanel.add(new JLabel("Saturation: "));
		saturationSlider = buildSlider(-100, 100, 25);
		saturationPanel.add(saturationSlider);
		
		sliderPanel.add(saturationPanel);
		
		brightnessPanel.add(new JLabel("Brightness: "));
		brightnessSlider = buildSlider(-100, 100, 25);
		brightnessPanel.add(brightnessSlider);
		
		sliderPanel.add(brightnessPanel);
		add(sliderPanel, BorderLayout.SOUTH);
		
		blurSlider.addChangeListener(this);
		saturationSlider.addChangeListener(this);
		brightnessSlider.addChangeListener(this);
		

	}
	
	private JSlider buildSlider(int a, int b, int c) {
		
		JSlider slider = new JSlider(a, b, 0);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(false);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(c);
	
		return slider;
	}

	public void stateChanged(ChangeEvent arg0) {	
		
		shuffled.suspendNotifications();
		
		if (!blurSlider.getValueIsAdjusting() ||
			!brightnessSlider.getValueIsAdjusting() ||
			!saturationSlider.getValueIsAdjusting()) {
			for(int y=0; y<origin.getHeight(); y++) {
				for(int x=0; x<origin.getWidth(); x++) {
					shuffled.setPixel(x, y, origin.getPixel(x, y));
				}
			} 
		
		}
		
		
		
		if(!blurSlider.getValueIsAdjusting()) {
			
			int height = frame_view.getFrame().getHeight();
			int width = frame_view.getFrame().getWidth();
			
		for (int y=0; y<height; y++) {
				for (int x=0; x<width; x++) {
					Pixel p = computeAverage(x,y);
					shuffled.setPixel(x, y, p);
				}
			}
	
		}
		
		if(!brightnessSlider.getValueIsAdjusting()) {
			int i = brightnessSlider.getValue();
			double b = (double)i/100.00;
			int height = frame_view.getFrame().getHeight();
			int width = frame_view.getFrame().getWidth();
			

			if (b<0) {
				for (int y=0; y<height; y++) {
					for (int x=0; x<width; x++) {
						Pixel p = darken(b, shuffled.getPixel(x, y));
						shuffled.setPixel(x, y, p);
					}
				}
			}
			if (b >0) {
				for (int y=0; y<height; y++) {
					for (int x=0; x<width; x++) {
						Pixel p = lighten(b, shuffled.getPixel(x, y));
						shuffled.setPixel(x, y, p);
					}
				}
			}
			
	
		}
		
		if(!saturationSlider.getValueIsAdjusting()) {
			double f = saturationSlider.getValue();
			
			int height = frame_view.getFrame().getHeight();
			int width = frame_view.getFrame().getWidth();
			
		if(f<0) {
				for (int y=0; y<height; y++) {
					for (int x=0; x<width; x++) {
						double r = shuffled.getPixel(x, y).getRed();
						double g = shuffled.getPixel(x, y).getGreen();
						double b = shuffled.getPixel(x, y).getBlue();
						double bright = frame_view.getFrame().getPixel(x, y).getBrightness();
						
						r = r*(1.0  + (f / 100.0) ) - (bright*f/100.0);
						g = g*(1.0  + (f / 100.0) ) - (bright*f/100.0);
						b = b*(1.0  + (f / 100.0) ) - (bright*f/100.0);
						
						Pixel p = new ColorPixel(r,g,b);
						frame_view.getFrame().setPixel(x, y, p);
						
					}
				}
			}
			
			if(f>0) {
				for (int y=0; y<height; y++) {
					for (int x=0; x<width; x++) {
						double r = shuffled.getPixel(x, y).getRed();
						double g = shuffled.getPixel(x, y).getGreen();
						double b = shuffled.getPixel(x, y).getBlue();
						
						double large = r > g? r : g;
						large = large > b? large: b;
						
						double gain = (large + ((1.0 - large) * (f / 100.0))) / large;
						
						r = r*gain;
						g = g*gain;
						b = b*gain;
						
						Pixel p = new ColorPixel(r,g,b);
						frame_view.getFrame().setPixel(x, y, p);
						
					}
				}
			}
				
		}
		
		shuffled.resumeNotifications();

		
	}
	
	private Pixel computeAverage(int x, int y) {
		int i = blurSlider.getValue();
		
		double redSum = 0;
		double greenSum = 0;
		double blueSum = 0;

		
		for (int h = y - i; h <= y + i; h++) {
			for (int w = x - i; w <= x + i; w++ ) {
				try{
					redSum += shuffled.getPixel(w, h).getRed();
					greenSum += shuffled.getPixel(w, h).getGreen();
					blueSum += shuffled.getPixel(w, h).getBlue();
				} catch (RuntimeException e) {
					redSum += 0;
					greenSum += 0;
					blueSum += 0;
				}
				
			}
		}

		double redAvg = redSum/((2*i+1)*(2*i+1));
		double greenAvg = greenSum/((2*i+1)*(2*i+1));
		double blueAvg = blueSum/((2*i+1)*(2*i+1));
		
		ColorPixel c1 = new ColorPixel(redAvg, greenAvg, blueAvg);
		return c1;
		
	}
	
	
	private Pixel lighten(double factor, Pixel p) {
	    double r = p.getRed() * (1.0 - factor) + factor;
		double g = p.getGreen() * (1.0 - factor) + factor;
		double b = p.getBlue() * (1.0 - factor) + factor;
		
		Pixel newPixel = new ColorPixel(r, g, b);
		return newPixel;
		
	}
	
	private Pixel darken(double factor, Pixel p) {
	    double r = p.getRed() * (1.0 + factor);
		double g = p.getGreen() * (1.0 + factor);
		double b = p.getBlue() * (1.0 + factor);
		
		Pixel newPixel = new ColorPixel(r, g, b);
		return newPixel;
		
	}
	
	

}




