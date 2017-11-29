package study0523;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Blistener implements ActionListener {
	GameWZQ game = new GameWZQ();
	AI ai = new AI();
	private JFrame jf;

	public Blistener(JFrame jf) {//传入窗体，用于关闭窗体
		this.jf = jf;
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s == "人人对战") {
			game.initUI();
		} else if (s == "人机对战") {
			ai.initUI();
		}
		jf.dispose();// 关闭选择窗口
	}

}
