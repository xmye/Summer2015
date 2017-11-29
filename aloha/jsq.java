package Network.aloha;

public class jsq extends Thread{
	private long t;
    public void run()
    {
    	while(true){
    		try {
    			t = t+1;
    			Thread.sleep(1);
    			} catch (InterruptedException e) { 
    				e.printStackTrace();
    				}
    	}
    }
    public long getT()
    {
    	return t;
    }
}


	