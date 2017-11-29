package study0523;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Mouse implements MouseListener, ActionListener {
	private int x1, y1;
	private Graphics g;
	private int[][] array;
	private int hx, dy;
	private int flag;
	private GameWZQ jf;
	private int count;
	private int[] setx = new int[121];
	private int[] sety = new int[121];

	// ��ȡ����
	public void setArray(int[][] array) {
		this.array = array;
	}

	// ���ڻ�ȡGameWZQ�Ļ���
	public void setG(Graphics g) {
		this.g = g;
	}

	// ��ȡ�������
	public void setT(GameWZQ jf) {
		this.jf = jf;
	}


	public void mouseClicked(MouseEvent e) {
		if (array[hx][dy] == 0) { // �����ӣ����ܸ���
			if (flag == 1) { // �ڰ׽���
				g.setColor(Color.BLACK);
				g.fillOval(30 + hx * 50, 30 + dy * 50, 40, 40);
				array[hx][dy] = flag; // ��������
				flag = 2;
				count++;
			} else if (flag == 2) {
				g.setColor(Color.WHITE);
				g.fillOval(30 + hx * 50, 30 + dy * 50, 40, 40);
				array[hx][dy] = flag;
				flag = 1;
				count++;
			}
			setx[count] = hx; // ���������갴˳�򱣴棬���ڻ���
			sety[count] = dy;
		}
		// ����
		if (winh(hx, dy) >= 5) {
			if (array[hx][dy] == 1) {
				JOptionPane.showConfirmDialog(null, "����Ӯ��");
			}
			if (array[hx][dy] == 2) {
				JOptionPane.showConfirmDialog(null, "����Ӯ��");
			}
		}
		// ����
		if (wind(hx, dy) >= 5) {
			if (array[hx][dy] == 1) {
				JOptionPane.showConfirmDialog(null, "����Ӯ��");
			}
			if (array[hx][dy] == 2) {
				JOptionPane.showConfirmDialog(null, "����Ӯ��");
			}
		}
		// б��
		if (winyx(hx, dy) >= 5) {
			if (array[hx][dy] == 1) {
				JOptionPane.showConfirmDialog(null, "����Ӯ��");
			}
			if (array[hx][dy] == 2) {
				JOptionPane.showConfirmDialog(null, "����Ӯ��");
			}
		}

		// б��
		if (winzx(hx, dy) >= 5) {
			if (array[hx][dy] == 1) {
				JOptionPane.showConfirmDialog(null, "����Ӯ��");
			}
			if (array[hx][dy] == 2) {
				JOptionPane.showConfirmDialog(null, "����Ӯ��");
			}
		}
	}

	// �����ж�
	public int winh(int hx, int dy) {
		int count = 1;
		for (int i = hx + 1; i < array.length; i++) {
			if (array[hx][dy] == array[i][dy]) {
				count++;
			} else {
				break;
			}
		}
		for (int j = hx - 1; j >= 0; j--) {
			if (array[hx][dy] == array[j][dy]) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}

	// �����ж�
	public int wind(int hx, int dy) {
		int count = 1;
		for (int i = dy + 1; i < array.length; i++) {
			if (array[hx][dy] == array[hx][i]) {
				count++;
			} else {
				break;
			}
		}
		for (int j = dy - 1; j >= 0; j--) {
			if (array[hx][dy] == array[hx][j]) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}

	/**
	 * ��б�ж�
	 * 
	 * @param hx
	 * @param dy
	 * @return
	 */
	public int winyx(int hx, int dy) {
		int count = 1;
		for (int i = hx + 1, j = dy + 1; i < array.length && j < array.length; i++, j++) {
			if (array[hx][dy] == array[i][j]) {
				count++;
			} else {
				break;
			}
		}
		for (int p = hx - 1, q = dy - 1; p >= 0 && q >= 0; p--, q--) {
			if (array[hx][dy] == array[p][q]) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}

	/**
	 * ��б�ж�
	 * 
	 * @param hx
	 * @param dy
	 * @return
	 */
	public int winzx(int hx, int dy) {
		int count = 1;
		for (int i = hx - 1, j = dy + 1; i >= 0 && j < array.length; i--, j++) {
			if (array[hx][dy] == array[i][j]) {
				count++;
			} else {
				break;
			}
		}
		for (int p = hx + 1, q = dy - 1; p < array.length && q >= 0; p++, q--) {
			if (array[hx][dy] == array[p][q]) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}

	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
	}

	public void mouseReleased(MouseEvent e) {
		// �����ӻ��ڽ���
		if ((x1 - 50) % 50 > 25) {
			hx = (x1 - 50) / 50 + 1;
		} else {
			hx = (x1 - 50) / 50;
		}
		if ((y1 - 50) % 50 > 25) {
			dy = (y1 - 50) / 50 + 1;
		} else {
			dy = (y1 - 50) / 50;
		}
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("��ʼ")) {
			flag = 1;

		} else if (s.equals("����")) {

			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					array[i][j] = 0;
				}
			}

			jf.repaint();// ���ô����е���д����

		} else if (s.equals("����")) {
			huiqi();
			jf.repaint();
		}
	}

	public void huiqi() {
		if (count > 0) {
			int x = setx[count];
			int y = sety[count];
			array[x][y] = 0;
			count--;
		}
	}
}
