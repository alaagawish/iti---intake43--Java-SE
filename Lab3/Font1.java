import java.applet.Applet;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Font;

public class Font1 extends Applet{
	String[] fonts ;
	public void init(){
	Toolkit toolKit= Toolkit.getDefaultToolkit();
	fonts = toolKit.getFontList();

	
	}
	
	public void paint(Graphics graphics){
		int x=20,y=50;
		for(int i=0;i<fonts.length;i++){
			graphics.setFont(new Font(fonts[i],22,26));
			graphics.drawString(fonts[i],x , y);
			
			y+=50;
			
		}
		
		
	}
}
