package com.study0429;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

//实现接口   重写接口内所有函数
public class ButtonListener implements ActionListener {
	JFrame jf=new JFrame();
		public void actionPerformed(ActionEvent e){
			System.out.println("ok");
			
			jf.setSize(600, 600);
			jf.setDefaultCloseOperation(2);  //2表示关闭当前窗口    1--最小化    3--关闭所有窗口
			jf.setVisible(true);
		
}
}
