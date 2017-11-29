package com.study0520;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GameWZQ extends JFrame implements data{
	
		Mouse m=new Mouse();
		
		public void UI(){
			this.setTitle("Îå×ÓÆå");
			this.setSize(LENGTH,HEIGTH);
			this.setDefaultCloseOperation(3);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			
			Graphics g=this.getGraphics();
			
			this.addMouseListener(m);
			m.setG(g);
			m.setT(this);
			m.setArray(ARRAY);
		}
		
		public void paint(Graphics g){
			super.paint(g);
			for(int i=0;i<=ARRAY.length;i++){
			g.drawLine(data.WIDTH+i*data.WIDTH, 50, data.WIDTH+i*data.WIDTH, HEIGTH-50);
			g.drawLine(50, data.WIDTH+i*data.WIDTH, LENGTH-50,data.WIDTH+i*data.WIDTH );
		}
			for(int i=0;i<ARRAY.length;i++){
				for(int j=0;j<ARRAY.length;j++){
					if(ARRAY[i][j]==1){
						g.setColor(Color.BLACK);
						g.fillOval(30+m.hx*data.WIDTH, 30+m.dy*data.WIDTH, 40, 40);
					}else if(ARRAY[i][j]==2){
						g.setColor(Color.white);
						g.fillOval(30+m.hx*data.WIDTH, 30+m.dy*data.WIDTH, 40, 40);
					}
				}
			}
		}
		public static void main(String arg[]){
			GameWZQ game=new GameWZQ();
			game.UI();
		}
}

