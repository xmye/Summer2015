package ������;

import java.awt.Color;
import java.awt.Graphics;

public class Board {
private int[][] board = new int[15][15];	// �ö�ά�������15*15������
	
	/**
	 * ��������
	 * @param g ����
	 */
	public void draw(Graphics g) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] != 0) {	// ���ǿո�
					if(board[i][j] == 1) {	// ����
						g.setColor(Color.BLACK);
					}
					else {	// ����
						g.setColor(Color.WHITE);
					}
					g.fillOval(35 * (j + 1), 35 * (i + 1), 30, 30);
					if(board[i][j] == 2) {	// �����Ӽ��ϱ߿�
						g.setColor(Color.BLACK);
						g.drawOval(35 * (j + 1), 35 * (i + 1), 30, 30);
					}
				}
			}
		}
	}


/**
 * �������з�������
 * @param row �������ӵ���
 * @param col �������ӵ���
 * @param isBlack ���廹�ǰ���
 * @return ����true���ӳɹ�, ����false����ʧ��(�Ѿ�������)
 */
public boolean addPiece(int row, int col, boolean isBlack) {
	if(board[row][col] == 0) {	// û�����ӵĵط���������
		board[row][col] = isBlack? 1 : 2;	// 1�������2�������
		return true;
	}
	return false;
}
/**
 * �ж�ʤ��
 * @param row ���ӵ���
 * @param col ���ӵ���
 * @param isBlack �Ǻ��ӻ��ǰ���
 * @return ��ʤ����true���򷵻�false
 */
public boolean isWin(int row, int col, boolean isBlack) {
	return checkH(row, col, isBlack) || 
			checkV(row, col, isBlack) || 
			checkX1(row, col, isBlack) || 
			checkX2(row, col, isBlack);
}

// �жϴ����ϵ����µ�б�����Ƿ�����5������
private boolean checkX2(int row, int col, boolean isBlack) {
	int counter = 1;
	int currentRow = row;
	int currentCol = col;
	int v = isBlack? 1 : 2;
	while(currentRow > 0 && currentCol < 14 && 
			board[--currentRow][++currentCol] == v) {
		counter++;
	}
	currentRow = row;
	currentCol = col;
	while(currentRow < 14 && currentCol > 0 && 
			board[++currentRow][--currentCol] == v) {
		counter++;
	}
	return counter >= 5;
}

// �жϴ����ϵ����µ�б�����Ƿ�����5������
private boolean checkX1(int row, int col, boolean isBlack) {
	int counter = 1;
	int currentRow = row;
	int currentCol = col;
	int v = isBlack? 1 : 2;
	while(currentRow > 0 && currentCol > 0 && 
			board[--currentRow][--currentCol] == v) {
		counter++;
	}
	currentRow = row;
	currentCol = col;
	while(currentCol < 14 && currentRow < 14 && 
			board[++currentRow][++currentCol] == v) {
		counter++;
	}
	return counter >= 5;
}

// �ж����ŷ������Ƿ�����5������
private boolean checkV(int row, int col, boolean isBlack) {
	int counter = 1;
	int currentRow = row;
	int v = isBlack? 1 : 2;
	while(currentRow > 0 && board[--currentRow][col] == v) {
		counter++;
	}
	currentRow = row;
	while(currentRow < 14 && board[++currentRow][col] == v) {
		counter++;
	}
	return counter >= 5;
}

// �жϺ��ŷ������Ƿ�����5������
private boolean checkH(int row, int col, boolean isBlack) {
	int counter = 1;
	int currentCol = col;
	int v = isBlack? 1 : 2;
	while(currentCol > 0 && board[row][--currentCol] == v) {
		counter++;
	}
	currentCol = col;
	while(currentCol < 14 && board[row][++currentCol] == v) {
		counter++;
	}
	return counter >= 5;
}




}