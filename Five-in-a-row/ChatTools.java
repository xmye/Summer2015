package netWZQ0804;

import java.util.ArrayList;
import java.util.List;
import communication.UserInfo;

public class ChatTools {
	
	private static List<readMessage> list=new ArrayList<readMessage>();  //���洦���̵߳Ķ������
	/**
	 * ��һ����Ϣ���͸����пͻ���
	 * @param sender
	 * @param msg
	 */
	public static void castMsg(UserInfo sender,String msg){						//��һ����Ϣ���͸������ͻ�������
		msg=sender.getname()+"��"+msg;
		for(int i=0;i<list.size();i++){
		readMessage st=list.get(i);
	}
	}
}
