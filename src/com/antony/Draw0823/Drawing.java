
package com.antony.Draw0823;

import java.awt.Graphics;

import javax.swing.JButton;

public class Drawing {

	public static void main(String [] args){
		
		showUI();
		
	}	
	public static void showUI(){
	    javax.swing.JFrame jsf = new javax.swing.JFrame();
	    jsf.setSize(1000,900);
	    jsf.setTitle("画板");
	    jsf.setDefaultCloseOperation(3);   //设置退出程序方法
	    jsf.setLocationRelativeTo(null);   //设置居中显示
	    jsf.setResizable(false);
	    java.awt.FlowLayout jaf = new java.awt.FlowLayout();
	    jsf.setLayout(jaf);
	    JButton jsb_line = new JButton("直线");
	    jsf.add(jsb_line);    
	    JButton jsb_Rct = new JButton("矩形");
	    jsf.add(jsb_Rct);
	    JButton jsb_Ova = new JButton("圆");
	    jsf.add(jsb_Ova);
	    JButton jsb_Tri = new JButton("三角形");
	    jsf.add(jsb_Tri);
	    JButton jsb_Pol = new JButton("多边形");
	    jsf.add(jsb_Pol);
	    JButton jsb_Ifs = new JButton("分行");
	    jsf.add(jsb_Ifs);
	    jsf.setVisible(true);
	    Graphics g = jsf.getGraphics();
	    LineButton l = new LineButton(jsf, g, jsb_line);
	    jsb_line.addActionListener(l);
	    LineButton r = new LineButton(jsf, g, jsb_Rct);
	    jsb_Rct.addActionListener(r);
	    LineButton o = new LineButton(jsf, g, jsb_Ova);
	    jsb_Ova.addActionListener(o);
	    LineButton t = new LineButton(jsf, g, jsb_Tri);
	    jsb_Tri.addActionListener(t);
        LineButton p = new LineButton(jsf, g, jsb_Pol);
        jsb_Pol.addActionListener(p);
        LineButton i = new LineButton(jsf, g, jsb_Ifs);
        jsb_Ifs.addActionListener(i);
	    	    
    }
}


