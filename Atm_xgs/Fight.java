package com.study0501;

public class Fight {
	      private String name;   
	      private int blood;      //Ѫ��
	      private int power;   //����
	      
	      
	      public Fight(String name,int blood,int power){
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
	    
	  //��������С����   boss
	   public void fighter1(Fight2 figh,Fight3 fighter3 )
	    { 				
		
	    	 figh.setblood(figh.getblood()-power);
	    	  System.out.println(name+"���ڹ���"+figh.getname()+" "+
	                                           figh.getname()+"Ѫ������"+power+ "����Ѫ����"+figh.getblood());
	    	  
	        fighter3.setblood(fighter3.getblood()-power);
	        System.out.println(name+"���ڹ���"+fighter3.getname()+" "+fighter3.getname()+"Ѫ��������"+power+
		                                                 "����Ѫ����"+fighter3.getblood());
	    	  if(figh.getblood()<=0&&fighter3.getblood()<=0)
	  		{
	  		    System.out.println(getname()+"win��");
	  		}
	    	  else {
	    		  figh.fighter2(this,fighter3);
	    	  }
	    		  
	      }
	      
}



