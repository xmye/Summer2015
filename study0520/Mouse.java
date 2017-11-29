package com.study0520;

import java.awt.Color;


import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Mouse implements MouseListener,data{
	private  Graphics g;

	private GameWZQ jf;
	private int array[][];
	private int flag=1;
	private int x1,y1;
	public int hx,dy;
	
		public void setG(Graphics g){
		this.g=g;
	}

		public void setT(GameWZQ jf){
			this.jf=jf;
		}
		
		public void setArray(int [][] array){
			this.array=array;
		}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(flag==1){
		g.setColor(Color.BLACK);
		g.fillOval(30+hx*WIDTH, 30+dy*WIDTH, 40, 40);
		array[hx][dy]=flag;
		flag++;
	}else if(flag==2){
		g.setColor(Color.white);
		g.fillOval(30+hx*WIDTH, 30+dy*WIDTH, 40, 40);
		array[hx][dy]=flag;
		flag--;
	}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		x1=e.getX();
		y1=e.getY();
		if((x1-WIDTH)%WIDTH>WIDTH/2){
			hx=(x1-WIDTH)/WIDTH+1;
		}else{
			hx=(x1-WIDTH)/WIDTH;
		}
		if((y1-WIDTH)%WIDTH>WIDTH/2){
			dy=(y1-WIDTH)/WIDTH+1;
		}else{
			dy=(y1-WIDTH)/WIDTH;
		}
		 System.out.println(hx+"++========"+dy+"  "+WIDTH);
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
