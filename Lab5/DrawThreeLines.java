import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;



class Line{
	
	private int startX , startY , endX , endY;
	
	Line(){
		startX = 0;
		startY = 0;
		endX = 0;
		endY = 0;
	}
	
	Line (int startX , int startY , int endX , int endY){
		this.startX = startX ;
		this.startY = startY ;
		this.endX = endX ;
		this.endY = endY ;
		
	}
	
	public void setStartX(int startX){
		this.startX = startX;
	}
	
	public void setStartY(int startY){
		this.startY = startY;
	}
	
	public void setEndX(int endX){
		this.endX = endX;
	}
	
	public void setEndY(int endY){
		this.endY = endY;
	}
	
	public int getStartX(){
		return startX;
	}
	
	public int getStartY(){
		return startY ;
	}
	
	public int getEndX(){
		return endX ;
	}
	
	public int getEndY(){
		return endY ;
	}
	
}

public class DrawThreeLines extends Applet {
	
	private int  startX , startY , endX  , endY  ;
	private Line [] lineArray;
	private int counter ;
	
	
	public void init (){
		
		counter = 0 ;
		startX = 0;
		startY = 0;
		endX = 0;
		endY = 0;
		
		lineArray = new Line[4] ;
		for(int i =0 ; i < 4 ; i++){
			lineArray[i] = new Line() ;
		}
		
		addMouseListener (new MouseListener(){
			public void mousePressed(MouseEvent event){
					if(counter>=3)
						counter=3;
					startX = event.getX();
					startY = event.getY();
					
					lineArray[counter].setStartX(startX);
					lineArray[counter].setStartY(startY);
					
				}
			
				public void mouseReleased(MouseEvent event){
					endX = event.getX();
					endY = event.getY();
					
					lineArray[counter].setEndX(endX);
					lineArray[counter].setEndY(endY);
				
					repaint();
					counter ++;
					
				
				}
				
			public void mouseEntered(MouseEvent e) {
			}
			
			public void mouseClicked(MouseEvent e)  {
				
			}
			
			public void mouseExited(MouseEvent e){
			}
		});
		
		
	}
	
	public void paint(Graphics graphics){
		graphics.setColor(Color.blue);
		for (int i=0 ; i < 3 ; i++){
			graphics.drawLine(lineArray[i].getStartX(),lineArray[i].getStartY(),lineArray[i].getEndX(),lineArray[i].getEndY());
			
		}
		
		
	}
	
}