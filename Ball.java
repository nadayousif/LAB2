import java.applet.Applet;
import java.awt.Graphics;
import java.awt.*; 



public class Ball extends Applet implements Runnable{
   Thread th;
   private int x;
   private int y;
   private int flag_x;
   private int flag_y;
   public void init(){
    th = new Thread(this);
    th.start();
    x=0;
    y=200;
    flag_x =1;
    flag_y =1;
   }
   
   public void paint(Graphics g){
    Date d = new Date();
	g.setColor(Color.RED);
	g.fillOval(x, y, 20, 20);
    
	
   }
   public void update(){
	 
	    if (y<=getHeight()/2 &&  x <getWidth()/2   &&  flag_y==1 && flag_x==1 )
	   {
		   y=y-10;
		   flag_y=1;
		   x=x+10;
		   flag_x=1;
		   
		   
	   }
	   else if (y<=getHeight()/2 &&  x <getWidth() && flag_y==1 && flag_x==1)
	   {
            y=y+10;		  		
			x=x+10;
			
			if (x ==getWidth() || y ==getHeight( ))
			{
			  flag_x=-1;
              flag_y=1;			
			}
			
	   }
	   else if (y >=getHeight()/2 &&  x>=getWidth()/2 && flag_y==1 &&  flag_x==-1)
	   {
            y=y+10;		
			x=x-10;
			if ( y ==getHeight() || x== getWidth()/2)
			{
				flag_y=-1;
				flag_x=-1;
			}
	   }
	    else if (y >=getHeight()/2 &&  x<=getWidth()/2 && flag_y==-1 && flag_x==-1)
	   {
            y=y-10;		
			x=x-10;
		    if (y==getHeight()/2 && x==0)
	        { 
		       flag_y=1;
		       flag_x=1;
	        }
	   }
	   
	   
   }
   
   public void run(){
    while(true){
        try{
			 update();
             repaint();
			 
             Thread.sleep(100); //you’ll need to catch an exception here
        }catch(InterruptedException ie){ie.printStackTrace();}
    }
   }
   
}

//javac -Xlint Ball.java
//appletviewer lab53.html