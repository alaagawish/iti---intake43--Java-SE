import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class MovingText extends Applet{
	private int x= 200;
	private int y = 200;
	
	public void init(){
		addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e){
				int arrow = e.getKeyCode ();
				
				switch(arrow ){
					case KeyEvent.VK_LEFT:
						x -= 10;
						break;
					case KeyEvent.VK_RIGHT:
						x += 10;
						break;
					case KeyEvent.VK_UP:
						y -= 10;
						break;
					case KeyEvent.VK_DOWN:
						y += 10;
						break;
					default: 
						break;
				}
				repaint();
			}	
			public void keyReleased(KeyEvent e){
			}
			public void keyTyped(KeyEvent e){
			}
		
		});

	}
	
	public void paint(Graphics graphics){
		graphics.drawString("JAVA", x , y);
	}
	
}