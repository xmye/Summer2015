package com.study05102;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonListener implements ActionListener {
		private String s  = "ֱ��";
		private Color color;
		
		public String getS(){
			return s;
		}
		public Color getColor(){
			return color;
		}
	@Override
	public void actionPerformed(ActionEvent e) {

		 if(e.getActionCommand().equals("")){
			 //��ȡ��ǰ�¼�Դ����
			 JButton jbu=(JButton)e.getSource();
			 //��ȡ��ɫ��ť�ı���ɫ
			color =  jbu.getBackground();
			System.out.println("color= "+color);
		 }else {
				//	��ȡ��ť�ϵ��ַ���
			 s = e.getActionCommand();
		 }
//		System.out.println("s = "+s);
	}
}
