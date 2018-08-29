package netWZQ0804;
/*
 * 简单服务器实现
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
	
	 public ServerThread(Socket client){					//传入要处理的客户机，构造函数
		 this.client=client;
	 }
	 
	 //将发送消息的代码封装到一个类中，发送给客户机
	 public void SendMsgToMe(int x,int y,int flag) {		 
			try {
				os.write(x);		//客户机的输出流对象
				os.write(y);
				os.write(flag);
				os.flush();								//强制写入
			  } catch (IOException e) {
				e.printStackTrace();
			}		 
	 }
	 
	 public void run(){
		 ProcessChat();     //调用处理连接的方法，线程处理完毕自己退出
	 }
	
	public void ProcessChat(){
		try {
			os=client.getOutputStream();	  		//从连接对象上得到输入输出流对象 
			InputStream is=client.getInputStream();
			x=is.read();								//读取坐标
			y=is.read();
			flag=is.read();
			SendMsgToMe(x,y,flag);		//发送坐标
		} catch (IOException e) {
			e.printStackTrace();
		}				 
		this.closeMe();									
	}
	
	public void closeMe(){							//关闭连接对象
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

