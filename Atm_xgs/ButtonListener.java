package com.study0429;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

//ʵ�ֽӿ�   ��д�ӿ������к���
public class ButtonListener implements ActionListener {
	JFrame jf=new JFrame();
		public void actionPerformed(ActionEvent e){
			System.out.println("ok");
			
			jf.setSize(600, 600);
			jf.setDefaultCloseOperation(2);  //2��ʾ�رյ�ǰ����    1--��С��    3--�ر����д���
			jf.setVisible(true);
		
}
}
