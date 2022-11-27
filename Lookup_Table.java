package vision;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Lookup_Table extends JFrame
{
	static int matrix[]=new int[256];
	
	public Lookup_Table(int[][] color,int set)
	{
		plattes();
		
		int value=0;
		int mod_color[][]=new int[color.length][color[0].length];
		
		for(int i=color.length-1;i>=0;i--)
		 for(int j=0;j<color[0].length;j++)
		 {
		 	value=color[i][j];
		 	mod_color[i][j]=matrix[value];
		 }
		 
		 if(set==1)
		  Filters.Rmatrix=mod_color;
		 if(set==2)
		  Filters.Gmatrix=mod_color;
		 if(set==3)
		  Filters.Bmatrix=mod_color; 		 

	}
	
	public static void plattes()
	{
		for(int i=0;i<=10;i++)
		  matrix[i]=5;
		for(int i=11;i<=150;i++)  
		  matrix[i]=50;
		for(int i=151;i<=200;i++)  
		  matrix[i]=100;  
		for(int i=201;i<=255;i++)  
		  matrix[i]=150;	 
			    
	}     
	
	public static void main(String args[])
	{
		int n2[][]={{5,9,3,6},{2,5,6,80},{6,9,5,5},{80,6,255,9}};
		Lookup_Table loo=new Lookup_Table(n2,2);
		loo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}