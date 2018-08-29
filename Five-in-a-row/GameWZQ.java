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
	Mouse m=new Mouse();//实现事件类
	
      public void initUI(){
    	  this.setTitle("五子棋"); 
    	  this.setDefaultCloseOperation(3);
    	  this.setSize(600,640);
    	  this.setLocationRelativeTo(null);
    	  
    	   //添加菜单
          JMenuBar jm=new JMenuBar();
          //添加菜单上的条目
          JMenu jm1=new JMenu("file");
          JMenu jm2=new JMenu("edit");
          //条目下的下拉栏
          JMenuItem jme=new JMenuItem("open");
          JMenuItem jme2=new JMenuItem("save");
          JMenuItem jme3=new JMenuItem("delete");
          jm1.add(jme);
          jm1.add(jme2);
          jm2.add(jme3);
          this.add(jm,BorderLayout.NORTH);
          jm.add(jm1);
          jm.add(jm2);
          
    	  this.setVisible(true);                     //可见
    	  
    		 //增加面板用于增加按钮
    		 JPanel jp=new JPanel();
    		 jp.setBackground(Color.gray);
    		 jp.setPreferredSize(new Dimension(0,55));
    		 this.add(jp,BorderLayout.SOUTH);
    		 
    		 //添加按钮
    		 JButton jb1=new JButton("开始");
    		 jb1.setPreferredSize(new Dimension(70,35));
    		 JButton jb2=new JButton("悔棋");
    		 jb2.setPreferredSize(new Dimension(70,35));
    		 JButton jb3=new JButton("重来");
    		 jb3.setPreferredSize(new Dimension(70,35));
            jp.add(jb1);
            jp.add(jb2);
            jp.add(jb3);
            
            //添加监听器
            jb1.addActionListener(m);
            jb2.addActionListener(m);
            jb3.addActionListener(m);
            
    	  //传递数组
    	  m.setArray(array);
    	  //获取画笔
    	  Graphics g=this.getGraphics();
    	  //将画笔传给事件类
    	  m.setG(g);
    	  //添加鼠标监听器
    	   this.addMouseListener(m);
    	 //传窗体对象
    	   m.setT(this);
    	   
//    	 //连接对象
//       	ChatMsg cm=new ChatMsg(ms);
    	   
    	   Socket client=null;     //声明Socket对象，方便接下来传入监听器对象
    		try {
    			client = new Socket("localhost",1222);//创建连结对象，传入ip和端口号
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
   
      
	//重写画窗体的函数
      public void paint(Graphics g){
    	  super.paint(g);                     //super调用父类的方法
    	  for(int i=0;i<11;i++){       //画网格
    			g.drawLine(50, 50+50*i, 550, 50+50*i);
    			g.drawLine(50+50*i,50, 50+50*i, 550);
      }           
    	   //重画旗子
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