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
		//����Ҷѩ÷1995���������1994
		String school1 = "����";
		String school2 = "����";
		String name1 = "Ҷѩ÷";
		String name2 = "������";
		long dete =20150719;
		int birth1 = 1995;
		int birth2 = 1994;
		//���ݵ����������
		
		try {
			java.io.OutputStream ous = new java.io.FileOutputStream(fileName);			//�ļ������
			java.io.DataOutputStream dous = new java.io.DataOutputStream(ous);		//���������
			
			byte[] b = school1.getBytes();		//ת��Ϊ�ֽ�
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
			
			dous.flush();			//ˢ��������
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
			//��ȡ��һ���˵�����
			byte [] name=new byte[10];
			dins.read(name);
			dous.write(name);
			//��ȡ��һ���˵ĳ������
			int i=dins.readInt();
			String str = i+"";			//��int��ת��ΪString��
			System.out.println(str);
			byte b[] = str.getBytes();		//��String װ���ֽ�������
			dous.write(b);							//���ֽ�����д��dest��������С�
			//��ȡ����
			long date = dins.readLong();
			str=date+"";			//��longת�����ַ���
			b=str.getBytes();		//�ַ���ת��Ϊ�ֽ�����
			dous.write(b);
			
			//��ȡ�ڶ����˵�����
			dins.read(name);
			dous.write(name);
			
			//��ȡ��һ���˵ĳ������
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
