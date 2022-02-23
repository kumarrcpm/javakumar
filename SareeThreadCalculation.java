package sareeWeaving;

import java.awt.*;
import javax.swing.JFrame;

public class SareeDesign extends Canvas{

	public static void main(String [] args)
	{
		SareeDesign designOne=new SareeDesign();
		JFrame layout = new JFrame();
		layout.add(designOne);
		layout.setSize(2688,331);
		layout.setVisible(true);
	}
		public void paint(Graphics g)
		{
			setBackground(Color.white);
			//g.drawRect(1, 1, 5, 100);
			//setForeground(Color.MAGENTA);
			//g.fillRect(1, 1, 5, 100);
			//g.drawRect(6, 1, 10, 100);
			//setForeground(Color.DARK_GRAY);
			//g.fillRect(6,1,10,100);
			//g.drawRect(11,1,200,100);
			//setForeground(Color.BLUE);
			//g.fillRect(11,1,200,100);
			//g.drawRect(212,1,5,100);
			//setForeground(Color.DARK_GRAY);
			//g.fillRect(212,1,5,100);
			g.drawRect(217,1,5,100);
			setForeground(Color.MAGENTA);
			g.fillRect(217,1,5,100);	
		}
	
	}


