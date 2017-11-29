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

public class RenjiMouse implements MouseListener, ActionListener {
	private int x1, y1;
	private Graphics g;
	private int[][] array;//棋盘行列，颜色
	private int hx, dy;
	private int flag;//黑白标志
	private GameWZQ jf;
	private int count;
	private int[] setx = new int[121];
	private int[] sety = new int[121];
	private int[][] weightarray = new int[11][11]; // 用于储存权值
	private int a;
	private int m; // 用于保存最大权值的行列
	private int n;
	private int p; // 用于保存机器下棋的列
	private int weight;

	HashMap<String, Integer> map = new HashMap<String, Integer>(); // 权值

	public RenjiMouse() {
		map.put("010", 10); // 活一连
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

	public void setT(GameWZQ jf) {// 获取窗体对象
		this.jf = jf;
	}

	public void mouseClicked(MouseEvent e) {
		if (array[hx][dy] == 0) { // 画旗子，不能覆盖
			if (flag == 1) { // 黑白交替
				for (int i = 4; i <= array.length-4; i++) { // 全盘遍历
					System.out.println("array.length="+array.length);
					for (int j = 4; j <= array[i].length-4 ; j++) {
						System.out.println("weight="+weightarray[i][j]);
						if (array[i][j] == 1) {
							// 010 //水平方向
							if (array[i - 1][j] == 0 && array[i + 1][j] == 0) {
								weight = map.get("010"); // 活一连
								weightarray[i][j] += weight;
							}
							// 01010
							if (array[i - 1][j] == 0 && array[i + 1][j] == 0
									&& array[i + 2][j] == 1
									&& array[i + 3][j] == 0) { // 活二连
								weight = map.get("01010");
								weightarray[i][j] += weight;
							}
							if (array[i - 3][j] == 0 && array[i - 2][j] == 1
									&& array[i - 1][j] == 0
									&& array[i + 1][j] == 0) { // 活二连
								weight = map.get("01010");
								weightarray[i][j] += weight;
							}
							// 0110
							if (array[i - 1][j] == 0 && array[i + 1][j] == 1
									&& array[i + 2][j] == 0) { // 活二连
								weight = map.get("0110");
								weightarray[i][j] += weight;
							}
							if (array[i - 2][j] == 0 && array[i - 1][j] == 1
									&& array[i + 1][j] == 0) { // 活二连
								weight = map.get("0110");
								weightarray[i][j] += weight;
							}
							// 01110
							if (array[i - 1][j] == 0 && array[i + 1][j] == 1
									&& array[i + 2][j] == 1
									&& array[i + 3][j] == 0) { // 活三连
								weight = map.get("01110");
								weightarray[i][j] += weight;
							}
							if (array[i - 2][j] == 0 && array[i - 1][j] == 1
									&& array[i + 1][j] == 1
									&& array[i + 2][j] == 0) { // 活三连
								weight = map.get("01110");
								weightarray[i][j] += weight;
							}
							if (array[i - 3][j] == 0 && array[i - 2][j] == 1
									&& array[i - 1][j] == 1
									&& array[i + 1][j] == 0) { // 活三连
								weight = map.get("01110");
								weightarray[i][j] += weight;
							}
							// 011010
							if (array[i - 1][j] == 0 && array[i + 1][j] == 1
									&& array[i + 2][j] == 0
									&& array[i + 3][j] == 1
									&& array[i + 4][j] == 0) { // 活三连
								weight = map.get("011010");
								weightarray[i][j] += weight;
							}
							if (array[i - 2][j] == 0 && array[i - 1][j] == 1
									&& array[i + 1][j] == 0
									&& array[i + 2][j] == 1
									&& array[i + 3][j] == 0) { // 活三连
								weight = map.get("011010");
								weightarray[i][j] += weight;
							}
							if (array[i - 4][j] == 0 && array[i - 3][j] == 1
									&& array[i - 2][j] == 0
									&& array[i - 1][j] == 0
									&& array[i + 1][j] == 0) { // 活三连
								weight = map.get("011010");
								weightarray[i][j] += weight;
							}
							// 010110
							if (array[i - 1][j] == 0 && array[i + 1][j] == 0
									&& array[i + 2][j] == 1
									&& array[i + 3][j] == 1
									&& array[i + 4][j] == 0) { // 活三连
								weight = map.get("010110");
								weightarray[i][j] += weight;
							}
							if (array[i - 3][j] == 0 && array[i - 2][j] == 1
									&& array[i - 1][j] == 0
									&& array[i + 1][j] == 1
									&& array[i + 2][j] == 0) { // 活三连
								weight = map.get("010110");
								weightarray[i][j] += weight;
							}
							if (array[i - 4][j] == 0 && array[i - 3][j] == 1
									&& array[i - 2][j] == 0
									&& array[i - 1][j] == 1
									&& array[i + 1][j] == 0) { // 活三连
								weight = map.get("010110");
								weightarray[i][j] += weight;
							}
							// 011110
							if (array[i - 4][j] == 0 && array[i - 3][j] == 1
									&& array[i - 2][j] == 1
									&& array[i - 1][j] == 1
									&& array[i + 1][j] == 0) { // 活四连
								weight = map.get("011110");
								weightarray[i][j] += weight;
							}
							if (array[i - 3][j] == 0 && array[i - 2][j] == 1
									&& array[i - 1][j] == 1
									&& array[i + 1][j] == 1
									&& array[i + 2][j] == 0) { // 活四连
								weight = map.get("011110");
								weightarray[i][j] += weight;
							}
							if (array[i - 2][j] == 0 && array[i - 1][j] == 1
									&& array[i + 1][j] == 1
									&& array[i + 2][j] == 1
									&& array[i + 3][j] == 0) { // 活四连
								weight = map.get("011110");
								weightarray[i][j] += weight;
							}
							if (array[i - 1][j] == 0 && array[i + 1][j] == 1
									&& array[i + 2][j] == 1
									&& array[i + 3][j] == 1
									&& array[i + 4][j] == 0) { // 活四连
								weight = map.get("011110");
								weightarray[i][j] += weight;
							}
							// 0111010
							if (array[i - 1][j] == 0 && array[i + 1][j] == 1
									&& array[i + 2][j] == 1
									&& array[i + 3][j] == 0
									&& array[i + 4][j] == 1
									&& array[i + 5][j] == 0) { // 活四连
								weight = map.get("0111010");
								weightarray[i][j] += weight;
							}
							if (array[i - 2][j] == 0 && array[i - 1][j] == 1
									&& array[i + 1][j] == 1
									&& array[i + 2][j] == 0
									&& array[i + 3][j] == 1
									&& array[i + 4][j] == 0) { // 活四连
								weight = map.get("0111010");
								weightarray[i][j] += weight;
							}
							if (array[i - 3][j] == 0 && array[i - 2][j] == 1
									&& array[i - 1][j] == 1
									&& array[i + 1][j] == 0
									&& array[i + 2][j] == 1
									&& array[i + 3][j] == 0) { // 活四连
								weight = map.get("0111010");
								weightarray[i][j] += weight;
							}
							if (array[i - 5][j] == 0 && array[i - 4][j] == 1
									&& array[i - 3][j] == 1
									&& array[i - 2][j] == 0
									&& array[i - 1][j] == 1
									&& array[i + 1][j] == 0) { // 活四连
								weight = map.get("0111010");
								weightarray[i][j] += weight;
							}
							// 0110110
							if (array[i - 1][j] == 0 && array[i + 1][j] == 1
									&& array[i + 2][j] == 1
									&& array[i + 3][j] == 0
									&& array[i + 4][j] == 1
									&& array[i + 5][j] == 0) { // 活四连
								weight = map.get("0110110");
								weightarray[i][j] += weight;
							}
							if (array[i - 2][j] == 0 && array[i - 1][j] == 1
									&& array[i + 1][j] == 0
									&& array[i + 2][j] == 1
									&& array[i + 3][j] == 1
									&& array[i + 4][j] == 0) { // 活四连
								weight = map.get("0110110");
								weightarray[i][j] += weight;
							}
							if (array[i - 4][j] == 0 && array[i - 3][j] == 1
									&& array[i - 2][j] == 1
									&& array[i - 1][j] == 0
									&& array[i + 1][j] == 1
									&& array[i + 2][j] == 0) { // 活四连
								weight = map.get("0110110");
								weightarray[i][j] += weight;
							}
							if (array[i - 5][j] == 0 && array[i - 4][j] == 1
									&& array[i - 3][j] == 1
									&& array[i - 2][j] == 0
									&& array[i - 1][j] == 1
									&& array[i + 1][j] == 0) { // 活四连
								weight = map.get("0110110");
								weightarray[i][j] += weight;
							}
							// 0101110
							if (array[i - 1][j] == 0 && array[i + 1][j] == 0
									&& array[i + 2][j] == 1
									&& array[i + 3][j] == 1
									&& array[i + 4][j] == 1
									&& array[i + 5][j] == 0) { // 活四连
								weight = map.get("0101110");
								weightarray[i][j] += weight;
							}
							if (array[i - 3][j] == 0 && array[i - 2][j] == 1
									&& array[i - 1][j] == 0
									&& array[i + 1][j] == 1
									&& array[i + 2][j] == 1
									&& array[i + 3][j] == 0) { // 活四连
								weight = map.get("0101110");
								weightarray[i][j] += weight;
							}
							if (array[i - 4][j] == 0 && array[i - 3][j] == 1
									&& array[i - 2][j] == 0
									&& array[i - 1][j] == 1
									&& array[i + 1][j] == 1
									&& array[i + 2][j] == 0) { // 活四连
								weight = map.get("0101110");
								weightarray[i][j] += weight;
							}
							if (array[i - 5][j] == 0 && array[i - 4][j] == 1
									&& array[i - 3][j] == 0
									&& array[i - 2][j] == 1
									&& array[i - 1][j] == 1
									&& array[i + 1][j] == 0) { // 活四连
								weight = map.get("0101110");
								weightarray[i][j] += weight;
							}
							// 012
							if (array[i - 1][j] == 0 && array[i + 1][j] == 2) { // 死一连
								weight = map.get("012");
								weightarray[i][j] += weight;
							}
							// 210
							if (array[i - 1][j] == 2 && array[i + 1][j] == 0) { // 死一连
								weight = map.get("210");
								weightarray[i][j] += weight;
							}
							// 0112
							if (array[i - 1][j] == 0 && array[i + 1][j] == 1
									&& array[i + 2][j] == 2) { // 死二连
								weight = map.get("0112");
								weightarray[i][j] += weight;
							}
							if (array[i - 2][j] == 0 && array[i - 1][j] == 1
									&& array[i + 1][j] == 2) { // 死二连
								weight = map.get("0112");
								weightarray[i][j] += weight;
							}
							// 2110
							if (array[i - 1][j] == 2 && array[i + 1][j] == 1
									&& array[i + 2][j] == 0) { // 死二连
								weight = map.get("2110");
								weightarray[i][j] += weight;
							}
							if (array[i - 2][j] == 2 && array[i - 1][j] == 1
									&& array[i + 1][j] == 0) { // 死二连
								weight = map.get("2110");
								weightarray[i][j] += weight;
							}
							// 21110
							if (array[i - 1][j] == 2 && array[i + 1][j] == 1
									&& array[i + 2][j] == 1
									&& array[i + 3][j] == 0) { // 死三连
								weight = map.get("21110");
								weightarray[i][j] += weight;
							}
							if (array[i - 2][j] == 2 && array[i - 1][j] == 1
									&& array[i + 1][j] == 1
									&& array[i + 2][j] == 0) { // 死三连
								weight = map.get("21110");
								weightarray[i][j] += weight;
							}
							if (array[i - 3][j] == 2 && array[i - 2][j] == 1
									&& array[i - 1][j] == 1
									&& array[i + 1][j] == 0) { // 死三连
								weight = map.get("21110");
								weightarray[i][j] += weight;
							}
							// 01112
							if (array[i - 1][j] == 0 && array[i + 1][j] == 1
									&& array[i + 2][j] == 1
									&& array[i + 3][j] == 2) { // 死三连
								weight = map.get("01112");
								weightarray[i][j] += weight;
							}
							if (array[i - 1][j] == 0 && array[i + 1][j] == 1
									&& array[i + 2][j] == 1
									&& array[i + 3][j] == 2) { // 死三连
								weight = map.get("01112");
								weightarray[i][j] += weight;
							}
							if (array[i - 1][j] == 0 && array[i + 1][j] == 1
									&& array[i + 2][j] == 1
									&& array[i + 3][j] == 2) { // 死三连
								weight = map.get("01112");
								weightarray[i][j] += weight;
							}
							//
							if (array[i - 1][j] == 0 && array[i + 1][j] == 1
									&& array[i + 2][j] == 1
									&& array[i + 3][j] == 1
									&& array[i + 4][j] == 2) { // 死四连
								weight = map.get("011112");
								weightarray[i][j] += weight;
							}
							if (array[i - 1][j] == 2 && array[i + 1][j] == 1
									&& array[i + 2][j] == 1
									&& array[i + 3][j] == 1
									&& array[i + 4][j] == 0) { // 死四连
								weight = map.get("211110");
								weightarray[i][j] += weight;
							}
							// 垂直方向
							// 010
							if (array[i][j - 1] == 0 && array[i][j + 1] == 0) {
								weight = map.get("010"); // 活一连
								weightarray[i][j] += weight;
							}
							// 01010
							if (array[i][j - 1] == 0 && array[i][j + 1] == 0
									&& array[i][j + 2] == 1
									&& array[i][j + 3] == 0) { // 活二连
								weight = map.get("01010");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 3] == 0 && array[i][j - 2] == 1
									&& array[i][j - 1] == 0
									&& array[i][j + 1] == 0) { // 活二连
								weight = map.get("01010");
								weightarray[i][j] += weight;
							}
							// 0110
							if (array[i][j - 1] == 0 && array[i][j + 1] == 1
									&& array[i][j + 2] == 0) { // 活二连
								weight = map.get("0110");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 2] == 0 && array[i][j - 1] == 1
									&& array[i][j + 1] == 0) { // 活二连
								weight = map.get("0110");
								weightarray[i][j] += weight;
							}
							// 01110
							if (array[i][j - 1] == 0 && array[i][j + 1] == 1
									&& array[i][j + 2] == 1
									&& array[i][j + 3] == 0) { // 活三连
								weight = map.get("01110");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 2] == 0 && array[i][j - 1] == 1
									&& array[i][j + 1] == 1
									&& array[i][j + 2] == 0) { // 活三连
								weight = map.get("01110");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 3] == 0 && array[i][j - 2] == 1
									&& array[i][j - 1] == 1
									&& array[i][j + 1] == 0) { // 活三连
								weight = map.get("01110");
								weightarray[i][j] += weight;
							}
							// 011010
							if (array[i][j - 1] == 0 && array[i][j + 1] == 1
									&& array[i][j + 2] == 0
									&& array[i][j + 3] == 1
									&& array[i][j + 4] == 0) { // 活三连
								weight = map.get("011010");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 2] == 0 && array[i][j - 1] == 1
									&& array[i][j + 1] == 0
									&& array[i][j + 2] == 1
									&& array[i][j + 3] == 0) { // 活三连
								weight = map.get("011010");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 4] == 0 && array[i][j - 3] == 1
									&& array[i][j - 2] == 0
									&& array[i][j - 1] == 0
									&& array[i][j + 1] == 0) { // 活三连
								weight = map.get("011010");
								weightarray[i][j] += weight;
							}
							// 010110
							if (array[i][j - 1] == 0 && array[i][j + 1] == 0
									&& array[i][j + 2] == 1
									&& array[i][j + 3] == 1
									&& array[i][j + 4] == 0) { // 活三连
								weight = map.get("010110");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 3] == 0 && array[i][j - 2] == 1
									&& array[i][j - 1] == 0
									&& array[i][j + 1] == 1
									&& array[i][j + 2] == 0) { // 活三连
								weight = map.get("010110");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 4] == 0 && array[i][j - 3] == 1
									&& array[i][j - 2] == 0
									&& array[i][j - 1] == 1
									&& array[i][j + 1] == 0) { // 活三连
								weight = map.get("010110");
								weightarray[i][j] += weight;
							}
							// 011110
							if (array[i][j - 4] == 0 && array[i][j - 3] == 1
									&& array[i][j - 2] == 1
									&& array[i][j - 1] == 1
									&& array[i][j + 1] == 0) { // 活四连
								weight = map.get("011110");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 3] == 0 && array[i][j - 2] == 1
									&& array[i][j - 1] == 1
									&& array[i][j + 1] == 1
									&& array[i][j + 2] == 0) { // 活四连
								weight = map.get("011110");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 2] == 0 && array[i][j - 1] == 1
									&& array[i][j + 1] == 1
									&& array[i][j + 2] == 1
									&& array[i][j + 3] == 0) { // 活四连
								weight = map.get("011110");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 1] == 0 && array[i][j + 1] == 1
									&& array[i][j + 2] == 1
									&& array[i][j + 3] == 1
									&& array[i][j + 4] == 0) { // 活四连
								weight = map.get("011110");
								weightarray[i][j] += weight;
							}
							// 0111010
							if (array[i][j - 1] == 0 && array[i][j + 1] == 1
									&& array[i][j + 2] == 1
									&& array[i][j + 3] == 0
									&& array[i][j + 4] == 1
									&& array[i][j + 5] == 0) { // 活四连
								weight = map.get("0111010");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 2] == 0 && array[i][j - 1] == 1
									&& array[i][j + 1] == 1
									&& array[i][j + 2] == 0
									&& array[i][j + 3] == 1
									&& array[i][j + 4] == 0) { // 活四连
								weight = map.get("0111010");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 3] == 0 && array[i][j - 2] == 1
									&& array[i][j - 1] == 1
									&& array[i][j + 1] == 0
									&& array[i][j + 2] == 1
									&& array[i][j + 3] == 0) { // 活四连
								weight = map.get("0111010");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 5] == 0 && array[i][j - 4] == 1
									&& array[i][j - 3] == 1
									&& array[i][j - 2] == 0
									&& array[i][j - 1] == 1
									&& array[i][j + 1] == 0) { // 活四连
								weight = map.get("0111010");
								weightarray[i][j] += weight;
							}
							// 0110110
							if (array[i][j - 1] == 0 && array[i][j + 1] == 1
									&& array[i][j + 2] == 1
									&& array[i][j + 3] == 0
									&& array[i][j + 4] == 1
									&& array[i][j + 5] == 0) { // 活四连
								weight = map.get("0110110");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 2] == 0 && array[i][j - 2] == 1
									&& array[i][j + 1] == 0
									&& array[i][j + 2] == 1
									&& array[i][j + 3] == 1
									&& array[i][j + 4] == 0) { // 活四连
								weight = map.get("0110110");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 4] == 0 && array[i][j - 3] == 1
									&& array[i][j - 2] == 1
									&& array[i][j - 1] == 0
									&& array[i][j + 1] == 1
									&& array[i][j + 2] == 0) { // 活四连
								weight = map.get("0110110");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 5] == 0 && array[i][j - 4] == 1
									&& array[i][j - 3] == 1
									&& array[i][j - 2] == 0
									&& array[i][j - 1] == 1
									&& array[i][j + 1] == 0) { // 活四连
								weight = map.get("0110110");
								weightarray[i][j] += weight;
							}
							// 0101110
							if (array[i][j - 1] == 0 && array[i][j + 1] == 0
									&& array[i][j + 2] == 1
									&& array[i][j + 3] == 1
									&& array[i][j + 4] == 1
									&& array[i][j + 5] == 0) { // 活四连
								weight = map.get("0101110");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 3] == 0 && array[i][j - 2] == 1
									&& array[i][j - 1] == 0
									&& array[i][j + 1] == 1
									&& array[i][j + 2] == 1
									&& array[i][j + 3] == 0) { // 活四连
								weight = map.get("0101110");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 4] == 0 && array[i][j - 3] == 1
									&& array[i][j - 2] == 0
									&& array[i][j - 1] == 1
									&& array[i][j + 1] == 1
									&& array[i][j + 2] == 0) { // 活四连
								weight = map.get("0101110");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 5] == 0 && array[i][j - 4] == 1
									&& array[i][j - 3] == 0
									&& array[i][j - 2] == 1
									&& array[i][j - 1] == 1
									&& array[i][j + 1] == 0) { // 活四连
								weight = map.get("0101110");
								weightarray[i][j] += weight;
							}
							// 012
							if (array[i][j - 1] == 0 && array[i][j + 1] == 2) { // 死一连
								weight = map.get("012");
								weightarray[i][j] += weight;
							}
							// 210
							if (array[i][j - 1] == 2 && array[i][j + 1] == 0) { // 死一连
								weight = map.get("210");
								weightarray[i][j] += weight;
							}
							// 0112
							if (array[i][j - 1] == 0 && array[i][j + 1] == 1
									&& array[i][j + 2] == 2) { // 死二连
								weight = map.get("0112");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 2] == 0 && array[i][j - 1] == 1
									&& array[i][j + 1] == 2) { // 死二连
								weight = map.get("0112");
								weightarray[i][j] += weight;
							}
							// 2110
							if (array[i][j - 1] == 2 && array[i][j + 1] == 1
									&& array[i][j + 2] == 0) { // 死二连
								weight = map.get("2110");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 2] == 2 && array[i][j - 1] == 1
									&& array[i][j + 1] == 0) { // 死二连
								weight = map.get("2110");
								weightarray[i][j] += weight;
							}
							// 21110
							if (array[i][j - 1] == 2 && array[i][j + 1] == 1
									&& array[i][j + 2] == 1
									&& array[i][j + 3] == 0) { // 死三连
								weight = map.get("21110");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 2] == 2 && array[i][j - 1] == 1
									&& array[i][j + 1] == 1
									&& array[i][j + 2] == 0) { // 死三连
								weight = map.get("21110");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 3] == 2 && array[i][j - 2] == 1
									&& array[i][j - 1] == 1
									&& array[i][j + 1] == 0) { // 死三连
								weight = map.get("21110");
								weightarray[i][j] += weight;
							}
							// 01112
							if (array[i][j - 1] == 0 && array[i][j + 1] == 1
									&& array[i][j + 2] == 1
									&& array[i][j + 3] == 2) { // 死三连
								weight = map.get("01112");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 1] == 0 && array[i][j + 1] == 1
									&& array[i][j + 2] == 1
									&& array[i][j + 3] == 2) { // 死三连
								weight = map.get("01112");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 1] == 0 && array[i][j + 1] == 1
									&& array[i][j + 2] == 1
									&& array[i][j + 3] == 2) { // 死三连
								weight = map.get("01112");
								weightarray[i][j] += weight;
							}
							//
							if (array[i][j - 1] == 0 && array[i][j + 1] == 1
									&& array[i][j + 2] == 1
									&& array[i][j + 3] == 1
									&& array[i][j + 4] == 2) { // 死四连
								weight = map.get("011112");
								weightarray[i][j] += weight;
							}
							if (array[i][j - 1] == 2 && array[i][j + 1] == 1
									&& array[i][j + 2] == 1
									&& array[i][j + 3] == 1
									&& array[i][j + 4] == 0) { // 死四连
								weight = map.get("211110");
								weightarray[i][j] += weight;
							}
						}
					}
				}

				int max = -1; // m,n用于保存最大值处的行列
				for (int i = 0; i < weightarray.length; i++) { // 遍历数组找最大权值
					for (int j = 0; j < weightarray[i].length; j++) {
						
						if (weightarray[i][j] > max) {
							max = weightarray[i][j];
							m = i;
							n = j;
							System.out.println(m+"______"+n);
							System.out.println(max+"=max");
						}
						System.out.println(m+"         "+n);
					}
//					for (int p = m; p < m + 4; p++) {
//						if (array[m][p] == 0)
//							break;
//					}
				}
				// 在最大权值处下棋
				g.setColor(Color.black);
				g.fillOval(30 + m * 50, 30 + p * 50, 40, 40);
				System.out.println(m + "++" + p);
				array[m][n] = flag; // 储存旗子
				flag = 2;
				count++;
				setx[count] = m; // 将旗子坐标按顺序保存，用于悔棋
				sety[count] = n;
			}

			else if (flag == 2) { // 人下
				g.setColor(Color.WHITE);
				g.fillOval(30 + hx * 50, 30 + dy * 50, 40, 40);
				array[hx][dy] = flag;
				flag = 1;
				count++;
				setx[count] = hx; // 将旗子坐标按顺序保存，用于悔棋
				sety[count] = dy;
			}
		}

		// 横向
		if (winh(hx, dy) >= 5) {
			if (array[hx][dy] == 1) {
				JOptionPane.showConfirmDialog(null, "黑棋赢！");
			}
			if (array[hx][dy] == 2) {
				JOptionPane.showConfirmDialog(null, "白棋赢！");
			}

			// 纵向
			if (wind(hx, dy) >= 5) {
				if (array[hx][dy] == 1) {
					JOptionPane.showConfirmDialog(null, "黑棋赢！");
				}
				if (array[hx][dy] == 2) {
					JOptionPane.showConfirmDialog(null, "白棋赢！");
				}
			}
			// 斜向
			if (winyx(hx, dy) >= 5) {
				if (array[hx][dy] == 1) {
					JOptionPane.showConfirmDialog(null, "黑棋赢！");
				}
				if (array[hx][dy] == 2) {
					JOptionPane.showConfirmDialog(null, "白棋赢！");
				}
			}

			// 斜向
			if (winzx(hx, dy) >= 5) {
				if (array[hx][dy] == 1) {
					JOptionPane.showConfirmDialog(null, "黑棋赢！");
				}
				if (array[hx][dy] == 2) {
					JOptionPane.showConfirmDialog(null, "白棋赢！");
				}
			}
		}
	}

	// 横向判
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

	// 右斜判断
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

	// 左斜判断
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

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x1 = e.getX();
		y1 = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
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
			g.fillOval(280, 280, 40, 40);
			g.setColor(Color.black);
			flag = 2;

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
