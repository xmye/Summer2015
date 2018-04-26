package 抽奖0808;

import java.awt.TextField;
import java.util.Random;

public class threadNo extends Thread{
	private TextField tf;
	private int flag=1;
	//构造函数传递文本框
	public threadNo(TextField tf) {
		this.tf=tf;
	}

	Random rd=new Random(100);//随机数对象0-100之间
	
	public void run(){
		if(flag==1){
	    while(true){
	    	int i=rd.nextInt(100000);//将随机数对象赋给i
	    	tf.setText(i+"");//将int转为String
	    	try {
				sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	}
	else if(flag==2){
		
	}
	}
}
