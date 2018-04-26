package study0527;

import java.util.Random;

public class Array {
   //生成数组
	public int[] arrayb(){
		int[] array=new int[10];
		Random r=new Random();                //随机数
		for(int i=0;i<array.length;i++){
		array[i]=r.nextInt(20);                         //生成0--19的随机数
	}
		return array;
	}
	//打印数组
	public void PrintArray(int[] array){
		for(int i=0;i<array.length;i++){
		  System.out.print(array[i]+"  ");
		}
		System.out.println();
	}
	//增加元素
	public int[] Addarray(int[] array,int index,int value){
		int[] newarray=new int[array.length+1];
		for(int i=0;i<array.length;i++){
		if(i<index){
			newarray[i]=array[i];
		}else
			newarray[i+1]=array[i];
		}
		newarray[index]=value;
		return newarray;
	}
	//删除
	public int[] delete(int[] array,int index){
		int[] newarray=new int[array.length-1];
		for(int i=0;i<array.length;i++){
		if(i<index){
			newarray[i]=array[i];
		}
		if(i>index){
			newarray[i-1]=array[i];
		}
		}
		return newarray;
	}
	
	//修改
	public void change(int[] array,int index,int value){
		array[index]=value;
	}
	//冒泡排序
	public void Maopao(int[] array){
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length-i-1;j++){
				if(array[j]>array[j+1]){
					int tmp=array[j];
					array[j]=array[j+1];
					array[j+1]=tmp;
				}
			}
		}
	}
	
	
	//选择排序
	public void choice(int [] array) {
		for(int i=0;i<array.length;i++)
			for(int j=i+1;j<array.length;j++){
				if(array[i]>array[j]){
					int tmp=array[i];
					array[i]=array[j];
					array[j]=tmp;
				}
			}
	}
	public static void main(String[] args){
	   Array a=new Array();
	   int[] array=a.arrayb();
	   a.PrintArray(array);
	   System.out.println();
	   int[] newarray=a.Addarray(array, 3, 40);
	   a.PrintArray(newarray);
	   System.out.println();
	   int[] newarray1=a.delete(newarray, 3);
	   a.PrintArray(newarray1);
	   int[] newarray2=a.delete(newarray, 4);
	   a.PrintArray(newarray2);
	   System.out.println();
	   a.change(newarray1, 0, 50);
	   a.PrintArray(newarray1);
	   System.out.println();
	   a.Maopao(newarray1);
	   a.PrintArray(newarray1);
	   System.out.println();
	   a.choice(newarray1);
	   a.PrintArray(newarray1);
	   System.out.println();
	}
}
