package netWZQ0804;


import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.JTextArea;
/**
 * �ͻ��˶����������͵���Ϣ��ʵ��Ⱥ�����ܣ�
 * @author thinkpad
 *
 */
public class readMessage extends Thread{
	private  int [] setxyf;
	private int x,y,flag;
	private Socket client;
	private InputStream is;
	private GameWZQ jf;
	private Graphics g;

	
	   //��ȡ�������
		public void setT(GameWZQ jf){
			this.jf=jf;
		}
		//���ڻ�ȡGameWZQ�Ļ���
		public void setG(Graphics g){
			this.g=g;
		}

	/**
	 * ��ȡ����
	 */
	public void run(){
		try {
			is=client.getInputStream();						//ȡ��������������������
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while(true){
			try {
				x=is.read();
				y=is.read();
				flag=is.read();
//				jf.repaint();
				if(flag==1){
				g.setColor(Color.BLACK);
				}else {
					g.setColor(Color.white);
				}
				g.fillOval(30+x*50,30+y*50 , 40, 40);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

