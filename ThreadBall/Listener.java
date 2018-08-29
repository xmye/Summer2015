package Thread0830;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Listener implements ActionListener{
	private drawThread dt;
	private Ball ball;
	private ArrayList<Ball> list=new ArrayList<Ball>();//���ڴ�С�����
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
		String s=e.getActionCommand();//�õ���ť�е�����
		
		if("���".equals(s)){
			ball=new Ball(jf,list);//ʵ����С�����
			list.add(ball);
	
		}else if("��ͣ".equals(s)){
			dt.setPend(true);//��ͣ�߳�
			
		}else if("���".equals(s)){
			jf.repaint();//�����ػ�
			list.clear();
			
		}else if("�ָ�".equals(s)){
				dt.setPend(false);
			}
		};
}


