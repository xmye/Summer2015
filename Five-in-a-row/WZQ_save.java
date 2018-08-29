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
	//ʵ���¼���
	 Mouse m=new Mouse();
	 //��������
		String fileName = "E:\\Java\\workplace\\SummerHoliday\\src\\fileIO_WZQ0726\\save.txt"; 
	 private List<Chess> list=new ArrayList();
	 public void setL(List<Chess> list){
			this.list=list;
		}
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
    		 JButton jbs=new JButton("����");
    		 jb3.setPreferredSize(new Dimension(70,35));
    		 JButton jbb=new JButton("��ʼ");
    		 jb3.setPreferredSize(new Dimension(70,35));
            jp.add(jb1);
            jp.add(jb2);
            jp.add(jb3);
            jp.add(jbs);
            jp.add(jbb);
            
            //��Ӽ�����
            jb1.addActionListener(m);
            jb2.addActionListener(m);
            jb3.addActionListener(m);
    	  //��������
    	  m.setArray(array);
    	  //��ȡ����
    	  final Graphics g=this.getGraphics();
    	  //�����ʴ����¼���
    	  m.setG(g);
    	  //�����������
    	   this.addMouseListener(m);
    	 //���������
    	   m.setT(this);
          jbs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("����")){
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
				 FileOutputStream fos = new FileOutputStream(fileName);    //д����� 
				 ObjectOutputStream out = new ObjectOutputStream(fos); 
				 DataOutputStream dos=new DataOutputStream(fos); //д����еĳ���
				 dos.writeInt(list.size());//д�����Ӹ���
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
				if(e.getActionCommand().equals("��")){
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
			  DataInputStream  dis = new DataInputStream(fis); //��ȡ���еĳ��ȣ�������ĸ���
			  int listsize=dis.readInt();
			  System.out.println("......................................>>>>>");
			  for(int i=0;i<listsize;i++){
				  System.out.println(".,,,>>>>>");
				  Chess chess=(Chess)input.readObject();//ǿ��ת�ͣ���������
				  if(chess.getColor()==1){  						//�ж����ӵ���ɫ
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
  
//    	  ImageIcon im=new ImageIcon("image/����.jpg");      //���ñ���ͼƬ
//  	 JLabel jl=new JLabel(im);
//   	 this.getLayeredPane().add(jl,new Integer(Integer.MIN_VALUE));         //�ײ����	
//  	 jl.setBounds(0, 0, im.getIconWidth(), im.getIconHeight());                    //ͼƬ�Ĵ�С	
//    	 Container container=this.getContentPane();                              //�в���� 	
//    	 JPanel jp2=(JPanel)container;                                     //ת��
// 	 jp2.setOpaque(false);         //�����в�͸��
//    	  }
//      private Dimension Dimension(int i, int j) {
//		// TODO Auto-generated method stub
//		return null;
//	
    	   
    	 
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
    	  WZQ_save game=new WZQ_save();
    	  game.initUI();
      }
    
}