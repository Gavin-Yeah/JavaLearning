package IO.com.jiada.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 3个常量
 * 1.System.in
 * 2.System.out
 * 3.System.err
 * 
 * 重定向
 * setIn()
 * setOut()
 * setErr()
 */
public class SystemDemo1 {
	public static void main(String[] args) throws FileNotFoundException {
	//	test();
	//重定向
		//autoflush=true
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("/Users/jiadaye/workspace/print.txt")),true));
		System.out.println("A");
		System.out.println("ddd");
		//回控制台
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("A");
	}
	
	public static void test2() throws FileNotFoundException {
		InputStream is=System.in; //键盘输入
		is= new BufferedInputStream(new FileInputStream("/Users/jiadaye/workspace/a.txt"));
		Scanner sc = new Scanner(is);
		
		System.out.println("请输入：");
		System.out.println(sc.nextLine());
	}
	
	
	public static void test() {
		System.out.println("test");
		System.err.println("error");
	}
}
