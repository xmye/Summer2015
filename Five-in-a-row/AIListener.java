package study0523;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AIListener implements MouseListener, ActionListener {
	private int x1, y1;
	private Graphics g;
	private int[][] array;
	private int hx, dy;
	private int flag;
	private AI jf;
	private int count;
	private int[] setx = new int[121];
	private int[] sety = new int[121];
	private int[][] weightArray = new int[11][11];// ���ڴ���Ȩֵ
	private int weight;// Ȩֵ
	private int m, n;// �������Ȩֵ������

	HashMap<String, Integer> map = new HashMap<String, Integer>(); // Ȩֵ

	public AIListener() {
		map.put("010", 10); // ��һ��
		map.put("001", 10);
		map.put("0110", 100); // �����
		map.put("01010", 100);
		map.put("01110", 1000); // ������
		map.put("011010", 1000);
		map.put("010110", 1000);
		map.put("011110", 10000); // ������
		map.put("0111010", 10000);
		map.put("0110110", 10000);
		map.put("0101110", 10000);
		map.put("210", 1); // ��һ��
		map.put("012", 1);
		map.put("2110", 5); // ������
		map.put("0112", 5);
		map.put("21110", 20); // ������
		map.put("01112", 20);
		map.put("011112", 10000); // ������
		map.put("211110", 10000);
	}

	public void setArray(int[][] array) {// ��ȡ����
		this.array = array;
	}

	public void setG(Graphics g) {// ���ڻ�ȡGameWZQ�Ļ���
		this.g = g;
	}

	public void setT(AI jf) {// ��ȡ�������
		this.jf = jf;
	}

	public void mouseClicked(MouseEvent e) {
		if (array[hx][dy] == 0) { // �����ӣ����ܸ���
			if (flag == 1) { // �ڰ׽��� ����
				g.setColor(Color.WHITE);
				g.fillOval(30 + hx * 50, 30 + dy * 50, 40, 40);
				array[hx][dy] = flag; // ��������
				flag = 2;
				count++;
			} else if (flag == 2) {// AI
				for (int i = 0; i < array.length - 6; i++) {
					for (int j = 0; j < array[i].length - 6; j++) {
						if (array[i][j] == 0) {
							// �����������������ȥmap�л�ȡȨֵ
							// ˮƽ����
							System.out.println("weight="+weight);
							if (array[i + 1][j] == 1 && array[i + 2][j] == 0) {
								weight = map.get("001");
								System.out.println("weight="+weight);
								weightArray[i][j] += weight;
							}
							if (array[i + 1][j] == 0 && array[i + 2][j] == 1) {
								weight = map.get("010");
								System.out.println("weight="+weight);
								weightArray[i][j] += weight;
							}
							if (array[i + 1][j] == 1 && array[i + 2][j] == 1
									&& array[i + 3][j] == 0) {
								weight = map.get("0110");
								System.out.println("weight="+weight);
								weightArray[i][j] += weight;
							}
							if (array[i + 1][j] == 1 && array[i + 2][j] == 0
									&& array[i + 3][j] == 1
									&& array[i + 4][j] == 0) {
								weight = map.get("01010");
								weightArray[i][j] += weight;
							}
							if (array[i + 1][j] == 1 && array[i + 2][j] == 1
									&& array[i + 3][j] == 1
									&& array[i + 4][j] == 0) {
								weight = map.get("01110");
								weightArray[i][j] += weight;
							}
							if (array[i + 1][j] == 1 && array[i + 2][j] == 1
									&& array[i + 3][j] == 0
									&& array[i + 4][j] == 1
									&& array[i + 5][j] == 0) {
								weight = map.get("011010");
								weightArray[i][j] += weight;
							}
							if (array[i + 1][j] == 1 && array[i + 2][j] == 0
									&& array[i + 3][j] == 1
									&& array[i + 4][j] == 1
									&& array[i + 5][j] == 0) {
								weight = map.get("010110");
								weightArray[i][j] += weight;
							}
							if (array[i + 1][j] == 1 && array[i + 2][j] == 1
									&& array[i + 3][j] == 1
									&& array[i + 4][j] == 1
									&& array[i + 5][j] == 0) {
								weight = map.get("011110");
								weightArray[i][j] += weight;
							}
							if (array[i + 1][j] == 1 && array[i + 2][j] == 1
									&& array[i + 3][j] == 1
									&& array[i + 4][j] == 0
									&& array[i + 5][j] == 1
									&& array[i + 6][j] == 0) {
								weight = map.get("0111010");
								weightArray[i][j] += weight;
							}
							if (array[i + 1][j] == 1 && array[i + 2][j] == 1
									&& array[i + 3][j] == 0
									&& array[i + 4][j] == 1
									&& array[i + 5][j] == 1
									&& array[i + 6][j] == 0) {
								weight = map.get("0110110");
								weightArray[i][j] += weight;
							}
							if (array[i + 1][j] == 1 && array[i + 2][j] == 0
									&& array[i + 3][j] == 1
									&& array[i + 4][j] == 1
									&& array[i + 5][j] == 1
									&& array[i + 6][j] == 0) {
								weight = map.get("0101110");
								weightArray[i][j] += weight;
							}
						}
					}
				}

				int max = -1;// �������Ȩֵ
				for (int i = 0; i < weightArray.length; i++) { // �������������Ȩֵ
					for (int j = 0; j < weightArray[i].length; j++) {
						if (weightArray[i][j] > max) {
							max = weightArray[i][j];
							System.out.println("max=" + max);
							m = i;
							n = j;
						}
					}
				}

				g.setColor(Color.black);// AI����
				System.out.println("m=" + m + "    " + "n=" + n);
				g.fillOval(30 + m * 50, 30 + n * 50, 40, 40);
				array[m][n] = flag;
				flag = 1;
				count++;
				setx[count] = m; // ���������갴˳�򱣴棬���ڻ���
				sety[count] = n;
			}
			// ����
			if (winh(hx, dy) >= 5) {
				if (array[hx][dy] == 2) {
					JOptionPane.showConfirmDialog(null, "����Ӯ��");
				}
				if (array[hx][dy] == 1) {
					JOptionPane.showConfirmDialog(null, "����Ӯ��");
				}
			}
			// ����
			if (wind(hx, dy) >= 5) {
				if (array[hx][dy] == 2) {
					JOptionPane.showConfirmDialog(null, "����Ӯ��");
				}
				if (array[hx][dy] == 1) {
					JOptionPane.showConfirmDialog(null, "����Ӯ��");
				}
			}
			// б��
			if (winyx(hx, dy) >= 5) {
				if (array[hx][dy] == 2) {
					JOptionPane.showConfirmDialog(null, "����Ӯ��");
				}
				if (array[hx][dy] == 1) {
					JOptionPane.showConfirmDialog(null, "����Ӯ��");
				}
			}

			// б��
			if (winzx(hx, dy) >= 5) {
				if (array[hx][dy] == 2) {
					JOptionPane.showConfirmDialog(null, "����Ӯ��");
				}
				if (array[hx][dy] == 1) {
					JOptionPane.showConfirmDialog(null, "����Ӯ��");
				}
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
			g.fillOval(280, 280, 40, 40);
			g.setColor(Color.black);

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
