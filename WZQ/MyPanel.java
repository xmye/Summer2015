package ������;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanel extends JPanel  {
private Board b = null;
	
	public MyPanel(Board b) {
		this.b = b;
	}
	
	public void paint(Graphics g) {
		g.setColor(new Color(165, 185, 75));	
		g.fillRect(35, 35, 525, 525);	// ���Ʊ���
		g.setColor(Color.BLACK);
		for (int i = 0; i < 15; i++) {	// ������������
			g.drawLine(50, 50 + i * 35, 540, 50 + i * 35);
			g.drawLine(50 + i * 35, 50, 50 + i * 35, 540);
		}
		g.fillOval(290, 290, 10, 10);	// ������Ԫ
		b.draw(g);	// ��������
	}
}


