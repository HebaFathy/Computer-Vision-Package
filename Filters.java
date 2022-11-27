package vision;
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Filters extends JFrame
{	
	static int width=0;
	static int height=0;
	static int Rmatrix[][];
	static int Gmatrix[][];
	static int Bmatrix[][];
	static Container c; 
	 
	public Filters(String input,int check) throws IOException,Exception
	{  
        //isolate_Chans(input);    
        
        c=getContentPane();   
        
        if(check==1)
          setTitle("Red");
        if(check==2)
          setTitle("Green");
        if(check==3)
          setTitle("Blue");
        if(check==4) 
          setTitle("Gray");
        
         Draw image1=new Draw(Rmatrix,Gmatrix,Bmatrix,check);	    
         c.add(image1);
         setSize(width,height+5);
         setLocation(150,100);
         setVisible(true);
    } 
    
    //----------- isolate_Chans Method --------------
    
    public static void isolate_Chans(String inp) throws Exception
    {
    	DataInputStream file=new DataInputStream(new FileInputStream(inp));        
        file.skip(18);
        
        //read width & height & # of bits/pixel
        int by4=file.read();
        int by3=file.read();
        int by2=file.read();
        int by1=file.read();
        width=(((by1 & 0xff) << 24) | ((by2 & 0xff) << 16) | ((by3 & 0xff) << 8) | (by4 & 0xff));
        
        int by8=file.read();
        int by7=file.read();
        int by6=file.read();
        int by5=file.read();
        height=(((by5 & 0xff) << 24) | ((by6 & 0xff) << 16) | ((by7 & 0xff) << 8) | (by8 & 0xff));
        
        file.skip(2);
        int by10=file.read();
        int by9=file.read();
        int bits =(((by9 & 0xff) << 8) | (by10 & 0xff));

	    file.close();
               
        //Checking width if it is dividable at 4   
        int mode=width*bits/8;    
        int ser=0; 
        if(mode%4!=0)
        {
        	while(mode%4!=0)
       	   {
       	    	mode++;
       	    	ser++;
       	   }
        }
        else
          ser=0;    
    	
    	DataInputStream file2=new DataInputStream(new FileInputStream(inp));
        file2.skip(54);
            	
    	// isolating channels 
        Rmatrix=new int[height][width];
        Gmatrix=new int[height][width];
        Bmatrix=new int[height][width];
       
        for(int i=height-1;i>=0;i--)
        {	
         for(int j=0;j<width;j++)
         {   
          Bmatrix[i][j]=file2.read();     
          Gmatrix[i][j]=file2.read();  
          Rmatrix[i][j]=file2.read();  
          
          if(Rmatrix[i][j]<0)
            Rmatrix[i][j]=-1*Rmatrix[i][j];
 		  if(Gmatrix[i][j]<0)
            Gmatrix[i][j]=-1*Gmatrix[i][j];
          if(Bmatrix[i][j]<0)
            Bmatrix[i][j]=-1*Bmatrix[i][j];                      
         }
         file2.skip(ser);
        }
        file2.close();   
    }
    
    //----------- getGray Method -------------
    
    public static int[][] getGray(int Rmatr[][],int Gmatr[][],int Bmatr[][])
    {
    	int gray_channel[][]=new int[height][width];
    	for(int i=Filters.height-1;i>0;i--)	
          for(int j=0;j<Filters.width;j++)
    	     gray_channel[i][j]=(Rmatr[i][j]+Gmatr[i][j]+Bmatr[i][j])/3;
    
     return gray_channel;	     
    }
    
	public static void main(String args[]) throws IOException,Exception
	{
		Filters filter=new Filters("bliss.bmp",2);
		filter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
	}

}