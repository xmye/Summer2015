package com.study0501;

public class Fight3 {

	  private String name;
	  private int blood;
	  private int power;
	  
	  //����ֵ
	  public Fight3(String name,int blood,int power){
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
	 //���ʹ�����ֵ
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
	    
	    
	  public void fight3(Fight fi,Fight2 figh){
		  //boss�������
		  fi.setblood(fi.getblood()-power);
		  System.out.println(name+"���ڹ���"+fi.getname()+" "+
	                                                 fi.getname()+"Ѫ��������"+power+
	                                                 "����Ѫ����"+fi.getblood());
		  //boss��С����
		  figh.setblood(figh.getblood()-power);
		  System.out.println(name+"���ڹ���"+figh.getname()+" "+figh.getname()+"Ѫ��������"+power+
	                                                 "����Ѫ����"+figh.getblood());
		  if(fi.getblood()<=0&&figh.getblood()<=0){
			  System.out.println(getname()+" win!");
		  }
		  else{
			  fi.fighter1(figh, this);
			  
	  }
	
	  }


}
