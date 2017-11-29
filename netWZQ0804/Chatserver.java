package netWZQ0804;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 管理服务器的类，启动，关闭，得到运行状态
 * @author thinkpad
 *
 */
public class Chatserver extends Thread {
		private int port;
		private boolean runing=false;   //服务器是否运行
		private ServerSocket sc;		//服务器对象
		/**
		 * 创建服务器对象时传入端口号
		 * @param port
		 */
		public Chatserver(int port){
			this.port=port;
		}
		
		//在线程中启动服务服务器
		public void run(){
			setupServer();
		}
		//在指定的端口上启动服务器
		public  void setupServer(){
			try {
				sc=new ServerSocket(port);			//建立绑定在指定端口上的服务器对象
				runing=true;					//服务器创建成功，处于运行状态
				System.out.println("服务器创建成功："+port);
				while(runing){
					Socket client=sc.accept();	 								//让服务器进入阻塞状态，等待客服机连接
					//输出客户机的地址（终结点的地址）
					System.out.println("进入一个客户机"+client.getRemoteSocketAddress().toString());
					ServerThread ct=new ServerThread(client);                    //启动一个线程对象处理连接对象
					ct.start();			//线程对象处理请求
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/**
		 * 查询服务器是否在运行中
		 * @return
		 */
		public Boolean isruning(){
			return this.runing;
		}
		
		//关闭服务器
		public void stopChatserver(){
			this.runing=false;
			try {
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
//		public static void main(String[] args){
//			Chatserver cs=new Chatserver();
//			cs.setupServer(9099);
//		}
//}
