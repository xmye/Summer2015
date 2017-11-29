package IO0718;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IO {
	public static void main(String[] args) throws IOException{
		IO ios=new IO();
//		ios.readbyte();
//		ios.raedString(new File("E:\\java_code\\build\\bin\\build\\example"));
		//ios.writeString("asdfgyt", new File("E:\\java_code\\build\\src\\build\\example1.txt"));
//		ios.copyfile();
//		ios.code(new File("E:\\java_code\\build\\bin\\build\\example"),
//				new File("E:\\workplace\\build\\src\\build\\example2.txt"));
		ios.breakcode(new File("E:\\workplace\\build\\src\\build\\example2.txt"), 
				      new File("E:\\workplace\\build\\src\\build\\breakcode.txt"));
	}
	
	
	//从文件中读取字节数据
	public void readbyte() throws IOException{
		try {
			InputStream is = new FileInputStream(new File("E:\\workplace\\build\\bin\\build\\example"));
			int b=is.read();
			while(b!=-1){
				System.out.println(b);
				b=is.read();
			} 
			is.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();		
			}		
	}

	
	
	public String raedString(File file) throws IOException{
		try {
			InputStream in=new FileInputStream(file);
			byte[] b=new byte[100];
			in.read(b);                      
			String s=new String(b);			//将字节数组转化成字符串
			System.out.println(s);
			in.close();    
			return s;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	//将指定字符串写到指定文件中
	public void writeString(String s,File file){
		try {
			OutputStream out=new FileOutputStream(file);
			byte[] b=s.getBytes();
			out.write(b);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void copyfile() throws IOException{
		String sh=this.raedString(new File("E:\\workplace\\build\\bin\\build\\example"));
		this.writeString(sh, new File("E:\\workplace\\build\\src\\build\\example1.txt"));
	}
	//给文件加密
	public void code(File file,File codefile) throws IOException{
		try {
			InputStream io=new FileInputStream(file);
			OutputStream ou=new FileOutputStream(codefile);
			int b=io.read();			//从输入流中读int数据
			int size=0;
			byte[] write=new  byte[100];
			while(b!=-1){
				write[size]=(byte)b;
				size++;
				b+=2;
				ou.write((byte)b); 		//向输出流写字节数据
				b=io.read();					//继续读数据
				ou.flush();
			}
			ou.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	//解密文件，加密的逆向过程
	public void breakcode(File codefile,File file) throws IOException{
		try {
			InputStream inp=new FileInputStream(codefile);
			OutputStream out=new FileOutputStream(file);
			int size=0;
			byte[] write=new byte[100];
			int b=inp.read();
			while(b!=0){
				write[size]=(byte)b;
				size++;
				b-=2;
				out.write((byte)b);
				b=inp.read();
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

