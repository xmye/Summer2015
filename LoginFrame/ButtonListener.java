package com.study05102;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonListener implements ActionListener {
		private String s  = "直线";
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
			 //获取当前事件源对象
			 JButton jbu=(JButton)e.getSource();
			 //获取颜色按钮的背景色
			color =  jbu.getBackground();
			System.out.println("color= "+color);
		 }else {
				//	获取按钮上的字符串
			 s = e.getActionCommand();
		 }
//		System.out.println("s = "+s);
	}
}
