package study0527;

import java.util.Random;

public class Array {
   //��������
	public int[] arrayb(){
		int[] array=new int[10];
		Random r=new Random();                //�����
		for(int i=0;i<array.length;i++){
		array[i]=r.nextInt(20);                         //����0--19�������
	}
		return array;
	}
	//��ӡ����
	public void PrintArray(int[] array){
		for(int i=0;i<array.length;i++){
		  System.out.print(array[i]+"  ");
		}
		System.out.println();
	}
	//����Ԫ��
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
	//ɾ��
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
	
	//�޸�
	public void change(int[] array,int index,int value){
		array[index]=value;
	}
	//ð������
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
	
	
	//ѡ������
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
