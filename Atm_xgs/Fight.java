package com.study0501;

public class Fight {
	      private String name;   
	      private int blood;      //血量
	      private int power;   //攻击
	      
	      
	      public Fight(String name,int blood,int power){
	    	  this.name=name;
	    	  this.power=power;
	    	  this.blood=blood;
	      }
	  
	    //访问name
	  public String getname(){
		 return this.name;
	  }
	    //访问blood
	   public int getblood(){
		   return this.blood;
	   }
	   //访问攻击值
	    public int getpower(){
	    	return this.power;
	    }
	    //给blood ，power重新赋值
	    public void setblood(int bloodvalue){
	    	this.blood=bloodvalue;
	    }
	    public void setpower(int powervalue){
	    	this.power=powervalue;
	    }
	    
	  //奥特曼打小怪兽   boss
	   public void fighter1(Fight2 figh,Fight3 fighter3 )
	    { 				
		
	    	 figh.setblood(figh.getblood()-power);
	    	  System.out.println(name+"正在攻击"+figh.getname()+" "+
	                                           figh.getname()+"血量减少"+power+ "现在血量是"+figh.getblood());
	    	  
	        fighter3.setblood(fighter3.getblood()-power);
	        System.out.println(name+"正在攻击"+fighter3.getname()+" "+fighter3.getname()+"血量减少了"+power+
		                                                 "现在血量是"+fighter3.getblood());
	    	  if(figh.getblood()<=0&&fighter3.getblood()<=0)
	  		{
	  		    System.out.println(getname()+"win！");
	  		}
	    	  else {
	    		  figh.fighter2(this,fighter3);
	    	  }
	    		  
	      }
	      
}



