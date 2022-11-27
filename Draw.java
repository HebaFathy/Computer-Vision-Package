package vision;
import java.awt.*;
import javax.swing.*;
import java.io.*;

//---------------------------- * Class Draw * ------------------------------
	
	public class Draw extends JPanel
	{
		int red_channel[][]=new int[Filters.height][Filters.width];
		int green_channel[][]=new int[Filters.height][Filters.width];
		int blue_channel[][]=new int[Filters.height][Filters.width];
		int gray_channel[][]=new int[Filters.height][Filters.width];
		int fcheck=0;
		
		public Draw(int matrix1[][],int matrix2[][],int matrix3[][],int c)
		{
			fcheck=c;
			red_channel=matrix1;
			green_channel=matrix2;
			blue_channel=matrix3;	
			gray_channel=Filters.getGray(matrix1,matrix2,matrix3);
		}
		
		protected void paintComponent(Graphics g)
	    {
	    	try{
	       super.paintComponent(g);   
	            
	       for(int i=Filters.height-1;i>0;i--)	
              for(int j=0;j<Filters.width;j++)
              {
               if(fcheck==1)
                g.setColor(new Color(red_channel[i][j],red_channel[i][j],red_channel[i][j]));                      
               if(fcheck==2)
                g.setColor(new Color(green_channel[i][j],green_channel[i][j],green_channel[i][j]));                       
               if(fcheck==3)
                g.setColor(new Color(blue_channel[i][j],blue_channel[i][j],blue_channel[i][j]));                       
               if(fcheck==4)               	
                g.setColor(new Color(gray_channel[i][j],gray_channel[i][j],gray_channel[i][j])); 
               if(fcheck==5)
               	g.setColor(new Color(red_channel[i][j],green_channel[i][j],blue_channel[i][j]));                
               	
               g.drawLine(j,i,j,i); 
	    }}catch(Exception ex){ex.getMessage();}
	   }
	}