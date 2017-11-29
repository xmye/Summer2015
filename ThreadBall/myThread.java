package �߳�С��;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

public class myThread extends Thread{
	private Graphics g;
	private JFrame jf;
	private int x,y,radius;//Բ��������뾶
	private int vx,vy;//С���˶��ٶ�
	private Color color;
	private boolean pendFlag=false;//��ͣ���
	private boolean clearFlag=false;//������
	private ArrayList<myThread> list;
	
	public void setPend(boolean pendFlag ){
		this.pendFlag=pendFlag;
	}
	
	public void setClear( boolean clearFlag){
		this.clearFlag=clearFlag;
	}
	
	public myThread(JFrame jf,ArrayList<myThread> list){
		this.jf=jf;
		g=jf.getGraphics();
		this.list=list;	
		//�����ȡС������,��ʼ��
		Random rd=new Random();
		vx=rd.nextInt(3)+1;
		vy=rd.nextInt(3)+1;
		x=rd.nextInt(500)+100;
		y=rd.nextInt(500)+100;
		radius=rd.nextInt(20)+10;
		color=new Color(rd.nextInt(256),rd.nextInt(256),rd.nextInt(256));	
	}
	
	//��Ҫִ�еĲ����ŵ�run������
	public void run(){
		while(true){
			sleepTime(30);
			
			if(pendFlag){//��ͣ�����֮ǰ��С��Ͳ�����ʧ
				if(clearFlag){
				}else
				continue;//�����������䣬��������
			}
			clear();
			
			//���
			if(clearFlag){
				break;
			}
			
			sport();
			
			draw();
		}
	}
	
	public void sleepTime(long n){
		try {
			sleep(n);	//���߳�˯�ߣ�����CPUռ����
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void sport(){
		x+=vx;
		y+=vy;
		//С����紦��
		if(x>=jf.getWidth()-radius){
			vx=-Math.abs(vx);
		}
		if(x<=radius){
			vx=Math.abs(vx);
		}
		if(y>=jf.getHeight()-radius){
			vy=-Math.abs(vy);
		}
		if(y<=100+radius){
			vy=Math.abs(vy);
		}
		//��ײ�򵥴���
		for(int i=0;i<list.size();i++){
			myThread mh=list.get(i);
			//�ж�С���ǲ����Լ�
			if(this==mh){
				continue;
			}
			int xx=Math.abs(this.x-mh.x);
			int yy=Math.abs(this.y-mh.y);
			int center=(int) Math.sqrt(xx*xx+yy*yy);//Բ�ľ���
			
			if(center<=this.radius+mh.radius){	
				int temp=vx;//�����ٶȴ�С�뷽��
				vx=mh.vx;
				mh.vx=temp;
				
				int tem=vy;
				vy=mh.vy;
				mh.vy=tem;
			}
		}
	}
	
	public void draw(){
		//��Բ
		g.setColor(color);
		g.fillOval(x-radius, y-radius,2*radius, 2*radius);
		//ʹС��������,x�����ƫ��
		int xx=x;
		for(int r=radius, i=1;r>1;r--,i++,xx--){
			Color newcolor=getcolor(i*7);
			g.setColor(newcolor);
			g.fillOval(xx-r, y-r,2*r, 2*r);
		}
	}
	
	private Color getcolor(int inc){
		int red=color.getRed()+inc;
		int bule=color.getBlue()+inc;
		int green=color.getGreen()+inc;
		int i=255;//���ĵ���ɫ
		if(red>=i)
			red=i;
		if(bule>=i)
			bule=i;
		if(green>=i)
			green=i;
		return new Color(red,bule,green);
	}
	
	public void clear(){
//		g.clearRect(0, 0,jf.getWidth(), jf.getHeight());//������Ļ
		g.setColor(jf.getBackground());
		g.fillOval(x-radius, y-radius,2*radius, 2*radius);//ֻ����ϴ�������Բ
	}
}
