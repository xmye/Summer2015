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
	private int[][] weightArray = new int[11][11];// 用于储存权值
	private int weight;// 权值
	private int m, n;// 保存最大权值的行列

	HashMap<String, Integer> map = new HashMap<String, Integer>(); // 权值

	public AIListener() {
		map.put("010", 10); // 活一连
		map.put("001", 10);
		map.put("0110", 100); // 活二连
		map.put("01010", 100);
		map.put("01110", 1000); // 活三连
		map.put("011010", 1000);
		map.put("010110", 1000);
		map.put("011110", 10000); // 活四连
		map.put("0111010", 10000);
		map.put("0110110", 10000);
		map.put("0101110", 10000);
		map.put("210", 1); // 死一连
		map.put("012", 1);
		map.put("2110", 5); // 死二连
		map.put("0112", 5);
		map.put("21110", 20); // 死三连
		map.put("01112", 20);
		map.put("011112", 10000); // 死四连
		map.put("211110", 10000);
	}

	public void setArray(int[][] array) {// 获取数组
		this.array = array;
	}

	public void setG(Graphics g) {// 用于获取GameWZQ的画笔
		this.g = g;
	}

	public void setT(AI jf) {// 获取窗体对象
		this.jf = jf;
	}

	public void mouseClicked(MouseEvent e) {
		if (array[hx][dy] == 0) { // 画旗子，不能覆盖
			if (flag == 1) { // 黑白交替 人下
				g.setColor(Color.WHITE);
				g.fillOval(30 + hx * 50, 30 + dy * 50, 40, 40);
				array[hx][dy] = flag; // 储存旗子
				flag = 2;
				count++;
			} else if (flag == 2) {// AI
				for (int i = 0; i < array.length - 6; i++) {
					for (int j = 0; j < array[i].length - 6; j++) {
						if (array[i][j] == 0) {
							// 根据棋子相连的情况去map中获取权值
							// 水平向左
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

				int max = -1;// 保存最大权值
				for (int i = 0; i < weightArray.length; i++) { // 遍历数组找最大权值
					for (int j = 0; j < weightArray[i].length; j++) {
						if (weightArray[i][j] > max) {
							max = weightArray[i][j];
							System.out.println("max=" + max);
							m = i;
							n = j;
						}
					}
				}

				g.setColor(Color.black);// AI下棋
				System.out.println("m=" + m + "    " + "n=" + n);
				g.fillOval(30 + m * 50, 30 + n * 50, 40, 40);
				array[m][n] = flag;
				flag = 1;
				count++;
				setx[count] = m; // 将旗子坐标按顺序保存，用于悔棋
				sety[count] = n;
			}
			// 横向
			if (winh(hx, dy) >= 5) {
				if (array[hx][dy] == 2) {
					JOptionPane.showConfirmDialog(null, "黑棋赢！");
				}
				if (array[hx][dy] == 1) {
					JOptionPane.showConfirmDialog(null, "白棋赢！");
				}
			}
			// 纵向
			if (wind(hx, dy) >= 5) {
				if (array[hx][dy] == 2) {
					JOptionPane.showConfirmDialog(null, "黑棋赢！");
				}
				if (array[hx][dy] == 1) {
					JOptionPane.showConfirmDialog(null, "白棋赢！");
				}
			}
			// 斜向
			if (winyx(hx, dy) >= 5) {
				if (array[hx][dy] == 2) {
					JOptionPane.showConfirmDialog(null, "黑棋赢！");
				}
				if (array[hx][dy] == 1) {
					JOptionPane.showConfirmDialog(null, "白棋赢！");
				}
			}

			// 斜向
			if (winzx(hx, dy) >= 5) {
				if (array[hx][dy] == 2) {
					JOptionPane.showConfirmDialog(null, "黑棋赢！");
				}
				if (array[hx][dy] == 1) {
					JOptionPane.showConfirmDialog(null, "白棋赢！");
				}
			}
		}
	}

	// 横向判断
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

	// 纵向判断
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
	 * 右斜判断
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
	 * 左斜判断
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
		// 将旗子画在交点
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
		if (s.equals("开始")) {
			flag = 1;
			g.fillOval(280, 280, 40, 40);
			g.setColor(Color.black);

		} else if (s.equals("重来")) {

			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					array[i][j] = 0;
				}
			}

			jf.repaint();// 调用窗体中的重写方法

		} else if (s.equals("悔棋")) {
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
