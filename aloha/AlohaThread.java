package Network.aloha;

import java.util.Random;

public class AlohaThread extends Thread{
	private SendPot sp;
    private Random r = new Random();
    private long temp;
    private jsp_1 j;
    private int[] a;
    public AlohaThread(SendPot sp,jsp_1 j,int[] a)
    {
    	this.sp = sp;
        this.j = j;
        this.a = a;
    }
    public void run()
    {
    	try 
    	{
    		Thread.sleep(sp.getStart());
    	} 
    	catch (InterruptedException e1) 
    	{
    		e1.printStackTrace();
    	}
        for (int i=0;i<100;i++) 
        {
        	a[j.getN()] = a[j.getN()]+1;
        	try 
        	{
        		Thread.sleep(1);
        		//��ͻ
        		while(a[j.getN()]>1) 
        		{
        			temp = r.nextInt(5)+1;
        			Thread.sleep(temp*20);
        			System.out.println(sp.getNum()+"��ͻ");
        		}
        		System.out.println("���ͳɹ�:��"+sp.getNum()+"�ŵ�"+i+"�����ݰ�~");
        		Thread.sleep(sp.getD());
        	} 
        	catch (Exception e) {}
        }
       }
}
