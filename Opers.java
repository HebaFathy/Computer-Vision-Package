package vision;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Opers extends JFrame
{
	public Opers()
	{
	}
	public int[][] stretch(int x[][])
	{
		int y[][]=new int[x.length][x[0].length];
		int counter[]=new int[256];
		int low=0,high=0;
		
		for(int i=0;i<x.length;i++)
		  for(int j=0;j<x[0].length;j++) 	
	  		counter[x[i][j]]++;
	     
	    for(int i=0;i<counter.length;i++)
		  if(counter[i]>=800)
		  { 
		    low=i;
		    break;  
		  }
		for(int i=counter.length-1;i>=0;i--)
		  if(counter[i]>=800)
		  { 
		    high=i;
		    break;  
		  }
		
		for(int i=0;i<x.length;i++)
		  for(int j=0;j<x[0].length;j++) 	  
		  {
		  	if(x[i][j]<=low)
		  	   y[i][j]=0;
		  	   
		  	else if(x[i][j]>=high)
		  	   y[i][j]=255;
		  	   
		  	else
		  	   y[i][j]=255*(x[i][j]-low)/(high-low);		  	
		  }
		
		return y;   		
	}
	
	public void gommac(int color[][],int set)
	{
		int mod_color[][]=new int[color.length][color[0].length];
		String inpu=JOptionPane.showInputDialog("Enter gomma value: ");
		double gomma_value=Double.parseDouble(inpu);
		 
		for(int i=color.length-1;i>=0;i--)
		 for(int j=0;j<color[0].length;j++)
		 	mod_color[i][j]=(int)(Math.pow(color[i][j],gomma_value));
		 
		if(set==1)
		  Filters.Rmatrix=mod_color;
		if(set==2)
		  Filters.Gmatrix=mod_color;
		if(set==3)
		  Filters.Bmatrix=mod_color;	
       
	}
}