package com.study05102;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//ʵ�ֽӿ�
public class LoginList implements ActionListener{
//	DrameListener cc=new DrameListener();
   private JTextField jtf1;
   private JTextField password;
 //  private JTextField jtf2;
   private JFrame jf;
   private DrameListener d=new DrameListener();
   private ButtonListener b;
   
   public LoginList(){}
   public LoginList(JTextField jtf1,JTextField password){
	   this.jtf1=jtf1;        
	   this.password=password;
   }
   
   
	public void actionPerformed(ActionEvent e) {
	//��ȡ�ı�������ַ���	
	String s=jtf1.getText();
	String q=password.getText();
//	String r=jtf2.getText();
	System.out.println("s= "+s);
	if(s.equals("123")&&q.equals("a")){
		jf=new JFrame();
		jf.setSize(600, 600);
		jf.setDefaultCloseOperation(2);
		jf.setLocationRelativeTo(null);                           
		westPanel();
		colorPanel();
		jf.setVisible(true);
	   
		Graphics g=jf.getGraphics();
		
	
		 //���������������������
	    jf.addMouseListener(d);       
	    //����϶�����������
	    jf.addMouseMotionListener(d);
	    
	    d.setG(g);
		
//		MouseList m=new MouseList(g);                   
//		jf.addMouseListener(m);
//		
//		//����������϶��¼�
//		jf.addMouseMotionListener(m);
	}else{
		JOptionPane.showConfirmDialog(null,"�������������");
	}
	}
	 public void colorPanel(){
	        JPanel jp=new JPanel();
	    	jp.setPreferredSize(new java.awt.Dimension(0,50));
	    	Color[] color={Color.BLACK,Color.blue,Color.green};
	    	 
	    	for(int i=0;i<color.length;i++){
	    		JButton jb=new JButton();
	    		jb.setPreferredSize(new Dimension(30, 30));
	    		jb.setBackground(color[i]);
	    		jp.add(jb);
	    		jb.addActionListener(b);
	    	
	    	}

	    	jf.add(jp,BorderLayout.SOUTH);
	    	jp.setBackground(Color.GRAY);

}
	 public void westPanel(){
		   JPanel jp=new JPanel();
	       jp.setPreferredSize(new Dimension(50,0));
	    	jp.setBackground(Color.orange);
	    	//���ð�ť
	       String s[]={"ֱ��","Ǧ��","��Բ","������","����"};
	        b=new ButtonListener();
	       d.setBut(b);   //����set�������Ѱ�ť�¼�����󴫵ݵ���ͼ���¼�����
	       for(int i=0;i<s.length;i++){
	    	   JButton jb=new JButton(s[i]);   
	    	   jp.add(jb);
	    	   //��ͼ�ΰ�ť��Ӽ���������
	    	   jb.addActionListener(b);
	       }   
	       jf.add(jp,BorderLayout.WEST);
	       
	}
         
}
