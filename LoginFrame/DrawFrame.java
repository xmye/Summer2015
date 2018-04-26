package com.study0510;

import java.awt.Graphics;



import javax.swing.JFrame;

public class DrawFrame extends JFrame{

	//显示界面的方法
	public void initUI(){
		this.setSize(600,600);
		this.setTitle("画图板");
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);    //设置窗体居中
		this.setVisible(true);
		
		//重窗体上获取画笔,一定要在窗体显示可见之后获取
		Graphics g = this.getGraphics();

		DrameListener d = new DrameListener();
		//给窗体对象添加鼠标监听器
		this.addMouseListener(d);
		d.setG(g);
	}
	public static void main(String[] args) {
		DrawFrame d = new DrawFrame();
		d.initUI();
	}
}
