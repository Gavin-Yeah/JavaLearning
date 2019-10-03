package IO.com.jiada.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据类型（基本+String) 处理流
 * 1.输入流DataInputStream
 * 2.输出流DataOutputStream
 * 新增方法不能使用多态
 * java.io.EOFException:没有读到相关的内容
 * @author jiadaye
 *
 */
public class DataDemo1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//read("/Users/jiadaye/workspace/c.text");//非法内容
	}
	
/**
 * 从文件读取数据+类型
 * @throws IOException 
 */
	public static void read(String destPath) throws IOException {
		//创建源
				File src= new File(destPath);
				DataInputStream dis = new DataInputStream(
						new BufferedInputStream(
								new FileInputStream(src)));
				//读取的顺序与写出一致 必须存在才能读取
				//顺序不一致，数据存在问题
				double num1=dis.readDouble();
				long num2= dis.readLong();
				String str=dis.readUTF();
					System.out.println(str);	
	}
/**
 * 数据+类型输出到文件
 * @throws IOException 
 */
	public static void write(String destPath) throws IOException {
		double point =2.5;
		long num=100L;
		String str="data structure";
	//创建源
		File dest= new File(destPath);
		//DataOutputStream
		DataOutputStream dos= new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)
						)
				);
		//操作写出的顺序 为读取准备
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		
		dos.flush();
		dos.close();
		
	}
}
