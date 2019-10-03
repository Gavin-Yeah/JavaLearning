package IO.com.jiada.io.file;

import java.io.File;

/**
 * 两个常量
 * 1.路径分割符 :
 * 2.文件分割符 \(windows) /(linux)
 * @author jiadaye
 *
 */
public class Demo1 {
public static void main(String[] args) {
	System.out.println(File.pathSeparator);
	System.out.println(File.separator);
	//路径表示形式
	String path="E:\\xp\\test\\x.jpg";
	path="E:"+File.separator+"xp"+File.separator+"test"+File.separator+"x.jpg";
	//推荐方式
	path="E:/xp/test/x.jpg";
}
}
