package study0506;

public class Boss extends Cara {
	public void fight(Boss B,Atm A){
		A.setBlood(A.getBlood()-B.getPower());
		System.out.println(B.getName()+"正在攻击"+A.getName()+" "+A.getName()+
										"掉血"+B.getPower()+" "+"现在的血量是"+A.getBlood());
			if(A.getBlood()<=0){
				System.out.println(B.getName()+" win!");
			}
			else
				A.fight(A, B);
	}
}
