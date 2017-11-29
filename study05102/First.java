package com.study05102;

import java.awt.BorderLayout;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;


public class First {
    //LoginList b=new LoginList();
	
    private javax.swing.JFrame jf;
    //文本框定义成全局的用于传递    
    javax.swing.JTextField jt=new JTextField(12);       
    javax.swing.JTextField jte=new JTextField(12);
 	LoginList b=new LoginList(jt,jte);
 	
    public void initul(){
    
    jf=new javax.swing.JFrame();    //创建窗体
	jf.setSize(320,320);
	jf.setTitle("QQ登陆");
	jf.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);  //关闭窗体
	jf.setLocationRelativeTo(null);           //窗体居中显示
	northPanel();
	southPanel();
	westPanel();
	centerPanel();
	
	//设置窗体可见
	jf.setVisible(true);
	
    }
    
    public void northPanel(){
    	//面板对象默认是流式布局
    	javax.swing.JPanel northPanel=new javax.swing.JPanel();
        northPanel.setBackground(Color.BLACK);
        northPanel.setPreferredSize(new java.awt.Dimension(0,130));
        jf.add(northPanel,BorderLayout.NORTH);
        //图片
        javax.swing.ImageIcon im=new javax.swing.ImageIcon("image/qq图片.PNG");
        //标签
        javax.swing.JLabel jl=new javax.swing.JLabel(im);
        northPanel.add(jl);
	}
    
    
    //北边面板
    public void southPanel(){
    	javax.swing.JPanel southPanel=new javax.swing.JPanel();
    	southPanel.setBackground(Color.white);
    	southPanel.setPreferredSize(new java.awt.Dimension(0,50));
    	jf.add(southPanel,BorderLayout.SOUTH);
    	
       //添加按钮
    	javax.swing.JButton jbu=new javax.swing.JButton("登陆");
    	jbu.setPreferredSize(new java.awt.Dimension(60,35));     //设置组件大小方法（除了JFrame）
    	//设置监听器
//    	ButtonListener b=new ButtonListener();
      	jbu.addActionListener(b);
    	
      	
     	southPanel.add(jbu);
    }
    
    public void westPanel(){
    javax.swing.JPanel westPanel=new javax.swing.JPanel();
    westPanel.setBackground(Color.white);
    westPanel.setPreferredSize(new java.awt.Dimension(80,0));

     //图片
    javax.swing.ImageIcon ima=new javax.swing.ImageIcon("image/qq头像.PNG");
   //标签
    javax.swing.JLabel jla=new javax.swing.JLabel(ima);
    westPanel.add(jla);
    
    jf.add(westPanel,BorderLayout.WEST);
    }
    
    public void centerPanel(){
    	javax.swing.JPanel centerPanel=new javax.swing.JPanel();
    	centerPanel.setBackground(Color.WHITE);
    	centerPanel.setPreferredSize(new java.awt.Dimension(0,0));               
    	jf.add(centerPanel,BorderLayout.CENTER);
    	//文本框
  //  	javax.swing.JTextField jt=new JTextField(12);
    	centerPanel.add(jt);
    
    	//标签对象
    	javax.swing.JLabel jla=new javax.swing.JLabel("注册账号");
    	centerPanel.add(jla);
    	
//    	javax.swing.JTextField jte=new JTextField(12);
    	centerPanel.add(jte);
 
    	javax.swing.JLabel jlab=new javax.swing.JLabel("找回密码");
    	centerPanel.add(jlab);
    	//复选框
     	javax.swing.JCheckBox jch=new javax.swing.JCheckBox("记住密码");
     	centerPanel.add(jch);
     	javax.swing.JCheckBox jc=new javax.swing.JCheckBox("自动登录");
     	centerPanel.add(jc);
     	//传文本框对象用于判断输入
    }
    
    public static void main(String args[]){
    First F=new First();
    F.initul();
    
    }
}

