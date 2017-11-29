package netWZQ0804;


import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.JTextArea;
/**
 * 客户端读服务器发送的消息（实现群发功能）
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

	
	   //获取窗体对象
		public void setT(GameWZQ jf){
			this.jf=jf;
		}
		//用于获取GameWZQ的画笔
		public void setG(Graphics g){
			this.g=g;
		}

	/**
	 * 读取坐标
	 */
	public void run(){
		try {
			is=client.getInputStream();						//取得连结对象的输入流对象
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

