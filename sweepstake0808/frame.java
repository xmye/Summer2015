package 抽奖0808;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BrokenBarrierException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class frame extends JFrame{
	private TextField tf;
	private threadNo tr;//定义为全局，以便在两个按钮的监听中使用
	private int flag;
	public static void main(String[] args) {
		frame th=new frame();
		th.init();
	}

	private void init() {
		this.setTitle("抽奖");
		this.setSize(400,500);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		FlowLayout fl=new FlowLayout();//流式布局
		this.setLayout(fl);//设置布局
		JPanel jp=new JPanel();
	    tf=new TextField(30);
		jp.add(tf);//文本框加在面板上
		this.add(jp,BorderLayout.NORTH);//设置面板在北面
		JButton but=new JButton("抽奖");
		this.add(but);
		JButton but1=new JButton("停止");
		this.add(but1);
		JButton but2=new JButton("运动小球");
		this.add(but2);
		this.setVisible(true);
		
		but.addActionListener(new ActionListener() {//按钮添加监听
			public void actionPerformed(ActionEvent e) {
				 tr=new threadNo(tf);
				tr.start();
			}
		});		
		
		but1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tr.stop();
			}
		});
		but2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
}
