import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawLine extends Applet{
	int x1;
	int y1;
	int x2;
	int y2;
	boolean mouseDragged;
	ArrayList<Point> pointsList = new ArrayList<>();
	public void init(){
		mouseDragged = false;
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent me){
			    x1=me.getX();
				y1=me.getY();
			}
			public void mouseReleased(MouseEvent me){
				x2=me.getX();
				y2=me.getY();
				if(mouseDragged){
					pointsList.add(new Point(x1,y1));
					pointsList.add(new Point(x2,y2));
					repaint();
				}
				mouseDragged = false;
			}
		});
		this.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent me){
					x2=me.getX();
					y2=me.getY();
					repaint();
					mouseDragged = true;
			}
		});
	}
	public void paint(Graphics g){
		for(int i = 0 ; i < pointsList.size()-1;){
			if(i+1 < pointsList.size()){
				g.drawLine((int)pointsList.get(i).getX(),(int)pointsList.get(i).getY(),(int)pointsList.get(i+1).getX(),(int)pointsList.get(i+1).getY());
				i+=2;
			}
		}
		g.drawLine(x1,y1,x2,y2);
	}
}