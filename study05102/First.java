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
    //�ı������ȫ�ֵ����ڴ���    
    javax.swing.JTextField jt=new JTextField(12);       
    javax.swing.JTextField jte=new JTextField(12);
 	LoginList b=new LoginList(jt,jte);
 	
    public void initul(){
    
    jf=new javax.swing.JFrame();    //��������
	jf.setSize(320,320);
	jf.setTitle("QQ��½");
	jf.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);  //�رմ���
	jf.setLocationRelativeTo(null);           //���������ʾ
	northPanel();
	southPanel();
	westPanel();
	centerPanel();
	
	//���ô���ɼ�
	jf.setVisible(true);
	
    }
    
    public void northPanel(){
    	//������Ĭ������ʽ����
    	javax.swing.JPanel northPanel=new javax.swing.JPanel();
        northPanel.setBackground(Color.BLACK);
        northPanel.setPreferredSize(new java.awt.Dimension(0,130));
        jf.add(northPanel,BorderLayout.NORTH);
        //ͼƬ
        javax.swing.ImageIcon im=new javax.swing.ImageIcon("image/qqͼƬ.PNG");
        //��ǩ
        javax.swing.JLabel jl=new javax.swing.JLabel(im);
        northPanel.add(jl);
	}
    
    
    //�������
    public void southPanel(){
    	javax.swing.JPanel southPanel=new javax.swing.JPanel();
    	southPanel.setBackground(Color.white);
    	southPanel.setPreferredSize(new java.awt.Dimension(0,50));
    	jf.add(southPanel,BorderLayout.SOUTH);
    	
       //��Ӱ�ť
    	javax.swing.JButton jbu=new javax.swing.JButton("��½");
    	jbu.setPreferredSize(new java.awt.Dimension(60,35));     //���������С����������JFrame��
    	//���ü�����
//    	ButtonListener b=new ButtonListener();
      	jbu.addActionListener(b);
    	
      	
     	southPanel.add(jbu);
    }
    
    public void westPanel(){
    javax.swing.JPanel westPanel=new javax.swing.JPanel();
    westPanel.setBackground(Color.white);
    westPanel.setPreferredSize(new java.awt.Dimension(80,0));

     //ͼƬ
    javax.swing.ImageIcon ima=new javax.swing.ImageIcon("image/qqͷ��.PNG");
   //��ǩ
    javax.swing.JLabel jla=new javax.swing.JLabel(ima);
    westPanel.add(jla);
    
    jf.add(westPanel,BorderLayout.WEST);
    }
    
    public void centerPanel(){
    	javax.swing.JPanel centerPanel=new javax.swing.JPanel();
    	centerPanel.setBackground(Color.WHITE);
    	centerPanel.setPreferredSize(new java.awt.Dimension(0,0));               
    	jf.add(centerPanel,BorderLayout.CENTER);
    	//�ı���
  //  	javax.swing.JTextField jt=new JTextField(12);
    	centerPanel.add(jt);
    
    	//��ǩ����
    	javax.swing.JLabel jla=new javax.swing.JLabel("ע���˺�");
    	centerPanel.add(jla);
    	
//    	javax.swing.JTextField jte=new JTextField(12);
    	centerPanel.add(jte);
 
    	javax.swing.JLabel jlab=new javax.swing.JLabel("�һ�����");
    	centerPanel.add(jlab);
    	//��ѡ��
     	javax.swing.JCheckBox jch=new javax.swing.JCheckBox("��ס����");
     	centerPanel.add(jch);
     	javax.swing.JCheckBox jc=new javax.swing.JCheckBox("�Զ���¼");
     	centerPanel.add(jc);
     	//���ı�����������ж�����
    }
    
    public static void main(String args[]){
    First F=new First();
    F.initul();
    
    }
}

