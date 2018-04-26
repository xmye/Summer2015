package ������;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyFrame extends JFrame implements ActionListener {

	private boolean isBlack = true;	// �Ƿ��ֵ�����
	private Board b = new Board();	// ���̶���
	private boolean isWin = false;	// �Ƿ���ʤ��
	private boolean isStart = false;	// �Ƿ������ɹ���ʼ��Ϸ
	private boolean isYourTurn = false;	// �Ƿ��ֵ��Լ�����

	private DataInputStream din = null;
	private DataOutputStream dout = null;
	private class MouseHandler extends MouseAdapter {
		
		public void mousePressed(MouseEvent e) {
			if (isStart && isYourTurn && !isWin) {	// ��Ϸ�Ѿ���ʼ�����ֵ��Լ���δ�ֳ�ʤ���������
				int x = e.getX();
				int y = e.getY();
				if (x >= 50 && x <= 540 && y >= 0 && y <= 540) {	// ���̷�Χ����
					// ͨ�������������������̵��к���
					int row = Math.round((y - 50) / 35f);
					int col = Math.round((x - 50) / 35f);
					if (b.addPiece(row, col, isBlack)) {	// ���ӳɹ�
						repaint();
						try {	// ��Է����̷��͸ղ����ӵ�λ��(�С���)�Լ����ӻ��ǰ���
							dout.writeInt(row);
							dout.writeInt(col);
							dout.writeBoolean(isBlack);
						} catch (IOException ex) {
							ex.printStackTrace();
						}
						isWin = b.isWin(row, col, isBlack);	// �ж��Ƿ��ʤ
						if (!isWin) {
							isYourTurn = !isYourTurn;	// ��δ�ֳ�ʤ���򽻻����巽
						} else {
							JOptionPane.showMessageDialog(null, isBlack ? "����ʤ"
									: "����ʤ");
							isWin = true;
							repaint();
						}
					}
				}
			}
		}
	}
	private JButton createGameButton, joinGameButton;
	private JPanel boardPanel;	// �������̵����
	public MyFrame() {
		this.setTitle("������");
		this.setSize(700, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		boardPanel = new MyPanel(b);
		boardPanel.setBounds(0, 0, 600, 600);
		this.add(boardPanel);

		boardPanel.addMouseListener(new MouseHandler());	// ������������������

		this.setLayout(null);
		createGameButton = new JButton("������Ϸ");
		createGameButton.setBounds(580, 100, 100, 35);
		createGameButton.addActionListener(this);
		joinGameButton = new JButton("������Ϸ");
		joinGameButton.setBounds(580, 160, 100, 35);
		joinGameButton.addActionListener(this);
		this.add(createGameButton);
		this.add(joinGameButton);
		// ����һ���̼߳����Է��������Ϣ
		new Thread(new Runnable() {

		public void run() {
		while (true) {	// ѭ�������Է����͵�������Ϣ
		while (isStart && !isYourTurn) {
		try {
		// ��ȡ�Է����ӵ������Լ��Ǻ��ӻ��ǰ���
		 int row = din.readInt();
	     int col = din.readInt();
		 boolean isBlack = din.readBoolean();
		 b.addPiece(row, col, isBlack);	// ��������ӶԷ��ߵ�����
		 repaint();
				if(b.isWin(row, col, isBlack)) {
				JOptionPane.showMessageDialog(null, isBlack ? "����ʤ": "����ʤ");
						isWin = true;
						repaint();
							}
							isYourTurn = !isYourTurn;	// �յ��Է����Ӻ󽻻����巽
							} catch (IOException ex) {
							ex.printStackTrace();
							}
							}
						}
					}
				}).start();	
			}

	     public static void main(String[] args) {
		     new MyFrame().setVisible(true);
	      }

	     public void actionPerformed(ActionEvent e) {
	 		String command = e.getActionCommand();
	 		if (command.equals("������Ϸ")) {

	 			// ����һ���߳������������׽���
	 			new Thread(new Runnable() {
	 				public void run() {
	 					try {
	 						ServerSocket server = new ServerSocket(65535);
	 						Socket client = server.accept();
	 						din = new DataInputStream(client.getInputStream());
	 						dout = new DataOutputStream(client.getOutputStream());
	 						isStart = true;
	 						isBlack = true;
	 						isYourTurn = true;
	 					} catch (IOException e) {
	 						e.printStackTrace();
	 					}
	 				}
	 			}).start();

	 			joinGameButton.setEnabled(false);
	 		} else if (command.equals("������Ϸ")) {
	 			String ip = JOptionPane.showInputDialog(this, "��������Ϸ����IP��ַ�������: ");
	 			if(ip != null && !ip.equals("")) {
	 				try {
	 					Socket client = new Socket(ip, 65535);
	 					din = new DataInputStream(client.getInputStream());
	 					dout = new DataOutputStream(client.getOutputStream());
	 					isStart = true;
	 					isYourTurn = false;
	 					isBlack = false;
	 				} catch (Exception ex) {
	 					ex.printStackTrace();
	 				}
	 				repaint();
	 				createGameButton.setEnabled(false);
	 			}
	 		}
	 	}









}
