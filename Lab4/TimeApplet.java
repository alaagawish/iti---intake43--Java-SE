import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;



public class TimeApplet extends Applet implements Runnable{
	
	Thread thread;
	public void init(){
		thread = new Thread(this);
		thread.start();
	}
	public void paint(Graphics graphics){
		
		Date date =new Date();
		
		graphics.drawString(date.toString(),getWidth()/2,getHeight()/2);
		
		
		
	}
	
	
	
	
	public void run(){
		while(true){
			try{
				repaint();
				Thread.sleep(1000); 
			}catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
	}
	
	
	
	
	
}