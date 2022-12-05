import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;




public class BallGame extends Applet implements Runnable{
	
	Thread thread;
	public void init(){
		thread = new Thread(this);
		thread.start();
	}
	
	int widthF=0,heightF=0;
	boolean widthFlagF=false,heightFlagF=false;
	
	int widthS=getWidth() ,heightS=getHeight();
	boolean widthFlagS=false,heightFlagS=false;
	//right false, left true
	public void paint(Graphics graphics){
		
		
		if(widthF==(widthS+50) || widthS==(widthF+50) )
		{
			widthFlagS^=widthFlagS;
			widthFlagF^=widthFlagF;
		}
		
		if(heightF==(heightS+50) || heightS==(heightF+50) )
		{
			heightFlagS^=heightFlagS;
			heightFlagF^=heightFlagF;
		}
		
		
		
		
		//first ball
		if(widthF <(getWidth()-55) && !widthFlagF){
			widthF+=20;
			if(widthF>= (getWidth()-55))
				widthFlagF=true;
		
		}else if(widthFlagF){
			
			widthF-=20;
			if (widthF<=0)
				widthFlagF=false;
		}
		
		
		if(heightF <(getHeight()-55) && !heightFlagF){
			heightF+=20;
			if(heightF >= (getHeight()-55))
				heightFlagF=true;
		
		}else if(heightFlagF){
			
			heightF-=20;
			if (heightF<=0)
				heightFlagF=false;
		}
		
		
		//second  ball
		if(widthS <(getWidth()-55) && !widthFlagS){
			widthS+=20;
			if(widthS>= (getWidth()-55))
				widthFlagS=true;
		
		}else if(widthFlagS){
			
			widthS-=20;
			if (widthS<=0)
				widthFlagS=false;
		}
		
		
		if(heightS <(getHeight()-55) && !heightFlagS){
			heightS+=20;
			if(heightS>= (getHeight()-55))
				heightFlagS=true;
		
		}else if(heightFlagF){
			
			heightS-=20;
			if (heightS<=0)
				heightFlagS=false;
		}
		
		
		
		//first
		graphics.setColor(Color.RED);
		graphics.fillOval(widthF, heightF, 50 ,50);
		
		//second
		graphics.setColor(Color.YELLOW);
		graphics.fillOval(widthS ,heightS, 50 ,50);
		
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