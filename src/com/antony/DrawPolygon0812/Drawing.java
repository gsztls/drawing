
package com.antony.DrawPolygon0812;

import java.awt.Graphics;

import javax.swing.JButton;

public class Drawing {

	public static void main(String [] args){
		
		showUI();
		
	}	
	public static void showUI(){
	    javax.swing.JFrame jsf = new javax.swing.JFrame();
	    jsf.setSize(1000,900);
	    jsf.setTitle("������");
	    jsf.setDefaultCloseOperation(3);   //�����˳����򷽷�
	    jsf.setLocationRelativeTo(null);   //���þ�����ʾ
	    jsf.setResizable(false);
	    java.awt.FlowLayout jaf = new java.awt.FlowLayout();
	    jsf.setLayout(jaf);
	    jsf.setVisible(true);
	    Graphics g = jsf.getGraphics();
	    DrawListener dr = new DrawListener(g);
	    jsf.addMouseListener(dr);
	    
    }
	
}


