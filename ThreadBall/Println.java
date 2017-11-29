package �߳�С��;

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
	private myThread mt;//��Ϊȫ�ֱ��������ڵ���
	private ArrayList<myThread> list=new ArrayList<myThread>();//���ڴ��̶߳���
	
	public static void main(String[] args){
		Println pr=new Println();
		pr.init();
	}

	private void init() {
		//���ô���
		jf=this;
		jf.setTitle("С���˶�");
		jf.setSize(new Dimension(600,600));
		jf.setDefaultCloseOperation(3);
		jf.setLocationRelativeTo(null);
		FlowLayout fl=new FlowLayout();
		jf.setLayout(fl);//���ò��֣���ʽ���֡�����
		
		JPanel jp =new JPanel();//��壬��ֹ��ť������
		JButton jb=new JButton("���");
		jp.add(jb);
		JButton jb1=new JButton("��ͣ");
		jp.add(jb1);
		JButton jb2=new JButton("�ָ�");
		jp.add(jb2);
		JButton jb3=new JButton("���");
		jp.add(jb3);
		jp.setPreferredSize (new Dimension(600,100));
		jf.add(jp,BorderLayout.NORTH);
		
		ActionListener act=new ActionListener() {
			// TODO Auto-generated method stub �������� �Զ����ɷ������
						public void actionPerformed(ActionEvent e) {
							String s=e.getActionCommand();//�õ���ť�е�����
							if("���".equals(s)){
								mt=new myThread(jf,list);//ʵ�����̶߳���ÿ���̶߳���һ���Ե�
								list.add(mt);
								mt.start();//�����̣߳�ֱ�ӷ��أ���̨���Զ�����run�����������ʱ�����������
							}
							else if("��ͣ".equals(s)){
								for(int i=0;i<list.size();i++){
							    mt=list.get(i);
//								mt.suspend();  ϵͳ����ͣ����
							    mt.setPend(true);
								}
							}
							else if("���".equals(s)){
								for(int i=0;i<list.size();i++){
								mt=list.get(i);
//								mt.stop();ֹͣ�߳�
								mt.setClear(true);
								}
							}else if("�ָ�".equals(s)){
								for(int i=0;i<list.size();i++){
									mt=list.get(i);
//									mt.resume();//�ָ�
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
