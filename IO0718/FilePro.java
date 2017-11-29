package IO0718;


import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FilePro {
	public void write(File fileName){
		//中南叶雪梅1995湖大陈新宇1994
		String school1 = "中南";
		String school2 = "湖大";
		String name1 = "叶雪梅";
		String name2 = "陈新宇";
		long dete =20150719;
		int birth1 = 1995;
		int birth2 = 1994;
		//数据的输入输出流
		
		try {
			java.io.OutputStream ous = new java.io.FileOutputStream(fileName);			//文件输出流
			java.io.DataOutputStream dous = new java.io.DataOutputStream(ous);		//数据输出流
			
			byte[] b = school1.getBytes();		//转化为字节
			dous.write(b);
			b = name1.getBytes();
			dous.write(b);
			dous.writeInt(birth1);
			dous.writeLong(dete);
			
			b = school2.getBytes();
			dous.write(b);
			b = name2.getBytes();
			dous.write(b);
			dous.writeInt(birth2);
			
			dous.flush();			//刷新数据流
			dous.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void read(File res,File dest){
		
		try {
			InputStream ins= new FileInputStream(res);
			DataInputStream dins=new DataInputStream(ins);
			OutputStream ous=new FileOutputStream(dest);
			DataOutputStream dous = new DataOutputStream(ous);
			//读取第一个人的名字
			byte [] name=new byte[10];
			dins.read(name);
			dous.write(name);
			//读取第一个人的出生年份
			int i=dins.readInt();
			String str = i+"";			//将int型转化为String型
			System.out.println(str);
			byte b[] = str.getBytes();		//将String 装到字节数组中
			dous.write(b);							//将字节数组写到dest的输出流中。
			//读取日期
			long date = dins.readLong();
			str=date+"";			//将long转换成字符串
			b=str.getBytes();		//字符串转化为字节数组
			dous.write(b);
			
			//读取第二个人的名字
			dins.read(name);
			dous.write(name);
			
			//读取第一个人的出生年份
			i=dins.readInt();
			str = i+"";
			b = str.getBytes();
			dous.write(b);
			dous.flush();
			dins.close();
			dous.close();
		}  
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FilePro fp = new FilePro();
		File f = new File("FilePort");
		File f2 = new File("DestFilePort");
//		fp.write(f);
		fp.read(f, f2);
	}

}
