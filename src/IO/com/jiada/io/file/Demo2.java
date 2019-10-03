package IO.com.jiada.io.file;

import java.io.File;

/**
 * 相对路径与绝对路径构造File
 * 1.相对路径
 * File(String parent, String child)  ---- File("E:/xp/test","r.jpg")
 * File(File parent, String chile) -------File(new File("E:/xp/test"), "r.jpg")
 * 2.绝对路径
 * File(String name)
 * @author jiadaye
 *
 */
public class Demo2 {
public static void main(String[] args) {
	String parentPath="E:/xp/test";
	String name="r.jpg";
	//相对路径
	File src = new File(parentPath,name);
	src=new File(new File(parentPath), name);
	
	//输出
	System.out.println(src.getName());
	System.out.println(src.getPath());
	
	//绝对路径
	src=new File("E:/xp/test/r.jpg");
	//输出
		System.out.println(src.getName());
		System.out.println(src.getPath());
	//没有盘符，以user.dir构造	
		src=new File("r.jpg");
		//输出
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
}
}
