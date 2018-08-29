package netWZQ0804;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Client0801.SendListener;
import Client0801.readMsg;

public class GameWZQ extends JFrame{
	private int flag=1;
	private int[][] array=new int[11][11];	
	private Socket client;
	private List<readMsg> list;
	Mouse m=new Mouse();//ʵ���¼���
	
      public void initUI(){
    	  this.setTitle("������"); 
    	  this.setDefaultCloseOperation(3);
    	  this.setSize(600,640);
    	  this.setLocationRelativeTo(null);
    	  
    	   //��Ӳ˵�
          JMenuBar jm=new JMenuBar();
          //��Ӳ˵��ϵ���Ŀ
          JMenu jm1=new JMenu("file");
          JMenu jm2=new JMenu("edit");
          //��Ŀ�µ�������
          JMenuItem jme=new JMenuItem("open");
          JMenuItem jme2=new JMenuItem("save");
          JMenuItem jme3=new JMenuItem("delete");
          jm1.add(jme);
          jm1.add(jme2);
          jm2.add(jme3);
          this.add(jm,BorderLayout.NORTH);
          jm.add(jm1);
          jm.add(jm2);
          
    	  this.setVisible(true);                     //�ɼ�
    	  
    		 //��������������Ӱ�ť
    		 JPanel jp=new JPanel();
    		 jp.setBackground(Color.gray);
    		 jp.setPreferredSize(new Dimension(0,55));
    		 this.add(jp,BorderLayout.SOUTH);
    		 
    		 //��Ӱ�ť
    		 JButton jb1=new JButton("��ʼ");
    		 jb1.setPreferredSize(new Dimension(70,35));
    		 JButton jb2=new JButton("����");
    		 jb2.setPreferredSize(new Dimension(70,35));
    		 JButton jb3=new JButton("����");
    		 jb3.setPreferredSize(new Dimension(70,35));
            jp.add(jb1);
            jp.add(jb2);
            jp.add(jb3);
            
            //��Ӽ�����
            jb1.addActionListener(m);
            jb2.addActionListener(m);
            jb3.addActionListener(m);
            
    	  //��������
    	  m.setArray(array);
    	  //��ȡ����
    	  Graphics g=this.getGraphics();
    	  //�����ʴ����¼���
    	  m.setG(g);
    	  //�����������
    	   this.addMouseListener(m);
    	 //���������
    	   m.setT(this);
    	   
//    	 //���Ӷ���
//       	ChatMsg cm=new ChatMsg(ms);
    	   
    	   Socket client=null;     //����Socket���󣬷���������������������
    		try {
    			client = new Socket("localhost",1222);//����������󣬴���ip�Ͷ˿ں�
    		} catch (UnknownHostException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		
			readMessage rm=new readMessage();
//			list.add(rm);
			rm.setT(this);
			rm.setG(g);
			rm.start();
 }
   
      
	//��д������ĺ���
      public void paint(Graphics g){
    	  super.paint(g);                     //super���ø���ķ���
    	  for(int i=0;i<11;i++){       //������
    			g.drawLine(50, 50+50*i, 550, 50+50*i);
    			g.drawLine(50+50*i,50, 50+50*i, 550);
      }           
    	   //�ػ�����
    		  for(int i=0;i<array.length;i++){
    		    for(int j=0;j<array.length;j++){
    			  if(array[i][j]==2){
    				    g.setColor(Color.WHITE);
    					g.fillOval(30+i*50,30+j*50 , 40, 40);
    			  }else if(array[i][j]==1){
    					g.setColor(Color.BLACK);
    					g.fillOval(30+i*50,30+j*50 , 40, 40);
    			  }
    		  }
    	  }
    }
      
      public static void main(String arg[]){
    	  GameWZQ game=new GameWZQ();
    	  game.initUI();
      }
    
}