package com.antony.drawing0815;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import javax.swing.JTextField;

public class LineButton implements ActionListener, MouseListener {
	private Graphics G;
	private DrawFrame D;
	private JTextField T, Tx, Ty;
	private int x1, x2, y1, y2;
	private double xn, yn;
	private int[] x = new int[3];
	private int[] y = new int[3];
	private int clickCountTr = 0;
	private int clickCountPo = 0;
	private String Bt;
	private ShapeInfo[] array;
	private int Count = 0;

	public LineButton(ShapeInfo[] array, DrawFrame d, Graphics g, JTextField t, JTextField tx, JTextField ty) {
		this.array = array;
		D = d;
		G = g;
		T = t;
		Tx = tx;
		Ty = ty;
	}

	public void WriteFile() throws IOException {
		if (Bt.equals("保存")) {
			String fileName = Tx.getText();
			File f = new File("D://" + fileName + ".zjr");
			OutputStream out = new FileOutputStream(f);
			DataOutputStream dOut = new DataOutputStream(out);
			for (int i = 0; i < array.length; i++) {
				dOut.writeChar('|');
				for (int j = 0; j < array[i].dataCount.length; j++) {
					dOut.writeInt(array[i].dataCount[j]);
					// dOut.writeChar('|');

					// dOut.writeChar('|');
					// dOut.writeChars(array[j].C.toString());
					// dOut.writeChar('|');
					out.flush();
					dOut.flush();
				}
				dOut.writeChars(array[i].type);

				out.flush();
				dOut.flush();
			}
			out.close();
			dOut.close();
		}
	}

	public void ReadFile() throws IOException {
		if (Bt.equals("打开")) {
			String filePath = Ty.getText();
			InputStream in = new FileInputStream(filePath);
			DataInputStream dIn = new DataInputStream(in);
			while (true) {
			//	dIn.readChar();
				if (dIn.readChar() == -1) {
					System.out.println("读取完毕");
					break;
				}
				int[] readInt = new int[4];
				for (int i = 0; i < 4; i++) {
					readInt[i] = dIn.readInt();
					System.out.println(readInt[i]);
					// dIn.readChar();
				}
				char ty1 = dIn.readChar();
				char ty2 = dIn.readChar();
				String type = String.valueOf(ty1) + String.valueOf(ty2);
				// dIn.readChar();
				Random rand = new Random();
				double X = rand.nextDouble();
				double Y = rand.nextDouble();
				float CX = new Double(X).floatValue();
				float CY = new Double(Y).floatValue();
				float CZ = new Double(Y).floatValue();
				Color C = new Color(CX, CY, CZ);
				ShapeInfo readShape = new ShapeInfo(readInt, type, C);
				readShape.draw(G);
			}

			// System.out.println(a);
			// dIn.
		}
	}

	public void actionPerformed(ActionEvent e) {
		Bt = e.getActionCommand();
		clickCountTr = 0;
		clickCountPo = 0;
		try {
			WriteFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ReadFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch (Bt) {
		case "多边形":
			if (e.getClickCount() == 1) {
				x[2] = e.getX();
				y[2] = e.getY();
				G.drawLine(x[1], y[1], x[2], y[2]);
				int[] ptCount = { x[1], y[1], x[2], y[2] };
				ShapeInfo shapePt = new ShapeInfo(ptCount, "直线", G.getColor());
				array[Count++] = shapePt;
				x[1] = x[2];
				y[1] = y[2];
				// clickCount=0;
			}
			if (e.getClickCount() == 2) {
				x[2] = e.getX();
				y[2] = e.getY();
				G.drawLine(x[1], y[1], x[2], y[2]);
				int[] pthCount = { x[1], y[1], x[2], y[2] };
				ShapeInfo shapePth = new ShapeInfo(pthCount, "直线", G.getColor());
				array[Count++] = shapePth;
				G.drawLine(x[0], y[0], x[2], y[2]);
				int[] pfCount = { x[0], y[0], x[2], y[2] };
				ShapeInfo shapePf = new ShapeInfo(pfCount, "直线", G.getColor());
				array[Count++] = shapePf;
				clickCountPo = 0;
			}
			break;
		case "三角形":
			if (clickCountTr == 1) {
				x[2] = e.getX();
				y[2] = e.getY();
				G.drawLine(x[0], y[0], x[2], y[2]);
				int[] tthCount = { x[0], y[0], x[2], y[2] };
				ShapeInfo shapeTth = new ShapeInfo(tthCount, "直线", G.getColor());
				array[Count++] = shapeTth;
				G.drawLine(x[1], y[1], x[2], y[2]);
				int[] tfCount = { x[1], y[1], x[2], y[2] };
				ShapeInfo shapeTf = new ShapeInfo(tfCount, "直线", G.getColor());
				array[Count++] = shapeTf;
				clickCountTr = 0;
			}
			break;
		default:
			break;
		}

	}

	private void ifs(double x, double y) {
		if (Bt.equals("分行一")) {
			double a = -1.8, b = -2.0, c = -0.5, d = -0.9;
			for (int i = 0; i < 30000; i++) {
				xn = Math.sin(a * y) + c * Math.cos(a * x);
				yn = Math.sin(b * x) + d * Math.cos(b * y);
				int x1 = (int) (xn * 200 + 500);
				int y1 = (int) (yn * 200 + 450);
				G.drawLine(x1, y1, x1, y1);
				int[] ioCount = { x1, y1, x1, y1 };
				ShapeInfo shapeIo = new ShapeInfo(ioCount, "直线", G.getColor());
				array[Count++] = shapeIo;
				x = xn;
				y = yn;
			}
		}
		if (Bt.equals("分行二")) {
			double e = 1.641, f = 1.902, g = 0.316, h = 1.525;
			for (int i = 0; i < 30000; i++) {
				x = Math.sin(e * yn) - Math.cos(f * xn);
				y = Math.sin(g * xn) - Math.cos(h * y);
				int x1 = (int) (x * 200 + 500);
				int y1 = (int) (y * 200 + 500);
				G.setColor(new Color(0, 0, i / 100));
				G.drawLine(x1, y1, x1, y1);
				int[] itCount = { x1, y1, x1, y1 };
				ShapeInfo shapeIt = new ShapeInfo(itCount, "直线", G.getColor());
				array[Count++] = shapeIt;
				xn = x;
				yn = y;
			}
		}
		if (Bt.equals("分行三")) {
			double e = 0.970, f = -1.899, g = 1.381, h = -1.506;
			for (int i = 0; i < 30000; i++) {
				xn = Math.sin(e * y) - Math.cos(f * x);
				yn = Math.sin(g * x) - Math.cos(h * y);
				int x1 = (int) (xn * 100 + 500);
				int y1 = (int) (yn * 100 + 500);
				G.setColor(new Color(0, 0, i / 100));
				G.drawLine(x1, y1, x1, y1);
				int[] ithCount = { x1, y1, x1, y1 };
				ShapeInfo shapeIth = new ShapeInfo(ithCount, "直线", G.getColor());
				array[Count++] = shapeIth;
				x = xn;
				y = yn;
			}
		}
		if (Bt.equals("自定义分行")) {
			double Ran = Double.parseDouble(T.getText());
			// System.out.println(Ran);

			for (int j = 0; j < 1000; j++) {
				Random rand = new Random();
				double X = rand.nextDouble();
				double Y = rand.nextDouble();
				float CX = new Double(X).floatValue();
				float CY = new Double(Y).floatValue();
				float CZ = new Double(Y).floatValue();
				// if(X>x|| Y>y) break;
				// System.out.println(X);
				// System.out.println(Y);
				for (int i = 0; i < 2000; i++) {
					xn = X * Math.cos(Ran) - (Y - Math.pow(X, 2)) * Math.sin(Ran);
					yn = X * Math.sin(Ran) + (Y - Math.pow(X, 2)) * Math.cos(Ran);
					int x1 = (int) (xn * 200 + 500);
					int y1 = (int) (yn * 200 + 500);
					G.setColor(new Color(CX, CY, CZ));
					G.drawLine(x1, y1, x1, y1);
					int[] ifCount = { x1, y1, x1, y1 };
					ShapeInfo shapeIf = new ShapeInfo(ifCount, "直线", G.getColor());
					array[Count++] = shapeIf;
					X = xn;
					Y = yn;
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch (Bt) {
		case "多边形":
			if (clickCountPo == 0) {
				x[0] = e.getX();
				y[0] = e.getY();
			}
			break;
		case "直线":
			x1 = e.getX();
			y1 = e.getY();
			break;
		case "圆形":
			x1 = e.getX();
			y1 = e.getY();
			break;
		case "矩形":
			x1 = e.getX();
			y1 = e.getY();
			break;
		case "三角形":
			if (clickCountTr == 0) {
				x[0] = e.getX();
				y[0] = e.getY();
			}
			break;
		case "清除":
			x1 = e.getX();
			y1 = e.getY();
			break;
		default:
			break;
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch (Bt) {
		case "多边形":
			if (clickCountPo == 0) {
				x[1] = e.getX();
				y[1] = e.getY();
				G.drawLine(x[0], y[0], x[1], y[1]);
				int[] poCount = { x[0], y[0], x[1], y[1] };
				ShapeInfo shapePo = new ShapeInfo(poCount, "直线", G.getColor());
				array[Count++] = shapePo;
				clickCountPo++;
			}
			break;
		case "直线":
			x2 = e.getX();
			y2 = e.getY();
			G.drawLine(x1, y1, x2, y2);
			int[] lCount = { x1, y1, x2, y2 };
			System.out.println(x1);
			System.out.println(y1);
			ShapeInfo shapeLine = new ShapeInfo(lCount, Bt, G.getColor());
			array[Count++] = shapeLine;
			System.out.println(shapeLine.type);
			break;
		case "圆形":
			x2 = e.getX();
			y2 = e.getY();
			if (x1 < x2) {
				if (y1 < y2) {
					G.drawOval(x1, y1, Math.abs(x2 - x1), Math.abs(y2 - y1));
				} else {
					G.drawOval(x1, y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
				}
			} else {
				if (y1 > y2) {
					G.drawOval(x2, y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
				} else {
					G.drawOval(x2, y1, Math.abs(x2 - x1), Math.abs(y2 - y1));
				}
			}
			int[] oCount = { x1, y1, x2, y2 };
			ShapeInfo shapeOval = new ShapeInfo(oCount, Bt, G.getColor());
			array[Count++] = shapeOval;
			break;
		case "矩形":
			x2 = e.getX();
			y2 = e.getY();
			if (x1 < x2) {
				if (y1 < y2) {
					G.drawRect(x1, y1, Math.abs(x2 - x1), Math.abs(y2 - y1));
				} else {
					G.drawRect(x1, y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
				}
			} else {
				if (y1 > y2) {
					G.drawRect(x2, y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
				} else {
					G.drawRect(x2, y1, Math.abs(x2 - x1), Math.abs(y2 - y1));
				}
			}
			int[] rCount = { x1, y1, x2, y2 };
			ShapeInfo shapeRect = new ShapeInfo(rCount, Bt, G.getColor());
			array[Count++] = shapeRect;
			break;
		case "三角形":
			if (clickCountTr == 0) {
				x[1] = e.getX();
				y[1] = e.getY();
				G.drawLine(x[0], y[0], x[1], y[1]);
				int[] toCount = { x[0], y[0], x[1], y[1] };
				ShapeInfo shapeTo = new ShapeInfo(toCount, "直线", G.getColor());
				array[Count++] = shapeTo;
				clickCountTr++;
			}
			break;
		case "分行一":
			ifs(0, 0);
			break;
		case "分行二":
			ifs(0, 0);
			break;
		case "分行三":
			ifs(0, 0);
			break;
		case "自定义分行":
			double ifsx = Double.parseDouble(Tx.getText());
			double ifsy = Double.parseDouble(Ty.getText());
			ifs(ifsx, ifsy);
			break;
		case "清除":
			x2 = e.getX();
			y2 = e.getY();
			if (x1 < x2) {
				if (y1 < y2) {
					G.clearRect(x1, y1, Math.abs(x1 - x2), Math.abs(y1 - y2));
				} else {
					G.clearRect(x1, y2, Math.abs(x1 - x2), Math.abs(y1 - y2));
				}
			} else {
				if (y1 > y2) {
					G.clearRect(x2, y2, Math.abs(x1 - x2), Math.abs(y1 - y2));
				} else {
					G.clearRect(x2, y1, Math.abs(x1 - x2), Math.abs(y1 - y2));
				}
			}
			int[] cCount = { x1, y1, x2, y2 };
			ShapeInfo shapeClear = new ShapeInfo(cCount, Bt, G.getColor());
			array[Count++] = shapeClear;
			break;
		default:
			break;
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
