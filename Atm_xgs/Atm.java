package study0506;

public class Atm extends Cara{
public void fight(Atm A,Xgs X){
	X.setBlood(X.getBlood()-A.getPower());
	System.out.println(A.getName()+"���ڹ���"+X.getName()+" "+X.getName()+
									"��Ѫ"+A.getPower()+" "+"���ڵ�Ѫ����"+X.getBlood());
		if(X.getBlood()<=0){
			System.out.println(A.getName()+"win!");
		}
		else
			X.fight(X, A);
}
			
		public void fight(Atm A, Boss B){
			B.setBlood(B.getBlood()-A.getPower());
			System.out.println(A.getName()+"���ڹ���"+B.getName()+" "+B.getName()+
											"��Ѫ"+A.getPower()+" "+"���ڵ�Ѫ����"+B.getBlood());
				if(B.getBlood()<=0){
					System.out.println(A.getName()+"  win!");
				}
				else
					B.fight(B, A);
 }
}
