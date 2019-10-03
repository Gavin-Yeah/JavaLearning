package IO.com.jiada.io.file;

import java.io.File;
import java.io.IOException;

/**
 * 常用方法：
 * 1.文件名
 * getName() 文件名，路径名
 * getPath() 路径名
 * getAbsoluteFile() 绝对路径所对应的File对象
 * getAbsolutePath() 绝对路径名
 * getParent() 父目录，相对路径的父目录，可能为null 如，删除本身后的结果
 * 2.判断信息
 * exists()
 * canWrite()
 * canRead()
 * isFile()
 * isDirectory()
 * isAbsolute() 消除平台差异，ie以盘符为开头，其他以/为开头
 * 
 * 3.长度
 * length()  字节数 ，文件夹无法读取
 * 
 * 4.创建 删除
 * createNewFile()不存在则创建新文件，存在返回false
 * delete()
 * static createTempFile(前缀3个字节长，后缀默认.temp)默认临时空间
 * static createTempFile(前缀3个字节长，后缀默认.temp，目录)
 * deleteOnExit() 常用于删除临时文件
 * @author jiadaye
 *
 */
public class Demo3 {
	public static void main(String[] args) {
	

		//File src = new File("E:/xp/test/r.jpg");

		File src = new File("r.jpg");

			System.out.println(src.getName()); //返回名称
			System.out.println(src.getPath());//如果绝对路径，返回绝对路径，否则返回相对路径
			System.out.println(src.getAbsolutePath());//返回相对路径
			System.out.println(src.getParent());//如果相对目录，返回null
	}
	//判断信息
	public static void test2() {
		String path ="2.txt";
		path="E:/xp/test/2.jpg";
		File src = new File(path);
		System.out.println("文件是否存在"+src.exists());
		//是否可读 可写
		System.out.println("文件是否可写"+src.canWrite());//可文件或文件夹
		if(src.isFile()) {
			System.out.println("文件");
		}else if(src.isDirectory()) {
			System.out.println("文件夹");
		} else {
			System.out.println("文件不存在");
		}
		System.out.println("是否为绝对路径"+src.isAbsolute());
	}
	public static void test3() throws IOException, InterruptedException {
		String path="E:/xp/test/2.jpg";
		File src= new File(path);
		if(!src.exists()){
		boolean flag=src.createNewFile();
		System.out.println(flag?"成功":"失败");
		}
	//删除文件
		boolean flag=src.delete();
		System.out.println(flag?"成功":"失败");
		
		File temp= File.createTempFile("tes", "temp", new File("E:/xp/ptest"));
		Thread.sleep(1000);
		temp.deleteOnExit();//退出立即删除
	}
	
}
