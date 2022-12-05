import java.applet.Applet;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class Font2 extends Applet{
	
	Font fonts[];
	public void init(){
		GraphicsEnvironment graphicsEnvironment= GraphicsEnvironment.getLocalGraphicsEnvironment();
		fonts= graphicsEnvironment.getAllFonts();
	}
	
	public void paint(Graphics graphics){
		
		int x=20,y=50;
		for(int i=0;i<fonts.length;i++){
			graphics.setFont(new Font( fonts[i].getName(),22,26));
			graphics.drawString(fonts[i].getName(),x , y);
			
			y+=50;
			
		}
		
		
	}
}
