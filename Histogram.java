package vision;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Histogram extends JFrame
{
	int count[]=new int[256];
	int value=0;
	Container c;
	
	public Histogram(int channel[][],int set)
	{
   
	 for(int i=0;i<channel.length;i++)
	  for(int j=0;j<channel[0].length;j++) 
	  {	
	  	value=channel[i][j];
	  	count[value]++;
	  }

	  
	  DrawHist draw=new DrawHist(count);
	  c=getContentPane();
      c.add(draw);
      
      if(set==1)
          setTitle("Red Histogram");
      if(set==2)
          setTitle("Green Histogram");
      if(set==3)
          setTitle("Blue Histogram");
      if(set==4) 
          setTitle("Gray Histogram");
      
      setLocation(360,50);
      setResizable(false);
      setSize(350,450);
      setVisible(true);
      
	}
	
	public static void main(String args[])
	{
		/*int n2[][]={{5,9,3,6},{2,5,6,80},{6,9,5,5},{80,6,255,9}};
		
		Histogram h2=new Histogram(n2,1);
		h2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	}
	
	// class DrawHist
	public class DrawHist extends JPanel
	{
		int e[]=new int[256];
		
		DrawHist(int x[])
		{
			e=x; 
		}
		
		protected void paintComponent(Graphics g)
		{
		   super.paintComponent(g);
		  
		    g.drawLine(25,25,25,400);
		    g.drawLine(25,400,282,400);
		    g.drawString("Color",290,402);
		    g.drawString("Frequency",10,20);
		    g.setColor(Color.blue);
		
				   
		    Polygon poly=new Polygon();
		
		    for(int i=0;i<256;i++)
		    {
		      e[i]=(int)(e[i]*0.02);	
		      poly.addPoint(25+i,(400-(int)e[i]));
		    }
		    g.drawPolyline(poly.xpoints,poly.ypoints,poly.npoints);
	
		}
	} 
}