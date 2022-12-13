import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.util.ArrayList;

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

public class DrawMultipleLines extends Applet{

	private Line line ;
	private ArrayList<Line> lineArray ;
	private int startX , startY , endX , endY ;
	private int counter ;
	
	
	
	public void init(){
		counter = 0;
		
		lineArray = new ArrayList<Line>();
		
		class MyMouseAdapter extends MouseAdapter implements MouseMotionListener {
			
			public void mousePressed(MouseEvent e){	
				
				startX = e.getX();
				startY = e.getY();
				
				line = new Line();
				line.setStartX(startX);
				line.setStartY(startY);
				
				
				
			}
			
			public void mouseReleased(MouseEvent e){
				endX = e.getX();
				endY = e.getY();
				
				line.setEndX(endX);
				line.setEndY(endY);
				
				counter ++ ;
				repaint();
				
	
			}
			
			public void mouseDragged(MouseEvent e){
				endX = e.getX();
				endY = e.getY();
								
				line.setEndX(endX);
				line.setEndY(endY);
				lineArray.add(line);
				repaint();
				
			}
			
		}
		
		
		MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
		this.addMouseListener(myMouseAdapter);
		this.addMouseMotionListener(myMouseAdapter);
			
	}
	
	public void paint(Graphics g){
		
		g.setColor(Color.red);
		
		for (int i =0  ; i< lineArray.size() ; i++)
			g.drawLine(lineArray.get(i).getStartX() , lineArray.get(i).getStartY() , lineArray.get(i).getEndX() , lineArray.get(i).getEndY());
		
		
	}


}