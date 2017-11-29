package netWZQ0804;
/*
 * �򵥷�����ʵ��
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread{
	 Socket client;
	 OutputStream os;
	 private int x,y,flag;
	
	 public ServerThread(Socket client){					//����Ҫ����Ŀͻ��������캯��
		 this.client=client;
	 }
	 
	 //��������Ϣ�Ĵ����װ��һ�����У����͸��ͻ���
	 public void SendMsgToMe(int x,int y,int flag) {		 
			try {
				os.write(x);		//�ͻ��������������
				os.write(y);
				os.write(flag);
				os.flush();								//ǿ��д��
			  } catch (IOException e) {
				e.printStackTrace();
			}		 
	 }
	 
	 public void run(){
		 ProcessChat();     //���ô������ӵķ������̴߳�������Լ��˳�
	 }
	
	public void ProcessChat(){
		try {
			os=client.getOutputStream();	  		//�����Ӷ����ϵõ�������������� 
			InputStream is=client.getInputStream();
			x=is.read();								//��ȡ����
			y=is.read();
			flag=is.read();
			SendMsgToMe(x,y,flag);		//��������
		} catch (IOException e) {
			e.printStackTrace();
		}				 
		this.closeMe();									
	}
	
	public void closeMe(){							//�ر����Ӷ���
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

