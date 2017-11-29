package study0506;

public class Atm extends Cara{
public void fight(Atm A,Xgs X){
	X.setBlood(X.getBlood()-A.getPower());
	System.out.println(A.getName()+"正在攻击"+X.getName()+" "+X.getName()+
									"掉血"+A.getPower()+" "+"现在的血量是"+X.getBlood());
		if(X.getBlood()<=0){
			System.out.println(A.getName()+"win!");
		}
		else
			X.fight(X, A);
}
			
		public void fight(Atm A, Boss B){
			B.setBlood(B.getBlood()-A.getPower());
			System.out.println(A.getName()+"正在攻击"+B.getName()+" "+B.getName()+
											"掉血"+A.getPower()+" "+"现在的血量是"+B.getBlood());
				if(B.getBlood()<=0){
					System.out.println(A.getName()+"  win!");
				}
				else
					B.fight(B, A);
 }
}
