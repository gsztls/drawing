package com.antony.Draw0823;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class line implements MouseListener{
	 private Graphics G;
     private int x1,x2,y1,y2;
     public line(Graphics g){
    	 G = g;
     }
	 public void mouseClicked(MouseEvent e){
		 
	 }
	 
	 public void mousePressed(MouseEvent e){
	   	x1=e.getX();
	   	y1=e.getY();
	 }
	 
	 public void mouseReleased(MouseEvent e){
	   	x2=e.getX();
	    y2=e.getY();
	    G.drawLine(x1, y1, x2, y2);
	 }
	 
	 public void mouseEntered(MouseEvent e){
	    	
	 }
	 
	 public void mouseExited(MouseEvent e){
	  	
	 }
}

