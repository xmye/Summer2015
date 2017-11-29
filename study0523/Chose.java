package study0523;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chose extends JFrame {

	public void initUI() {
		this.setTitle("五子棋");
		this.setSize(200, 300);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);// 自动隐藏并释放该窗体
		this.setLocationRelativeTo(null);

		JPanel jp = new JPanel();
		jp.setPreferredSize(new Dimension(0, 150));
		this.add(jp, BorderLayout.SOUTH);

		JPanel jp1 = new JPanel();
		jp1.setBackground(Color.gray);
		jp1.setPreferredSize(new Dimension(0, 150));
		this.add(jp1, BorderLayout.NORTH);

		JButton jb1 = new JButton("人人对战");
		JButton jb2 = new JButton("人机对战");

		this.setVisible(true);
		Blistener b = new Blistener(this);
		jb1.addActionListener(b);
		jb2.addActionListener(b);

		jp.add(jb1);
		jp1.add(jb2);

	}

	public static void main(String arg[]) {
		Chose game = new Chose();
		game.initUI();
	}
}
