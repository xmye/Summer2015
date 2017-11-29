package netWZQ0804;

import java.util.ArrayList;
import java.util.List;
import communication.UserInfo;

public class ChatTools {
	
	private static List<readMessage> list=new ArrayList<readMessage>();  //保存处理线程的对象队列
	/**
	 * 将一条消息发送给所有客户机
	 * @param sender
	 * @param msg
	 */
	public static void castMsg(UserInfo sender,String msg){						//将一条消息发送给其他客户机对象
		msg=sender.getname()+"："+msg;
		for(int i=0;i<list.size();i++){
		readMessage st=list.get(i);
	}
	}
}
