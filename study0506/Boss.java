package study0506;

public class Boss extends Cara {
	public void fight(Boss B,Atm A){
		A.setBlood(A.getBlood()-B.getPower());
		System.out.println(B.getName()+"���ڹ���"+A.getName()+" "+A.getName()+
										"��Ѫ"+B.getPower()+" "+"���ڵ�Ѫ����"+A.getBlood());
			if(A.getBlood()<=0){
				System.out.println(B.getName()+" win!");
			}
			else
				A.fight(A, B);
	}
}
