package com.study0510;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrameListener implements MouseListener{
	private Graphics g;   //����һ���ı����������մ��ݹ����Ķ���
	private int x1,y1,x2,y2;
	
	//����һ��set�����������ݶ���
	public void setG( Graphics g){
		this.g = g;  
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		 x1 = e.getX();
		  y1 = e.getY();
		System.out.println("x1 = "+x1 +"     y1 = "+y1);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		 x2 = e.getX();
		 y2 = e.getY();
		System.out.println("x2 = "+x2 +"     y2 = "+y2);
		g.drawLine(x1, y1, x2, y2);
		g.drawOval(x1, y1, Math.abs(x2-x1),Math.abs( y2-y1));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}
