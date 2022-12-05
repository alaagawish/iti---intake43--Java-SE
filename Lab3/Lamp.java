import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;

public class Lamp extends Applet{
	public void paint(Graphics graphics){
	//upper oval
	graphics.setColor(Color.YELLOW.brighter());
	graphics.fillOval(82, 15, 306, 58) ;
	//lines left and right
	graphics.setColor(Color.BLACK);
	graphics.drawLine(82, 48, 33, 275);
	graphics.drawLine(388, 48, 437, 275);
	
	//left oval
	
	graphics.setColor(Color.YELLOW.brighter());
	graphics.fillOval(58, 153, 56, 89) ;
	
	//right oval
	graphics.setColor(Color.YELLOW.brighter());
	graphics.fillOval(346, 151, 57, 89) ;
	
	//middle oval
	graphics.setColor(Color.YELLOW.brighter());
	graphics.fillOval(169, 113, 129, 187) ;
	
	//legs line
	graphics.setColor(Color.BLACK);
	graphics.drawLine(214, 318, 180, 442);
	graphics.drawLine(233, 318, 259, 442);
	
	//base rect
	graphics.drawRect(70, 442 , 298, 29);
	
	//arc
	
	graphics.drawArc(33, 238, 404, 78, 0, -180);
	
	
	}
}