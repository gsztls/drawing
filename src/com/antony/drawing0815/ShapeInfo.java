package com.antony.drawing0815;

import java.awt.Color;
import java.awt.Graphics;

public class ShapeInfo {
	
	String type;
	Color C;
    int[] dataCount = new int[100];
	ShapeInfo(int[] dataCount, String type, Color C) {
		this.dataCount = dataCount;
		this.type = type;
		this.C = C;
	}
	void draw(Graphics g){
		//System.out.println(type);
		switch (type){
		
		case "直线":
			g.setColor(C);
			g.drawLine(dataCount[0], dataCount[1], dataCount[2], dataCount[3]);
		    break;
		case "圆形":
			g.setColor(C);
			if (dataCount[0] < dataCount[2]) {
				if (dataCount[1] < dataCount[3]) {
					g.drawOval(dataCount[0], dataCount[1], Math.abs(dataCount[2] - dataCount[0]), Math.abs(dataCount[3] - dataCount[1]));
				} else {
					g.drawOval(dataCount[0], dataCount[3], Math.abs(dataCount[2] - dataCount[0]), Math.abs(dataCount[3] - dataCount[1]));
				}
			} else {
				if (dataCount[1] > dataCount[3]) {
					g.drawOval(dataCount[2], dataCount[3], Math.abs(dataCount[2] - dataCount[0]), Math.abs(dataCount[3] - dataCount[1]));
				} else {
					g.drawOval(dataCount[2], dataCount[1], Math.abs(dataCount[2] - dataCount[0]), Math.abs(dataCount[3] - dataCount[1]));
				}
			}
			break;
			case "矩形":
			g.setColor(C);
			if (dataCount[0] < dataCount[2]) {
				if (dataCount[1] < dataCount[3]) {
					g.drawRect(dataCount[0], dataCount[1], Math.abs(dataCount[2] - dataCount[0]), Math.abs(dataCount[3] - dataCount[1]));
				} else {
					g.drawRect(dataCount[0], dataCount[3], Math.abs(dataCount[2] - dataCount[0]), Math.abs(dataCount[3] - dataCount[1]));
				}
			} else {
				if (dataCount[1] > dataCount[3]) {
					g.drawRect(dataCount[2], dataCount[3], Math.abs(dataCount[2] - dataCount[0]), Math.abs(dataCount[3] - dataCount[1]));
				} else {
					g.drawRect(dataCount[2], dataCount[1], Math.abs(dataCount[2] - dataCount[0]), Math.abs(dataCount[3] - dataCount[1]));
				}
			}
			break;
		}
		
	}
}
