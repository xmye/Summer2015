package Thread0830;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

public class drawThread implements Runnable{

	private boolean pendFlag=false;//暂停标记
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
			
			if(pendFlag){//暂停在清除之前，小球就不会消失
				continue;//继续上面的语句，不再往下
			}			
		
			ball.clear();
			ball.sport();
			ball.draw();
		}
	}
}
	
	public void sleepTime(long n){
		try {
			Thread.sleep(n);	//让线程睡眠，减少CPU占用率
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	
}
