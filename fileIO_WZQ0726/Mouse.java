package fileIO_WZQ0726;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Mouse implements MouseListener,ActionListener{
	private int  x1,y1;
	private Graphics g;
	private int [][] array;
    private int hx,dy;
	private int flag;
	private WZQ_save jf;
	private int count;
	private int [] setx=new int[121];
	private int[] sety=new  int[121];
	String fileName = "E:\\Java\\workplace\\SummerHoliday\\src\\fileIO_WZQ0726\\save.txt"; 
	WZQ_save w=new WZQ_save();
	private List<Chess> list =new ArrayList();
	
	//获取数组
	public void setArray( int [][] array){
		this.array=array;
	}
	//用于获取GameWZQ的画笔
	public void setG(Graphics g){
		this.g=g;
	}
   //获取窗体对象
	public void setT(WZQ_save jf){
		this.jf=jf;
	}
	//获取队列对象
 
	@Override
	public void mouseClicked(MouseEvent e) {
		if(array[hx][dy]==0){                                     //画旗子，不能覆盖
		if(flag==1){                                                        //黑白交替
			g.setColor(Color.BLACK);
			g.fillOval(30+hx*50,30+dy*50 , 40, 40);                   
			array[hx][dy]=flag;                                     //储存旗子
			 Chess chess = new Chess(hx, dy, flag);// 实例化一个棋子对象，存储当前的坐标及颜色,用于保存棋局
			 list.add(chess);
			flag=2;
			count++;
			}
			else if(flag==2){
			g.setColor(Color.WHITE);
			g.fillOval(30+hx*50,30+dy*50 , 40, 40);
			array[hx][dy]=flag;
		   Chess chess = new Chess(hx, dy, flag);// 实例化一个棋子对象，存储当前的坐标及颜色  
			 list.add(chess);
			flag=1;
			count++;
			}
		 setx[count]=hx;             //将旗子坐标按顺序保存，用于悔棋
		 sety[count]=dy;
   }
		//横向
		if(winh(hx,dy)>=5){
			if(array[hx][dy]==1){
				JOptionPane.showConfirmDialog(null, "黑棋赢！");
			}
			if(array[hx][dy]==2){
				JOptionPane.showConfirmDialog(null, "白棋赢！");
			}
		}
		//纵向
		if(wind(hx,dy)>=5){
			if(array[hx][dy]==1){
				JOptionPane.showConfirmDialog(null, "黑棋赢！");
			}
			if(array[hx][dy]==2){
				JOptionPane.showConfirmDialog(null, "白棋赢！");
			}
		}
		//斜向
				if(winyx(hx,dy)>=5){
					if(array[hx][dy]==1){
						JOptionPane.showConfirmDialog(null, "黑棋赢！");
					}
					if(array[hx][dy]==2){
						JOptionPane.showConfirmDialog(null, "白棋赢！");
					}
				}
				
				//斜向
				if(winzx(hx,dy)>=5){
					if(array[hx][dy]==1){
						JOptionPane.showConfirmDialog(null, "黑棋赢！");
					}
					if(array[hx][dy]==2){
						JOptionPane.showConfirmDialog(null, "白棋赢！");
					}
				}
}
	//横向判断
	public int winh(int hx,int dy){
		int count=1;
		for(int i=hx+1;i<array.length;i++){
			if(array[hx][dy]==array[i][dy]){
				count++;
			}else{
				break;
			}
		}
		for(int j=hx-1;j>=0;j--){
			if(array[hx][dy]==array[j][dy]){
				count++;
			}else{
				break;
			}
		}
		return count;
	}
	
	//纵向判断
	public int wind(int hx,int dy){
		int count=1;
		for(int i=dy+1;i<array.length;i++){
			if(array[hx][dy]==array[hx][i]){
				count++;
			}else{
				break;
			}
		}
		for(int j=dy-1;j>=0;j--){
			if(array[hx][dy]==array[hx][j]){
				count++;
			}else{
				break;
			}
		}
		return count;
	}
	//右斜判断
	public int winyx(int hx,int dy){
		int count=1;
	for(int i=hx+1,j=dy+1;i<array.length&&j<array.length;i++,j++){
			if(array[hx][dy]==array[i][j]){
				count++;
			}else{
				break;
			}
		}
		for(int p=hx-1,q=dy-1;p>=0&&q>=0;p--,q--){
			if(array[hx][dy]==array[p][q]){
				count++;
			}else{
				break;
			}
			
		}
	return count;
	}
	//左斜判断
	public int winzx(int hx,int dy){
		int count=1;
	for(int i=hx-1,j=dy+1;i>=0&&j<array.length;i--,j++){
			if(array[hx][dy]==array[i][j]){
				count++;
			}else{
				break;
			}
		}
		for(int p=hx+1,q=dy-1;p<array.length&&q>=0;p++,q--){
			if(array[hx][dy]==array[p][q]){
				count++;
			}else{
				break;
			}
			
		}
		return count;
	}
		
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x1=e.getX();
		y1=e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//将旗子画在交点  
		  if((x1-50)%50>25){                                  
		    	hx=(x1-50)/50+1;
		    }
		    else{
		    	hx=(x1-50)/50;
		    }
		    if((y1-50)%50>25){
		    	dy=(y1-50)/50+1;
		    }
		    else{
		    	dy=(y1-50)/50;
		    }
}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		if(s.equals("开始")){
			flag=1;
		}else if(s.equals("重来")){
			for(int i=0;i<array.length;i++){
    		    for(int j=0;j<array.length;j++){
    		    	array[i][j]=0;
		}
			}
			//调用窗体中的重写方法
			jf.repaint();
	
		}else if(s.equals("悔棋")){
					huiqi();
    		    	jf.repaint();
   }
	}
//		else if(s.equals("保存")){
//	   try {
//		write(fileName);
//	} catch (IOException e1) {
//		e1.printStackTrace();
//	} 
//	   jf.repaint();
//   }else if(s.equals("打开")){
//	   try {
//		open(fileName);
//	} catch (ClassNotFoundException e1) {
//		e1.printStackTrace();
//	} catch (IOException e1) {
//		e1.printStackTrace();
//	}
//	   jf.repaint();
//   }
//}
	public void huiqi(){
		if(count>0){
			int x=setx[count];
			int y=sety[count];
			array[x][y]=0;
			count--;
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
}

