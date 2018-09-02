package com.antony.Draw0823;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LineButton implements ActionListener{
    private JFrame J;
    private Graphics G;
    private JButton B;
    public LineButton(JFrame j,Graphics g,JButton b){
    	J=j;
    	G=g;
    	B=b;
    }
    
	public void actionPerformed(ActionEvent e) {
		
		Rect r =new Rect(G);
	    line l = new line(G);
	    Oval o = new Oval(G);
		Triangle t = new Triangle(G);
		Polygon p = new Polygon(G);
		Ifs i = new Ifs(G);
	    J.removeMouseListener(r);
	    J.removeMouseListener(l);
	    J.removeMouseListener(o);
	    J.removeMouseListener(t);
	    J.removeMouseListener(p);
	    J.removeMouseListener(i);
		if(B.getText().equals("����")){
		    J.addMouseListener(r);
		}
		else if(B.getText().equals("ֱ��")){	
			J.addMouseListener(l);
		}
		else if(B.getText().equals("Բ")){	
			J.addMouseListener(o);
		}
		else if(B.getText().equals("������")){	
			J.addMouseListener(t);
		}
		else if(B.getText().equals("�����")){	
			J.addMouseListener(p);
		}
		else if(B.getText().equals("����")){	
			J.addMouseListener(i);
		}
	}

}
