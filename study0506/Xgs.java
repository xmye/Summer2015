package study0506;

public class Xgs extends Cara{
	public void fight(Xgs X,Atm A){
		A.setBlood(A.getBlood()-X.getPower());
		System.out.println(X.getName()+"正在攻击"+A.getName()+" "+A.getName()+
										"掉血"+X.getPower()+" "+"现在的血量是"+A.getBlood());
			if(A.getBlood()<=0){
				System.out.println(X.getName()+" win!");
			}
			else
				A.fight(A, X);

	}
}
