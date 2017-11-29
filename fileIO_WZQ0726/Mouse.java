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
	
	//��ȡ����
	public void setArray( int [][] array){
		this.array=array;
	}
	//���ڻ�ȡGameWZQ�Ļ���
	public void setG(Graphics g){
		this.g=g;
	}
   //��ȡ�������
	public void setT(WZQ_save jf){
		this.jf=jf;
	}
	//��ȡ���ж���
 
	@Override
	public void mouseClicked(MouseEvent e) {
		if(array[hx][dy]==0){                                     //�����ӣ����ܸ���
		if(flag==1){                                                        //�ڰ׽���
			g.setColor(Color.BLACK);
			g.fillOval(30+hx*50,30+dy*50 , 40, 40);                   
			array[hx][dy]=flag;                                     //��������
			 Chess chess = new Chess(hx, dy, flag);// ʵ����һ�����Ӷ��󣬴洢��ǰ�����꼰��ɫ,���ڱ������
			 list.add(chess);
			flag=2;
			count++;
			}
			else if(flag==2){
			g.setColor(Color.WHITE);
			g.fillOval(30+hx*50,30+dy*50 , 40, 40);
			array[hx][dy]=flag;
		   Chess chess = new Chess(hx, dy, flag);// ʵ����һ�����Ӷ��󣬴洢��ǰ�����꼰��ɫ  
			 list.add(chess);
			flag=1;
			count++;
			}
		 setx[count]=hx;             //���������갴˳�򱣴棬���ڻ���
		 sety[count]=dy;
   }
		//����
		if(winh(hx,dy)>=5){
			if(array[hx][dy]==1){
				JOptionPane.showConfirmDialog(null, "����Ӯ��");
			}
			if(array[hx][dy]==2){
				JOptionPane.showConfirmDialog(null, "����Ӯ��");
			}
		}
		//����
		if(wind(hx,dy)>=5){
			if(array[hx][dy]==1){
				JOptionPane.showConfirmDialog(null, "����Ӯ��");
			}
			if(array[hx][dy]==2){
				JOptionPane.showConfirmDialog(null, "����Ӯ��");
			}
		}
		//б��
				if(winyx(hx,dy)>=5){
					if(array[hx][dy]==1){
						JOptionPane.showConfirmDialog(null, "����Ӯ��");
					}
					if(array[hx][dy]==2){
						JOptionPane.showConfirmDialog(null, "����Ӯ��");
					}
				}
				
				//б��
				if(winzx(hx,dy)>=5){
					if(array[hx][dy]==1){
						JOptionPane.showConfirmDialog(null, "����Ӯ��");
					}
					if(array[hx][dy]==2){
						JOptionPane.showConfirmDialog(null, "����Ӯ��");
					}
				}
}
	//�����ж�
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
	
	//�����ж�
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
	//��б�ж�
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
	//��б�ж�
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
		//�����ӻ��ڽ���  
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
		if(s.equals("��ʼ")){
			flag=1;
		}else if(s.equals("����")){
			for(int i=0;i<array.length;i++){
    		    for(int j=0;j<array.length;j++){
    		    	array[i][j]=0;
		}
			}
			//���ô����е���д����
			jf.repaint();
	
		}else if(s.equals("����")){
					huiqi();
    		    	jf.repaint();
   }
	}
//		else if(s.equals("����")){
//	   try {
//		write(fileName);
//	} catch (IOException e1) {
//		e1.printStackTrace();
//	} 
//	   jf.repaint();
//   }else if(s.equals("��")){
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
}

