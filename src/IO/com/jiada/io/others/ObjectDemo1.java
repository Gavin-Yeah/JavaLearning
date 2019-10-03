package IO.com.jiada.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
/**
 * 不是所有对象都可以序列化 java.io.NotSerializableException
 * 不是所有属性都需要序列化 transient
 * @author jiadaye
 *
 */
public class ObjectDemo1 {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			seri("/Users/jiadaye/workspace/b.txt");
			read("/Users/jiadaye/workspace/b.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//序列化
	public static void seri(String destPath) throws FileNotFoundException, IOException {
		Employee em=new Employee("ddd",233);
		int[] arr= {1,2,3};
		//创建源
		File dest= new File(destPath);
		//DataOutputStream
		ObjectOutputStream dos= new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)
						)
				);
		//操作写出的顺序 为读取准备
		dos.writeObject(em);
		dos.writeObject(arr);
		
		
		dos.flush();
		dos.close();
	}
	
	
	//反序列化
	public static void read(String destPath) throws FileNotFoundException, IOException, ClassNotFoundException {
		//创建源
				File src= new File(destPath);
				//DataOutputStream
				ObjectInputStream dis= new ObjectInputStream(
						new BufferedInputStream(
								new FileInputStream(src)
								)
						);
				
				Object obj=dis.readObject();
				if(obj instanceof Employee) {
					Employee em=(Employee)obj;
					System.out.println(em.getName());
					System.out.println(em.getSalary());
				}
				obj=dis.readObject();
				int[] arr =(int[])obj;
				System.out.println(Arrays.toString(arr));
				
			
				dis.close();
	}
	
}
