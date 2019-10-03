package IO.com.jiada.io.others;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * PrintStream 打印流-->处理流
 * 
 * @author jiadaye
 *
 */
public class PrintStreamDemo1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("test");
		PrintStream ps = System.out;
		ps.println(false);
		
		//输出到文件
		File dest= new File("/Users/jiadaye/workspace/print.txt");
		ps=new PrintStream(new BufferedOutputStream(new FileOutputStream(dest)));
		ps.println("io is so easy");
		ps.close();
	}

}
