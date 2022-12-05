import java.applet.Applet;
import java.awt.Graphics;




public class TextBanner extends Applet implements Runnable{
	
	Thread thread;
	public void init(){
		thread = new Thread(this);
		thread.start();
	}
	
	int width=0;
	public void paint(Graphics graphics){
		
		
		if(width <getWidth())
			graphics.drawString("Java World",width+=20,getHeight()/2);
	
		else
			graphics.drawString("Java World",width=0,getHeight()/2);
		
	}
	
	public void run(){
		while(true){

			try{
				repaint();
				Thread.sleep(100); 
			}catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
	}
	
	
	
	
	
}