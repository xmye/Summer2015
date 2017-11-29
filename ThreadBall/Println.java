package 线程小球;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Println extends JFrame{
	private Graphics g;
	private JFrame jf;
	private myThread mt;//设为全局变量，便于调用
	private ArrayList<myThread> list=new ArrayList<myThread>();//用于存线程对象
	
	public static void main(String[] args){
		Println pr=new Println();
		pr.init();
	}

	private void init() {
		//设置窗体
		jf=this;
		jf.setTitle("小球运动");
		jf.setSize(new Dimension(600,600));
		jf.setDefaultCloseOperation(3);
		jf.setLocationRelativeTo(null);
		FlowLayout fl=new FlowLayout();
		jf.setLayout(fl);//设置布局，流式布局。？？
		
		JPanel jp =new JPanel();//面板，防止按钮被擦掉
		JButton jb=new JButton("添加");
		jp.add(jb);
		JButton jb1=new JButton("暂停");
		jp.add(jb1);
		JButton jb2=new JButton("恢复");
		jp.add(jb2);
		JButton jb3=new JButton("清除");
		jp.add(jb3);
		jp.setPreferredSize (new Dimension(600,100));
		jf.add(jp,BorderLayout.NORTH);
		
		ActionListener act=new ActionListener() {
			// TODO Auto-generated method stub 待办事项 自动生成方法存根
						public void actionPerformed(ActionEvent e) {
							String s=e.getActionCommand();//得到按钮中的文字
							if("添加".equals(s)){
								mt=new myThread(jf,list);//实例化线程对象，每个线程都是一次性的
								list.add(mt);
								mt.start();//启动线程，直接返回，后台会自动调用run方法，程序此时可以做别的事
							}
							else if("暂停".equals(s)){
								for(int i=0;i<list.size();i++){
							    mt=list.get(i);
//								mt.suspend();  系统的暂停函数
							    mt.setPend(true);
								}
							}
							else if("清除".equals(s)){
								for(int i=0;i<list.size();i++){
								mt=list.get(i);
//								mt.stop();停止线程
								mt.setClear(true);
								}
							}else if("恢复".equals(s)){
								for(int i=0;i<list.size();i++){
									mt=list.get(i);
//									mt.resume();//恢复
									mt.setPend(false);
									mt.setClear(false);
								}
							}
				}
		};
		jb.addActionListener(act);
		jb1.addActionListener(act);
		jb2.addActionListener(act);
		jb3.addActionListener(act);
		this.setVisible(true);
	}
}
