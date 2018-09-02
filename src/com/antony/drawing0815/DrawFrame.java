package com.antony.drawing0815;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class DrawFrame extends JFrame{

	ShapeInfo[] array = new ShapeInfo[100000000]; 
	public void paint(Graphics g) {
		g.setColor(Color.white);
		super.paint(g);
		for(int i =0;i<array.length;i++)	{
			array[i].draw(g);
		}
	}
	

}
