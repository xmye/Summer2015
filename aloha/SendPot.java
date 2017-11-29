package Network.aloha;

import java.util.Random;
import java.util.ArrayList;
import java.util.Random;

public class SendPot {
	private Random r = new Random(); 
    private int Num;
    //开始发送时间
    private long start;
    //时间间隔
    private long d;
    public SendPot(int Num)
    { 
    	this.Num = Num;
        start = r.nextInt(1000); 
        d = r.nextInt(30)+20; 
    }
    public int getNum() 
    {
    	return Num;
    }
    public long getStart() 
    { 
    	return (start/20+1)*20; 
    }
    public long getD() 
    {
    	return (d/20+1)*20;
    }
    public long getStartT() 
    { 
    	return start/20+1;
    }
    public long getDt() 
    {
    	return d/20+1;
    }
}

