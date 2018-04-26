package com.study05102;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
//实现鼠标，拖动监听器的类
public class DrameListener implements MouseListener,MouseMotionListener{
	private int x1,x2,y1,y2;                       //点击时获得的坐标
	private Graphics g;                             
	private String s;                                 //s用于获得文本框中的字符串
	private ButtonListener but;
	private Color color;                              
	private int ax,ay,bx,by,cx,cy;                      //画三角形的坐标
	private int flag=1;                     
	
	public String getS(){
		return s;
	}
	
	//
	public void setBut(ButtonListener but){
		this.but = but;
	}
	
	public void setG(Graphics g){
		this.g=g;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//通过标志找到点击过的点
		if(flag == 1 && s.equals("三角形")){
			ax = e.getX();
			ay = e.getY();
			flag++;
		}else if(flag == 2){
			bx = e.getX();
			by = e.getY();
			flag++;
		}else if(flag == 3){
			cx = e.getX();
			cy = e.getY();
			g.drawLine(ax, ay,bx, by);
			g.drawLine(bx, by,cx, cy);
			g.drawLine(ax, ay,cx, cy);
			flag = 1;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1=e.getX();
		y1=e.getY();
		s = but.getS();
		color =  but.getColor();                       
		g.setColor(color);                                           //按下时获得颜色
		System.out.println("but,getS()="+s);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x2=e.getX();
		y2=e.getY();
		if(s.equals("直线")){
			System.out.println("x2 = "+x2 +"     y2 = "+y2);
			g.drawLine(x1, y1, x2, y2);
		}
		else if(s.equals("椭圆")){
				for(int i=1;i<=100;i++){
				g.setColor(new Color(2*i,i+100,0));
				g.fillOval(x1+i/2, y1+i/2, Math.abs(x1-x2)-i, Math.abs(y2-y1)-i);
				}
		}
		else if(s.equals("矩形")){
			g.drawLine(x1, y1, x1,y2);
		    g.drawLine(x1, y1, x2, y1);
		    g.drawLine(x2, y1, x2, y2);
		    g.drawLine(x1, y2, x2, y2);
		}
//		else if(s.equals("三角形")){
//		   g.drawLine(x1, y1, x2, y2);
//		   g.drawLine(x1, y1, x1, y2);
//		   g.drawLine(x1, y2, x2, y2);
//		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
   
	//实现拖动
	public void mouseDragged(MouseEvent e) {
		System.out.println(">>>>>>>>>>>");
		// TODO Auto-generated method stub
		if(s.equals("铅笔")){
		x2=e.getX();
		y2=e.getY();
		g.drawLine(x1, y1, x2, y2);
		x1=x2;y1=y2;
	}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}
}

    