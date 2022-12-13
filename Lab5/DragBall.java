import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class DragBall extends Applet{
	private int x,y;
	
	public void init(){
		x=getWidth()/2;
		y=getHeight()/2;
		addMouseMotionListener(new MouseMotionListener(){
			
			
				public void mouseDragged( MouseEvent e){
					x=e.getX();
					y=e.getY();
					repaint();
				}
				
				public void mouseMoved(MouseEvent e){}
		
	});


	}
	public void paint(Graphics graphics){
		
		
		graphics.setColor(Color.BLUE);
		graphics.fillOval(x,y,30,30);
	}
}