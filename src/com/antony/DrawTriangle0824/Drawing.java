
package com.antony.DrawTriangle0824;

import java.awt.Graphics;

import javax.swing.JButton;

public class Drawing {

	public static void main(String [] args){
		
		showUI();
		
	}	
	public static void showUI(){
	    javax.swing.JFrame jsf = new javax.swing.JFrame();
	    jsf.setSize(1000,900);
	    jsf.setTitle("��¼");
	    jsf.setDefaultCloseOperation(3);   //�����˳����򷽷�
	    jsf.setLocationRelativeTo(null);   //���þ�����ʾ
	    jsf.setResizable(false);
	    java.awt.FlowLayout jaf = new java.awt.FlowLayout();
	    jsf.setLayout(jaf);
	    JButton jsb_line = new JButton("ֱ��");
	    jsf.add(jsb_line);
	    JButton jsb_3d = new JButton("3Dͼ��");
	    jsf.add(jsb_3d);
	    jsf.setVisible(true);
	    Graphics g = jsf.getGraphics();
	    DrawListener dr = new DrawListener(g);
	    jsf.addMouseListener(dr);
	    
    }
	public static void DrawOval(){
	    javax.swing.JFrame jsf = new javax.swing.JFrame();
	    jsf.setSize(1000,900);
	    jsf.setTitle("��ͼ��");
	    jsf.setDefaultCloseOperation(3);   //�����˳����򷽷�
	    jsf.setLocationRelativeTo(null);   //���þ�����ʾ
	    jsf.setResizable(false);  //�Ƿ��ܸı䴰�ڴ�С
	    java.awt.FlowLayout jaf = new java.awt.FlowLayout();
	    jsf.setLayout(jaf);
	    JButton jsb_line = new JButton("ֱ��");
	    jsf.add(jsb_line);
	    JButton jsb_3d = new JButton("3Dͼ��");
	    jsf.add(jsb_3d);
	    jsf.setVisible(true);
	    Graphics g = jsf.getGraphics();
	    DrawListener dr = new DrawListener(g);
	    jsf.addMouseListener(dr);
	    
    }
	
}


