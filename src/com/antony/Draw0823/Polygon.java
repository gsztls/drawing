package com.antony.Draw0823;


import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Polygon implements MouseListener{
	 private Graphics G;
     private int[] x = new int[3];
     private int[] y = new int[3];
     private int clickCount = 0;
     public Polygon(Graphics g){
    	 G = g;
     }
	 public void mouseClicked(MouseEvent e){

		if(e.getClickCount() == 1){
	        x[2]=e.getX();
	        y[2]=e.getY();
	        G.drawLine(x[1], y[1], x[2], y[2]);
	        x[1]=x[2];
	        y[1]=y[2];
	     //   clickCount=0;
		}
		if(e.getClickCount() ==2)
		{
			x[2]=e.getX();
			y[2]=e.getY();
			G.drawLine(x[1], y[1], x[2], y[2]);
			G.drawLine(x[0], y[0], x[2], y[2]);
			clickCount=0;
		}
	 }
	 
	 public void mousePressed(MouseEvent e){
		if(clickCount == 0){
		   x[0]=e.getX();
		   y[0]=e.getY();
		}
	 }
	 
	 public void mouseReleased(MouseEvent e){
		 if(clickCount == 0){
		    x[1]=e.getX();
		    y[1]=e.getY();
		    G.drawLine(x[0], y[0], x[1], y[1]);
		    clickCount++;
		 }
	 }
	 
	 public void mouseEntered(MouseEvent e){

	 }
	 
	 public void mouseExited(MouseEvent e){
	  	
	 }
}
