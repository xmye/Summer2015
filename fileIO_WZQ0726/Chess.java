package fileIO_WZQ0726;

//实例化一个棋子类可以用来反序列化棋子  
import java.io.Serializable;  

public class Chess implements Serializable {  
private int i;  
private int j;  
private int Color;  
public Chess(int i ,int j,int Color){  
  this.i=i;  
  this.j=j;  
  this.Color=Color;  
}  
public int getI() {  
  return i;  
}  
public void setI(int i) {  
  this.i = i;  
}  
public int getJ() {  
  return j;  
}  
public void setJ(int j) {  
  this.j = j;  
}  
public int getColor() {  
  return Color;  
}  
public void setColor(int color) {  
  Color = color;  
}  
}  
