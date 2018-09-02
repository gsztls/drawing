package com.antony.Draw0823;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ifs implements MouseListener{
	 private Graphics G;
     private double x=0,y=0,xn,yn;
     public Ifs(Graphics g){
    	 G = g;
     }
	 public void mouseClicked(MouseEvent e){
		 
	 }
	 
	 public void mousePressed(MouseEvent e){
	   
	 }
	 
	 private void ifs(double x, double y){
	   	 double a=-1.8,b=-2.0,c=-0.5,d=-0.9;
	   	 for(int i=0;i<30000;i++){
	   	  	 xn = Math.sin(a*y)+c*Math.cos(a*x);
	   	  	 yn = Math.sin(b*x)+d*Math.cos(b*y);
	   	     int x1 = (int)(xn*200+500);
			 int y1 = (int)(yn*200+400);
			 G.drawLine(x1, y1, x1, y1);
			 x = xn;
			 y = yn;
	   	 }
	 }

	 public void mouseReleased(MouseEvent e){
	     ifs(x,y);
	 }
	 
	 public void mouseEntered(MouseEvent e){
	    	
	 }
	 
	 public void mouseExited(MouseEvent e){
	  	
	 }
}


