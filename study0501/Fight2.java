package com.study0501;

public class Fight2 {

	private String name;
	private int blood;      //Ѫ��
    private int power;   //����
    
    public Fight2(String name,int blood,int power){
  	  this.name=name;
  	  this.power=power;
  	  this.blood=blood;
    }
   //����name  
    public String getname(){
    	return this.name;
    }
      
    //����blood
    public int getblood(){
    	return this.blood;
    }
    //���ʹ���ֵ
    public int getpower(){
    	return this.power;
    }
    
    //��blood ��power���¸�ֵ
    public void setblood(int bloodvalue){
    	this.blood=bloodvalue;
    }
    public void setpower(int powervalue){
    	this.power=powervalue;
    }
    
      //С���޴������   С���޴�boss
      public void fighter2(Fight fi,Fight3 fighter3){
    	 int bloodx=fi.getblood();
    	 bloodx=bloodx-power;
    	 fi.setblood(bloodx);
    	  System.out.println(name+"���ڹ���"+fi.getname()+" "+
                                           fi.getname()+"Ѫ������"+power+ "����Ѫ����"+fi.getblood());
    	  
        fighter3.setblood(fighter3.getblood()-power);
        System.out.println(name+"���ڹ���"+fighter3.getname()+" "+fighter3.getname()+"Ѫ��������"+power+
	                                                 "����Ѫ����"+fighter3.getblood());
    	  if(fi.getblood()<=0&&fighter3.getblood()<=0)
  		{
  		    System.out.println(getname()+"win��");
  		}
    	  else {
    		  fighter3.fight3(fi,this);
    	  }
    		  
      }
	

}


