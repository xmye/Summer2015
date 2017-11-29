package Thread0830;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * С�����
 * @author thinkpad
 *
 */
public class UI extends JFrame{

	private JFrame jf;
	private Graphics g;
	
	public void init(){
		//���ô���
		jf=this;
		jf.setTitle("С���˶�");
		jf.setSize(new Dimension(600,600));
		jf.setDefaultCloseOperation(3);
		jf.setLocationRelativeTo(null);
		FlowLayout fl=new FlowLayout();
		jf.setLayout(fl);//���ò��֣���ʽ����
		
		JPanel jp =new JPanel();//��壬��ֹ��ť������
		//��Ӱ�ť
		String[] s= {"���","��ͣ","�ָ�","���"};
		
		Listener act=new Listener(jf,g);
		
		for(int i=0;i<4;i++){
			JButton jb=new JButton(s[i]);
			jb.setActionCommand(null);
			jb.addActionListener(act);
			jp.add(jb);
		}
		
		jp.setPreferredSize (new Dimension(600,50));
		jp.setBackground(Color.black);
		jf.add(jp,BorderLayout.NORTH);	
		this.setVisible(true);
	}

	public static void main(String[] args) {
		UI u=new UI();
		u.init();
	}

}
