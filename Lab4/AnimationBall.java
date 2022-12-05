import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;



public class AnimationBall extends Applet implements Runnable{
	
	Thread thread;
	public void init(){
		thread = new Thread(this);
		thread.start();
	}
	
	int width=0,height=0;
	boolean widthFlag=false,heightFlag=false;
	//right false, left true
	public void paint(Graphics graphics){
		
		
		
		if(width <(getWidth()-55) && !widthFlag){
			width+=20;
			if(width>= (getWidth()-55))
				widthFlag=true;
		
		}else if(widthFlag){
			
			width-=20;
			if (width<=0)
				widthFlag=false;
		}
		
		
		if(height <(getHeight()-55) && !heightFlag){
			height+=20;
			if(height>= (getHeight()-55))
				heightFlag=true;
		
		}else if(heightFlag){
			
			height-=20;
			if (height<=0)
				heightFlag=false;
		}
		graphics.setColor(Color.RED);
		graphics.fillOval(width, height, 50 ,50);
		
		}
	
	
	
	public void run(){
		while(true){

			try{
				repaint();
				Thread.sleep(200); 
			}catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
	}
	
	
}
