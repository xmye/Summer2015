package study0506;

public class Manage {

	
	public static void main(String[] args) {
			Atm A=new Atm();
			A.setName("°ÂÌØÂü");
			A.setBlood(3000);
			A.setPower(10);
			
			Xgs X=new Xgs();
			X.setName("Ð¡¹ÖÊÞ");
			X.setBlood(2000);
			X.setPower(3);
			
			Boss B=new Boss();
			B.setBlood(2500);
			B.setName("boss");
			B.setPower(4);
			
			A.fight(A, X);
			A.fight(A, B);
			
	}

}
