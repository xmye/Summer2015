package �齱0808;

import java.awt.TextField;
import java.util.Random;

public class threadNo extends Thread{
	private TextField tf;
	private int flag=1;
	//���캯�������ı���
	public threadNo(TextField tf) {
		this.tf=tf;
	}

	Random rd=new Random(100);//���������0-100֮��
	
	public void run(){
		if(flag==1){
	    while(true){
	    	int i=rd.nextInt(100000);//����������󸳸�i
	    	tf.setText(i+"");//��intתΪString
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
