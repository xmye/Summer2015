package Network.aloha;

public class jsp_1 extends Thread{
	private int N;
    public void run()
    {
    	while(true){
    		try {
    			N = N+1;
    			Thread.sleep(20);
    			} 
    		catch (InterruptedException e) { 
    			e.printStackTrace();
    			}
    	}
    }
    public int getN()
    {
    	return N;
    }
}