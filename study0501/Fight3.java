package com.study0501;

public class Fight3 {

	  private String name;
	  private int blood;
	  private int power;
	  
	  //赋初值
	  public Fight3(String name,int blood,int power){
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
	 //访问攻击者值
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
	    
	    
	  public void fight3(Fight fi,Fight2 figh){
		  //boss打奥特曼
		  fi.setblood(fi.getblood()-power);
		  System.out.println(name+"正在攻击"+fi.getname()+" "+
	                                                 fi.getname()+"血量减少了"+power+
	                                                 "现在血量是"+fi.getblood());
		  //boss打小怪兽
		  figh.setblood(figh.getblood()-power);
		  System.out.println(name+"正在攻击"+figh.getname()+" "+figh.getname()+"血量减少了"+power+
	                                                 "现在血量是"+figh.getblood());
		  if(fi.getblood()<=0&&figh.getblood()<=0){
			  System.out.println(getname()+" win!");
		  }
		  else{
			  fi.fighter1(figh, this);
			  
	  }
	
	  }


}
