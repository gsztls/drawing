
package com.antony.drawing0815;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Drawing {

	public static void main(String [] args){
		showUI();
	}	
	public static void showUI(){
	    DrawFrame jsf = new DrawFrame();
	    jsf.setSize(1000,900);
	    jsf.setTitle("����");
	    jsf.setDefaultCloseOperation(3);   //�����˳����򷽷�
	    jsf.setLocationRelativeTo(null);   //���þ�����ʾ
	 //   jsf.setResizable(false);
	    java.awt.FlowLayout jaf = new java.awt.FlowLayout();
	    jsf.setLayout(jaf);
	    JButton jsb_line = new JButton("ֱ��");
	    jsf.add(jsb_line);    
	    JButton jsb_Rct = new JButton("����");
	    jsf.add(jsb_Rct);
	    JButton jsb_Ova = new JButton("Բ��");
	    jsf.add(jsb_Ova);
	    JButton jsb_Tri = new JButton("������");
	    jsf.add(jsb_Tri);
	    JButton jsb_Pol = new JButton("�����");
	    jsf.add(jsb_Pol);
	    JButton jsb_Ifs = new JButton("����һ");
	    jsf.add(jsb_Ifs);
	    JButton jsb_IfsT = new JButton("���ж�");
	    jsf.add(jsb_IfsT);
	    JButton jsb_IfsTh = new JButton("������");
	    jsf.add(jsb_IfsTh);
	    JButton jsb_Cle = new JButton("���");
	    jsf.add(jsb_Cle);
	    JButton jsb_IfsRan = new JButton("�Զ������");
	    jsf.add(jsb_IfsRan);
	    JTextField jst_IfsX = new JTextField("������xֵ");
	    jsf.add(jst_IfsX);
	    JTextField jst_IfsY = new JTextField("������yֵ");
	    jsf.add(jst_IfsY);
	    JTextField jst_Ifs = new JTextField("���������ֵ");
	    jsf.add(jst_Ifs);
	    JButton jsb_Sa = new JButton("����");
	    jsf.add(jsb_Sa);
	    JButton jsb_Op = new JButton("��");
	    jsf.add(jsb_Op);
	    jsf.setVisible(true);
	    Graphics g = jsf.getGraphics();
	    LineButton l = new LineButton(jsf.array,jsf,g,jst_Ifs,jst_IfsX,jst_IfsY);
	    jsf.addMouseListener(l);
	    jsb_line.addActionListener(l);
	    jsb_Rct.addActionListener(l);
	    jsb_Ova.addActionListener(l);
	    jsb_Tri.addActionListener(l);
        jsb_Pol.addActionListener(l);
        jsb_Ifs.addActionListener(l);
        jsb_Cle.addActionListener(l);
        jsb_IfsT.addActionListener(l);
        jsb_IfsTh.addActionListener(l);
        jsb_IfsRan.addActionListener(l);
        jsb_Op.addActionListener(l);
        jsb_Sa.addActionListener(l);
    }
}


