package IO.com.jiada.io.file;

import java.io.File;
import java.util.Arrays;

/**
 * 输出子孙目录 文件的名称
 * 1.listFiles()
 * 2.递归
 * @author jiadaye
 *
 */
public class Demo5 {
	public static void main(String[] args) {
		String path ="E:/xp/test";
		File parent= new File(path);
		printName(parent);
		File [] roots= File.listRoots();
		System.out.println(Arrays.toString(roots));
		for(File tmp: roots) {
			//printName(tmp);
		}
		
	}
	public static void printName(File src) {
		if(null==src||src.exists()) {
			return ;
		}
		System.out.println(src.getAbsolutePath());
		if(src.isDirectory()) {
			for(File sub:src.listFiles()) {
				printName(sub);
			}
		}
	}
}
