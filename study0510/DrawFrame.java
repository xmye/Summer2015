package com.study0510;

import java.awt.Graphics;



import javax.swing.JFrame;

public class DrawFrame extends JFrame{

	//��ʾ����ķ���
	public void initUI(){
		this.setSize(600,600);
		this.setTitle("��ͼ��");
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);    //���ô������
		this.setVisible(true);
		
		//�ش����ϻ�ȡ����,һ��Ҫ�ڴ�����ʾ�ɼ�֮���ȡ
		Graphics g = this.getGraphics();

		DrameListener d = new DrameListener();
		//��������������������
		this.addMouseListener(d);
		d.setG(g);
	}
	public static void main(String[] args) {
		DrawFrame d = new DrawFrame();
		d.initUI();
	}
}
