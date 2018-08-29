package study0523;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class AI extends JFrame {
	private int flag = 1;
	private int[][] array = new int[11][11];//���������У���ɫ

	AIListener m = new AIListener();	// ʵ���¼���

	public void initUI() {
		this.setTitle("������");
		this.setDefaultCloseOperation(3);
		this.setSize(600, 640);
		this.setLocationRelativeTo(null);

		
		JMenuBar jm = new JMenuBar();// ��Ӳ˵�
		
		JMenu jm1 = new JMenu("file");// ��Ӳ˵��ϵ���Ŀ
		JMenu jm2 = new JMenu("edit");
		
		JMenuItem jme = new JMenuItem("open");// ��Ŀ�µ�������
		JMenuItem jme2 = new JMenuItem("save");
		JMenuItem jme3 = new JMenuItem("delete");
		jm1.add(jme);
		jm1.add(jme2);
		jm2.add(jme3);
		this.add(jm, BorderLayout.NORTH);
		jm.add(jm1);
		jm.add(jm2);

		this.setVisible(true); // �ɼ�

		
		JPanel jp = new JPanel();// ��������������Ӱ�ť
		jp.setBackground(Color.gray);
		jp.setPreferredSize(new Dimension(0, 55));
		this.add(jp, BorderLayout.SOUTH);

		
		JButton jb1 = new JButton("��ʼ");// ��Ӱ�ť
		jb1.setPreferredSize(new Dimension(70, 35));
		JButton jb2 = new JButton("����");
		jb2.setPreferredSize(new Dimension(70, 35));
		JButton jb3 = new JButton("����");
		jb3.setPreferredSize(new Dimension(70, 35));
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);

	
		jb1.addActionListener(m);// ��Ӽ�����
		jb2.addActionListener(m);
		jb3.addActionListener(m);
		
		m.setArray(array);// ��������
		
		Graphics g = this.getGraphics();// ��ȡ����
		
		m.setG(g);// �����ʴ����¼���
		
		this.addMouseListener(m);
		
		m.setT(this);// ���������

		// ImageIcon im=new ImageIcon("image/����.jpg"); //���ñ���ͼƬ
		// JLabel jl=new JLabel(im);
		// this.getLayeredPane().add(jl,new Integer(Integer.MIN_VALUE)); //�ײ����
		// jl.setBounds(0, 0, im.getIconWidth(), im.getIconHeight()); //ͼƬ�Ĵ�С
		// Container container=this.getContentPane(); //�в����
		// JPanel jp2=(JPanel)container; //ת��
		// jp2.setOpaque(false); //�����в�͸��
		// }
		// private Dimension Dimension(int i, int j) {
		// // TODO Auto-generated method stub
		// return null;
		//

	}

	// ��д������ĺ���
	public void paint(Graphics g) {
		super.paint(g); // super���ø���ķ���
		for (int i = 0; i < 11; i++) { // ������
			g.drawLine(50, 50 + 50 * i, 550, 50 + 50 * i);
			g.drawLine(50 + 50 * i, 50, 50 + 50 * i, 550);
		}

		// �ػ�����
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i][j] == 1) {
					g.setColor(Color.WHITE);
					g.fillOval(30 + i * 50, 30 + j * 50, 40, 40);
				} else if (array[i][j] == 2) {
					g.setColor(Color.BLACK);
					g.fillOval(30 + i * 50, 30 + j * 50, 40, 40);
				}
			}
		}
	}

}
