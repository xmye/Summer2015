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
	private int[][] array = new int[11][11];//存棋盘行列，颜色

	AIListener m = new AIListener();	// 实现事件类

	public void initUI() {
		this.setTitle("五子棋");
		this.setDefaultCloseOperation(3);
		this.setSize(600, 640);
		this.setLocationRelativeTo(null);

		
		JMenuBar jm = new JMenuBar();// 添加菜单
		
		JMenu jm1 = new JMenu("file");// 添加菜单上的条目
		JMenu jm2 = new JMenu("edit");
		
		JMenuItem jme = new JMenuItem("open");// 条目下的下拉栏
		JMenuItem jme2 = new JMenuItem("save");
		JMenuItem jme3 = new JMenuItem("delete");
		jm1.add(jme);
		jm1.add(jme2);
		jm2.add(jme3);
		this.add(jm, BorderLayout.NORTH);
		jm.add(jm1);
		jm.add(jm2);

		this.setVisible(true); // 可见

		
		JPanel jp = new JPanel();// 增加面板用于增加按钮
		jp.setBackground(Color.gray);
		jp.setPreferredSize(new Dimension(0, 55));
		this.add(jp, BorderLayout.SOUTH);

		
		JButton jb1 = new JButton("开始");// 添加按钮
		jb1.setPreferredSize(new Dimension(70, 35));
		JButton jb2 = new JButton("悔棋");
		jb2.setPreferredSize(new Dimension(70, 35));
		JButton jb3 = new JButton("重来");
		jb3.setPreferredSize(new Dimension(70, 35));
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);

	
		jb1.addActionListener(m);// 添加监听器
		jb2.addActionListener(m);
		jb3.addActionListener(m);
		
		m.setArray(array);// 传递数组
		
		Graphics g = this.getGraphics();// 获取画笔
		
		m.setG(g);// 将画笔传给事件类
		
		this.addMouseListener(m);
		
		m.setT(this);// 传窗体对象

		// ImageIcon im=new ImageIcon("image/麦田.jpg"); //设置背景图片
		// JLabel jl=new JLabel(im);
		// this.getLayeredPane().add(jl,new Integer(Integer.MIN_VALUE)); //底层面板
		// jl.setBounds(0, 0, im.getIconWidth(), im.getIconHeight()); //图片的大小
		// Container container=this.getContentPane(); //中层面板
		// JPanel jp2=(JPanel)container; //转型
		// jp2.setOpaque(false); //设置中层透明
		// }
		// private Dimension Dimension(int i, int j) {
		// // TODO Auto-generated method stub
		// return null;
		//

	}

	// 重写画窗体的函数
	public void paint(Graphics g) {
		super.paint(g); // super调用父类的方法
		for (int i = 0; i < 11; i++) { // 画网格
			g.drawLine(50, 50 + 50 * i, 550, 50 + 50 * i);
			g.drawLine(50 + 50 * i, 50, 50 + 50 * i, 550);
		}

		// 重画旗子
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
