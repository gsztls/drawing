
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
	    jsf.setTitle("登录");
	    jsf.setDefaultCloseOperation(3);   //设置退出程序方法
	    jsf.setLocationRelativeTo(null);   //设置居中显示
	    jsf.setResizable(false);
	    java.awt.FlowLayout jaf = new java.awt.FlowLayout();
	    jsf.setLayout(jaf);
	    JButton jsb_line = new JButton("直线");
	    jsf.add(jsb_line);
	    JButton jsb_3d = new JButton("3D图形");
	    jsf.add(jsb_3d);
	    jsf.setVisible(true);
	    Graphics g = jsf.getGraphics();
	    DrawListener dr = new DrawListener(g);
	    jsf.addMouseListener(dr);
	    
    }
	public static void DrawOval(){
	    javax.swing.JFrame jsf = new javax.swing.JFrame();
	    jsf.setSize(1000,900);
	    jsf.setTitle("画图板");
	    jsf.setDefaultCloseOperation(3);   //设置退出程序方法
	    jsf.setLocationRelativeTo(null);   //设置居中显示
	    jsf.setResizable(false);  //是否能改变窗口大小
	    java.awt.FlowLayout jaf = new java.awt.FlowLayout();
	    jsf.setLayout(jaf);
	    JButton jsb_line = new JButton("直线");
	    jsf.add(jsb_line);
	    JButton jsb_3d = new JButton("3D图形");
	    jsf.add(jsb_3d);
	    jsf.setVisible(true);
	    Graphics g = jsf.getGraphics();
	    DrawListener dr = new DrawListener(g);
	    jsf.addMouseListener(dr);
	    
    }
	
}


