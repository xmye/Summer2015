package study0523;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Blistener implements ActionListener {
	GameWZQ game = new GameWZQ();
	AI ai = new AI();
	private JFrame jf;

	public Blistener(JFrame jf) {//���봰�壬���ڹرմ���
		this.jf = jf;
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s == "���˶�ս") {
			game.initUI();
		} else if (s == "�˻���ս") {
			ai.initUI();
		}
		jf.dispose();// �ر�ѡ�񴰿�
	}

}
