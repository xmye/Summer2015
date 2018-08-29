package Thread0830;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

public class drawThread implements Runnable{

	private boolean pendFlag=false;//��ͣ���
	private Ball ball;
	private ArrayList<Ball> list;
	private JFrame jf;
	private Graphics g;
	
	public void setPend(boolean pendFlag ){
		this.pendFlag=pendFlag;
	}
	
	
	public drawThread(JFrame jf,ArrayList<Ball> list){
		this.list=list;
		this.jf=jf;
	}
	
	public void run() {
		while(true){
			sleepTime(30);
			g=jf.getGraphics();
		
		for(int i=0;i<list.size();i++){
			ball=list.get(i);
			
			if(pendFlag){//��ͣ�����֮ǰ��С��Ͳ�����ʧ
				continue;//�����������䣬��������
			}			
		
			ball.clear();
			ball.sport();
			ball.draw();
		}
	}
}
	
	public void sleepTime(long n){
		try {
			Thread.sleep(n);	//���߳�˯�ߣ�����CPUռ����
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	
}
