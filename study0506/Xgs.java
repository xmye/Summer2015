package study0506;

public class Xgs extends Cara{
	public void fight(Xgs X,Atm A){
		A.setBlood(A.getBlood()-X.getPower());
		System.out.println(X.getName()+"���ڹ���"+A.getName()+" "+A.getName()+
										"��Ѫ"+X.getPower()+" "+"���ڵ�Ѫ����"+A.getBlood());
			if(A.getBlood()<=0){
				System.out.println(X.getName()+" win!");
			}
			else
				A.fight(A, X);

	}
}
