package Thread0830;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Listener implements ActionListener{
	private drawThread dt;
	private Ball ball;
	private ArrayList<Ball> list=new ArrayList<Ball>();//用于存小球对象
	private JFrame jf;
	private Graphics g;
	
	public Listener(JFrame jf,Graphics g){
		this.jf=jf;
		this.g=g;
		dt=new drawThread(jf,list);
		Thread th=new Thread(dt);
		th.start();
	}

	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();//得到按钮中的文字
		
		if("添加".equals(s)){
			ball=new Ball(jf,list);//实例化小球对象
			list.add(ball);
	
		}else if("暂停".equals(s)){
			dt.setPend(true);//暂停线程
			
		}else if("清除".equals(s)){
			jf.repaint();//界面重绘
			list.clear();
			
		}else if("恢复".equals(s)){
				dt.setPend(false);
			}
		};
}


