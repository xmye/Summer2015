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
              //��ʾ����
	 public void initUI(){
		 this.setSize(600,600);
		 this.setTitle("��ͼ��");
		 this.setDefaultCloseOperation(3);
		 this.setLocationRelativeTo(null);
		 this.setVisible(true);
		 //�Ӵ����ϻ�ȡ���ʣ��ڴ���ɼ�֮���ȡ
		 Graphics g=this.getGraphics();
		 
		 DrameListener d=new DrameListener();
		 //���������������������
	    this.addMouseListener(d);           
	    d.setG(g);
	    
	 }

	 
	 public static void main(String[] args){
		 DrameFrame d=new DrameFrame();
		 d.initUI();
	 }
	 
}
