package fileIO_WZQ0726;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class WZQ_save extends JFrame{
	private int flag=1;
	private int[][] array=new int[11][11];
	//实现事件类
	 Mouse m=new Mouse();
	 //保存旗子
		String fileName = "E:\\Java\\workplace\\SummerHoliday\\src\\fileIO_WZQ0726\\save.txt"; 
	 private List<Chess> list=new ArrayList();
	 public void setL(List<Chess> list){
			this.list=list;
		}
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
    		 JButton jbs=new JButton("保存");
    		 jb3.setPreferredSize(new Dimension(70,35));
    		 JButton jbb=new JButton("开始");
    		 jb3.setPreferredSize(new Dimension(70,35));
            jp.add(jb1);
            jp.add(jb2);
            jp.add(jb3);
            jp.add(jbs);
            jp.add(jbb);
            
            //添加监听器
            jb1.addActionListener(m);
            jb2.addActionListener(m);
            jb3.addActionListener(m);
    	  //传递数组
    	  m.setArray(array);
    	  //获取画笔
    	  final Graphics g=this.getGraphics();
    	  //将画笔传给事件类
    	  m.setG(g);
    	  //添加鼠标监听器
    	   this.addMouseListener(m);
    	 //传窗体对象
    	   m.setT(this);
          jbs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("保存")){
					try {
						write(fileName);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			public boolean write(String fileName) throws IOException{ 
				try {
				 FileOutputStream fos = new FileOutputStream(fileName);    //写入对象 
				 ObjectOutputStream out = new ObjectOutputStream(fos); 
				 DataOutputStream dos=new DataOutputStream(fos); //写入队列的长度
				 dos.writeInt(list.size());//写入旗子个数
				 for(int i=0;i<list.size();i++){
					 System.out.println(".>>>>>");
					 Chess chess=list.get(i);
					 out.writeObject(chess);
					 out.flush();
				 }
				 dos.close();  
			     out.close();  
			     return true;  
				} catch (FileNotFoundException e) {
					e.printStackTrace(); 
				}
				return false; 
			}
		});
          jbb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("打开")){
					try {
						open(fileName);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
						
			}

			public boolean open(String fileName) throws IOException, ClassNotFoundException{
		try {
			System.out.println("......................................>>>>>");
			  FileInputStream fis = new FileInputStream(fileName);
			  ObjectInputStream input = new ObjectInputStream(fis); 
			  DataInputStream  dis = new DataInputStream(fis); //读取队列的长度，即对象的个数
			  int listsize=dis.readInt();
			  System.out.println("......................................>>>>>");
			  for(int i=0;i<listsize;i++){
				  System.out.println(".,,,>>>>>");
				  Chess chess=(Chess)input.readObject();//强制转型，读出对象
				  if(chess.getColor()==1){  						//判断旗子的颜色
		                g.setColor(Color.black);  
		            }else{  
		                g.setColor(Color.WHITE);  
		            }     
				  System.out.println(chess.getI());
				  System.out.println(chess.getJ());
				  System.out.println(chess.getColor());
				  g.fillOval(30+chess.getI()*50,30+chess.getJ()*50 , 40, 40); 
				  g.fillOval(34, 50, 24, 56);
				  g.drawLine(3, 4, 34, 23);
				  System.out.println(".,,,>>>>>");
			  }
			  dis.close();  
		       input.close();  
		       return true;  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  
	      return false;
	}
		});
  
//    	  ImageIcon im=new ImageIcon("image/麦田.jpg");      //设置背景图片
//  	 JLabel jl=new JLabel(im);
//   	 this.getLayeredPane().add(jl,new Integer(Integer.MIN_VALUE));         //底层面板	
//  	 jl.setBounds(0, 0, im.getIconWidth(), im.getIconHeight());                    //图片的大小	
//    	 Container container=this.getContentPane();                              //中层面板 	
//    	 JPanel jp2=(JPanel)container;                                     //转型
// 	 jp2.setOpaque(false);         //设置中层透明
//    	  }
//      private Dimension Dimension(int i, int j) {
//		// TODO Auto-generated method stub
//		return null;
//	
    	   
    	 
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
    	  WZQ_save game=new WZQ_save();
    	  game.initUI();
      }
    
}