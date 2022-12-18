import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Lambda extends Applet{
	int counter;
	Button increment,decrement;
	
	public void init(){
		increment = new Button("Increment");
		increment.addActionListener(( actionEvent)->{
				counter++ ;
				repaint();
			
		});
			
		add(increment);
		
		decrement = new Button("Decrement");
		decrement.addActionListener(new MyButtonListener());
		add(decrement);
	}
	
	public void paint(Graphics graphics){
		graphics.drawString("Counter is:" + counter, getWidth()/2, getHeight()/2);
	}
	
	public class MyButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			counter-- ;
			if(counter<0)
				counter=0;
			
			repaint();
		}
	}
}

