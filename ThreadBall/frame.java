package �齱0808;

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
	private threadNo tr;//����Ϊȫ�֣��Ա���������ť�ļ�����ʹ��
	private int flag;
	public static void main(String[] args) {
		frame th=new frame();
		th.init();
	}

	private void init() {
		this.setTitle("�齱");
		this.setSize(400,500);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		FlowLayout fl=new FlowLayout();//��ʽ����
		this.setLayout(fl);//���ò���
		JPanel jp=new JPanel();
	    tf=new TextField(30);
		jp.add(tf);//�ı�����������
		this.add(jp,BorderLayout.NORTH);//��������ڱ���
		JButton but=new JButton("�齱");
		this.add(but);
		JButton but1=new JButton("ֹͣ");
		this.add(but1);
		JButton but2=new JButton("�˶�С��");
		this.add(but2);
		this.setVisible(true);
		
		but.addActionListener(new ActionListener() {//��ť��Ӽ���
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
