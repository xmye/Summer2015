package com.study05102;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.study0429.ButtonListener;


public class DrameFrame extends JFrame {
              //显示界面
	 public void initUI(){
		 this.setSize(600,600);
		 this.setTitle("画图板");
		 this.setDefaultCloseOperation(3);
		 this.setLocationRelativeTo(null);
		 this.setVisible(true);
		 //从窗体上获取画笔，在窗体可见之后获取
		 Graphics g=this.getGraphics();
		 
		 DrameListener d=new DrameListener();
		 //给窗体对象增添鼠标监听器
	    this.addMouseListener(d);           
	    d.setG(g);
	    
	 }

	 
	 public static void main(String[] args){
		 DrameFrame d=new DrameFrame();
		 d.initUI();
	 }
	 
}
