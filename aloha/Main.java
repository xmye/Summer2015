package Network.aloha;

public class Main {

	public static void main(String[] args) {
		int[] a=new int[10000];
		for (int i=0;i<100000;i++) 
		{
			time t = new time();
			t.setN(i);
			t.setCount(0);
		}
		for (int i = 0; i < a.length; i++) 
		{
            a[i] = 0;
        }
        SendPot sp1 = new SendPot(1);
        SendPot sp2 = new SendPot(2);
        SendPot sp3 = new SendPot(3);
        SendPot sp4 = new SendPot(4);
        SendPot sp5 = new SendPot(5);
        SendPot sp6 = new SendPot(6);
        jsp_1 j = new jsp_1();
        long start=System.currentTimeMillis();
        j.start();
        AlohaThread at1 = new AlohaThread(sp1,j,a);
        AlohaThread at2 = new AlohaThread(sp2,j,a);
        AlohaThread at3 = new AlohaThread(sp3,j,a);
        AlohaThread at4 = new AlohaThread(sp4,j,a);
        AlohaThread at5 = new AlohaThread(sp5,j,a);
        AlohaThread at6 = new AlohaThread(sp6,j,a);
        at1.start();
        at2.start();
        at3.start();
        at4.start();
        at5.start();
        at6.start();
        long end=System.currentTimeMillis();
        System.out.println("所有站点成功发送10000个数据包的总时间:"+(end-start));
    }
}
