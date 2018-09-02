package com.antony.Draw0823;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Rect implements MouseListener{
	 private Graphics G;
     private int x1,x2,y1,y2;
     public Rect(Graphics g){
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
	    if(x1<x2){
	        G.drawRect(x1, y1, Math.abs(x2-x1), Math.abs(y2-y1));
	    }
	    else{
	    	G.drawRect(x2, y2, Math.abs(x2-x1), Math.abs(y2-y1));
	    }
	 }
	 
	 public void mouseEntered(MouseEvent e){
	    
	 }
	 
	 public void mouseExited(MouseEvent e){
	  	
	 }
}
