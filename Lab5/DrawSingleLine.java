import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class DrawSingleLine extends Applet{
	private int startX,startY,endX,endY;
	
	public void init(){
		
		addMouseMotionListener(new MouseMotionListener(){
			
			
				public void mouseDragged( MouseEvent e){
					startX=getWidth()/2;
					startY=getHeight()/2;
					endX=e.getX();
					endY=e.getY();
					
					
					repaint();
				}
				
				public void mouseMoved(MouseEvent e){}
		
	});


	}
	public void paint(Graphics graphics){
		
		graphics.drawLine(startX,startY,endX,endY);
	}
	
	
}