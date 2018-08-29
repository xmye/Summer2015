package netWZQ0804;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * ������������࣬�������رգ��õ�����״̬
 * @author thinkpad
 *
 */
public class Chatserver extends Thread {
		private int port;
		private boolean runing=false;   //�������Ƿ�����
		private ServerSocket sc;		//����������
		/**
		 * ��������������ʱ����˿ں�
		 * @param port
		 */
		public Chatserver(int port){
			this.port=port;
		}
		
		//���߳����������������
		public void run(){
			setupServer();
		}
		//��ָ���Ķ˿�������������
		public  void setupServer(){
			try {
				sc=new ServerSocket(port);			//��������ָ���˿��ϵķ���������
				runing=true;					//�����������ɹ�����������״̬
				System.out.println("�����������ɹ���"+port);
				while(runing){
					Socket client=sc.accept();	 								//�÷�������������״̬���ȴ��ͷ�������
					//����ͻ����ĵ�ַ���ս��ĵ�ַ��
					System.out.println("����һ���ͻ���"+client.getRemoteSocketAddress().toString());
					ServerThread ct=new ServerThread(client);                    //����һ���̶߳��������Ӷ���
					ct.start();			//�̶߳���������
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/**
		 * ��ѯ�������Ƿ���������
		 * @return
		 */
		public Boolean isruning(){
			return this.runing;
		}
		
		//�رշ�����
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
