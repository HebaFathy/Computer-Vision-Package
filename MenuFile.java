package vision;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class MenuFile extends JFrame
{
	
  Container c;	
  String input="";
  JMenuBar bar;
  JFrame frame;
   
  public MenuFile() throws Exception
  {
  	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());        
    
    // image menu
  	JMenu image1=new JMenu("Image");
  	image1.setMnemonic('I');
  	JMenuItem select=new JMenuItem("Select");
  	JMenuItem close=new JMenuItem("Close");
  	image1.add(select);
  	image1.add(close);
  	
  	// show menu
  	JMenu filemenu=new JMenu("Show");
  	filemenu.setMnemonic('F');
  	JMenuItem red_item=new JMenuItem("Red");
  	JMenuItem green_item=new JMenuItem("Green");
  	JMenuItem blue_item=new JMenuItem("Blue");
  	JMenuItem gray_item=new JMenuItem("Gray");
  	JMenuItem RGB_item=new JMenuItem("RGB");
  	filemenu.add(red_item);
  	filemenu.add(green_item);
  	filemenu.add(blue_item);
  	filemenu.add(gray_item);
  	filemenu.add(RGB_item);
  	
  	// histogram menu
  	JMenu histogram1=new JMenu("Histogram");
  	histogram1.setMnemonic('H');
  	JMenuItem Ritem=new JMenuItem("Red");
  	JMenuItem Gitem=new JMenuItem("Green");
  	JMenuItem Bitem=new JMenuItem("Blue");
  	JMenuItem GRitem=new JMenuItem("Gray");
  	histogram1.add(Ritem);
  	histogram1.add(Gitem);
  	histogram1.add(Bitem);
  	histogram1.add(GRitem);
  	
  	// Lookup Table menu
  	JMenu table=new JMenu("Lookup Table");
  	JMenuItem platte1=new JMenuItem("Red_Palett");
  	JMenuItem platte2=new JMenuItem("Green_Palett");
  	JMenuItem platte3=new JMenuItem("Blue_Palett");
  	table.add(platte1);
  	table.add(platte2);
  	table.add(platte3);
  	
  	// Gomma
  	JMenu gom=new JMenu("Gomma");
  	JMenuItem Rgomma=new JMenuItem("Red");
  	JMenuItem Ggomma=new JMenuItem("Green");
  	JMenuItem Bgomma=new JMenuItem("Blue");
  	gom.add(Rgomma);
  	gom.add(Ggomma);
  	gom.add(Bgomma);
  	
  	// Stretching
  	JMenu oper=new JMenu("Operations");
  	JMenuItem stret=new JMenuItem("Stretch");  		
  	oper.add(stret);
  	
  	
  	// MenuBar
  	bar=new JMenuBar();
  	setJMenuBar(bar);
  	bar.add(image1);
  	bar.add(filemenu);
  	bar.add(histogram1);
  	bar.add(table);
  	bar.add(gom);
  	bar.add(oper);
  	
  	select.addActionListener(
  		new ActionListener(){
  			public void actionPerformed(ActionEvent e) 
  			{
  				try{
		  		// FileFilter 
				File ff;
		        Button ab = new Button();
		        JFileChooser chooser;
		        c=getContentPane();
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());        
		                	
		        ff=new File(".");
		        chooser = new JFileChooser(ff);
		        ExampleFileFilter filter = new ExampleFileFilter();
		        filter.addExtension("bmp");
		        filter.setDescription("BMP Images");
		        chooser.setFileFilter(filter);
		
		        int returnVal = chooser.showOpenDialog(ab);
		       
		        input=chooser.getSelectedFile().getName();
		       
		        Filters.isolate_Chans(input);
		        Draw mm=new Draw(Filters.Rmatrix,Filters.Gmatrix,Filters.Bmatrix,5);		        
		        frame=new JFrame();
		        setVisible(false);
		        c=frame.getContentPane();		        
		        c.add(mm);
		        frame.setJMenuBar(bar);
		        frame.setTitle("Image");
		        frame.setSize(Filters.width,Filters.height+20);
		        frame.setVisible(true);		       
		        
		      }
		      catch(Exception ex){  }
  			}}
  	);	
  
  		
  	RGB_item.addActionListener(
  		new ActionListener(){
  			public void actionPerformed(ActionEvent e) 
  			{
  			  try{
  				Filters.isolate_Chans(input);
		        Draw mm=new Draw(Filters.Rmatrix,Filters.Gmatrix,Filters.Bmatrix,5);		             
		        frame.setVisible(false);
		        frame=new JFrame();
		        c=frame.getContentPane();
		        c.add(mm);		        
		        frame.setJMenuBar(bar);
		        frame.setTitle("Image");
		        frame.setSize(Filters.width,Filters.height+20);
		        frame.setVisible(true);	
		        }
		      catch(Exception ex){}	      		        
  			}
  		});	
  	
  	close.addActionListener(
  		new ActionListener(){
  			public void actionPerformed(ActionEvent e) 
  			{
  				System.exit(0);
  			}
  		});
  	
  	
  	red_item.addActionListener(
  		new ActionListener(){
  			public void actionPerformed(ActionEvent e)
  			{
  				try{
  				Filters ff=new Filters(input,1);	   		
	            c.add(ff);
  		    	}
  			    catch(Exception ex)
  			    {}  			    
  			}}
  	);
  	
   	green_item.addActionListener(
  		new ActionListener(){
  			public void actionPerformed(ActionEvent e)
  			{
  				try{
  				 Filters ff=new Filters(input,2);  			   		  			   
  			     c.add(ff);
  		        }  			 
  			    catch(Exception ex)
  			    {}  
  			} }
  	);
  	
  	 blue_item.addActionListener(
  		new ActionListener(){
  			public void actionPerformed(ActionEvent e)
  			{	
  				try{
  				Filters ff=new Filters(input,3);  			   		
  			    c.add(ff);
  			    }
  			    catch(Exception ex)
  			    {}  
  			}}
    	);
    	
    	gray_item.addActionListener(
  		new ActionListener(){
  			public void actionPerformed(ActionEvent e)
  			{
  				try{
  				Filters ff=new Filters(input,4);  			   		
  			    c.add(ff);
  			    } 			  
  			    catch(Exception ex)
  			    {}  			    
  			}}
  	);
  	  
  	//---------------- Histogram-----------------------//
  	  
  		Ritem.addActionListener(
  		new ActionListener(){
  			public void actionPerformed(ActionEvent e)
  			{
  				try{  					
  				Histogram hh=new Histogram(Filters.Rmatrix,1);  			   		
  			    } 			  
  			    catch(Exception ex)
  			    {}  			    
  			}}
  	);
  	    	  
  	  	Gitem.addActionListener(
  		new ActionListener(){
  			public void actionPerformed(ActionEvent e)
  			{
  				try{
  				Histogram hh=new Histogram(Filters.Gmatrix,2);  			   		
  			    } 			  
  			    catch(Exception ex)
  			    {}  			    
  			}}
  	);
  	  
  	  	Bitem.addActionListener(
  		new ActionListener(){
  			public void actionPerformed(ActionEvent e)
  			{
  				try{
  				Histogram hh=new Histogram(Filters.Bmatrix,3);  			   		
  			    } 			  
  			    catch(Exception ex)
  			    {}  			    
  			}}
  	);
  		GRitem.addActionListener(
  		new ActionListener(){
  			public void actionPerformed(ActionEvent e)
  			{
  				try{
  				int gray_chan[][]=Filters.getGray(Filters.Rmatrix,Filters.Gmatrix,Filters.Bmatrix);
  				Histogram hh=new Histogram(gray_chan,4);  			   		
  			    } 			  
  			    catch(Exception ex)
  			    {}  			    
  			}}
  	);
  	//---------------- Lookup Table-----------------------// 
  	platte1.addActionListener(
  		new ActionListener(){
  			public void actionPerformed(ActionEvent e)
  			{
  				Lookup_Table look1=new Lookup_Table(Filters.Rmatrix,1);
  				Draw mm=new Draw(Filters.Rmatrix,Filters.Gmatrix,Filters.Bmatrix,5);
  			    frame.setVisible(false);
  			    frame=new JFrame();
		        c=frame.getContentPane();
		        c.add(mm);
		        setVisible(false);
		        frame.setJMenuBar(bar);
		        frame.setTitle("Image");
		        frame.setSize(Filters.width,Filters.height+20);
		        frame.setVisible(true);  
  									
  			}
  		});
  		
  	platte2.addActionListener(
  		new ActionListener(){
  			public void actionPerformed(ActionEvent e)
  			{
  				Lookup_Table look2=new Lookup_Table(Filters.Gmatrix,2);
  				Draw mm=new Draw(Filters.Rmatrix,Filters.Gmatrix,Filters.Bmatrix,5);
  			    frame.setVisible(false);
  			    frame=new JFrame();
		        c=frame.getContentPane();
		        c.add(mm);
		        setVisible(false);
		        frame.setJMenuBar(bar);
		        frame.setTitle("Image");
		        frame.setSize(Filters.width,Filters.height+20);
		        frame.setVisible(true);
  			}
  		});	
  		
  	platte3.addActionListener(
  		new ActionListener(){
  			public void actionPerformed(ActionEvent e)
  			{
  				Lookup_Table look3=new Lookup_Table(Filters.Bmatrix,3);
  				Draw mm=new Draw(Filters.Rmatrix,Filters.Gmatrix,Filters.Bmatrix,5);
  			    frame.setVisible(false);
  			    frame=new JFrame();
		        c=frame.getContentPane();
		        c.add(mm);
		        setVisible(false);
		        frame.setJMenuBar(bar);
		        frame.setTitle("Image");
		        frame.setSize(Filters.width,Filters.height+20);
		        frame.setVisible(true);
  			}
  		});
  		
  	//------------------- Gomma ------------------------// 
  	Rgomma.addActionListener(
  		new ActionListener(){
  			public void actionPerformed(ActionEvent e)
  			{
  				Opers opgo=new Opers();
  				opgo.gommac(Filters.Rmatrix,1);
  				Draw mm=new Draw(Filters.Rmatrix,Filters.Gmatrix,Filters.Bmatrix,5);
  			    frame.setVisible(false);
  			    frame=new JFrame();
		        c=frame.getContentPane();
		        c.add(mm);
		        setVisible(false);
		        frame.setJMenuBar(bar);
		        frame.setTitle("Image");
		        frame.setSize(Filters.width,Filters.height+20);
		        frame.setVisible(true);  
  									
  			}
  		});
  		
  	Ggomma.addActionListener(
  		new ActionListener(){
  			public void actionPerformed(ActionEvent e)
  			{
  				Opers opgo=new Opers();
  				opgo.gommac(Filters.Gmatrix,2);
  				Draw mm=new Draw(Filters.Rmatrix,Filters.Gmatrix,Filters.Bmatrix,5);
  			    frame.setVisible(false);
  			    frame=new JFrame();
		        c=frame.getContentPane();
		        c.add(mm);
		        setVisible(false);
		        frame.setJMenuBar(bar);
		        frame.setTitle("Image");
		        frame.setSize(Filters.width,Filters.height+20);
		        frame.setVisible(true);
  			}
  		});	
  		
  	Bgomma.addActionListener(
  		new ActionListener(){
  			public void actionPerformed(ActionEvent e)
  			{
  				Opers opgo=new Opers();
  				opgo.gommac(Filters.Bmatrix,3);
  				Draw mm=new Draw(Filters.Rmatrix,Filters.Gmatrix,Filters.Bmatrix,5);
  			    frame.setVisible(false);
  			    frame=new JFrame();
		        c=frame.getContentPane();
		        c.add(mm);
		        setVisible(false);
		        frame.setJMenuBar(bar);
		        frame.setTitle("Image");
		        frame.setSize(Filters.width,Filters.height+20);
		        frame.setVisible(true);
  			}
  		});	
  	//-------------------- Operations ----------------------// 
  	stret.addActionListener(
  		new ActionListener(){
  			public void actionPerformed(ActionEvent e)
  			{
  				Opers opst=new Opers();
  				Filters.Rmatrix=opst.stretch(Filters.Rmatrix);
  				Filters.Gmatrix=opst.stretch(Filters.Gmatrix);
  				Filters.Bmatrix=opst.stretch(Filters.Bmatrix); 
  				Draw mm=new Draw(Filters.Rmatrix,Filters.Gmatrix,Filters.Bmatrix,5);
  			    frame.setVisible(false);
  			    frame=new JFrame();
		        c=frame.getContentPane();
		        c.add(mm);
		        setVisible(false);
		        frame.setJMenuBar(bar);
		        frame.setTitle("Image");
		        frame.setSize(Filters.width,Filters.height+20);
		        frame.setVisible(true);
  			}
  		});
  	 
	setTitle("Image");
	setLocation(10,10);
	setSize(350,150);
  	setVisible(true);
  }
  
   public static void main(String args[]) throws IOException,Exception
	{
		MenuFile file1=new MenuFile();
		file1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
	}
}