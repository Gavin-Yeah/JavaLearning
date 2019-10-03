package IO.com.jiada.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 5.操作目录
 * mkdir()创建目录，必须确保父目录存在，如不存在，创建失败
 * mkdirs()//创建目录，如果父目录链不存在则一同创建
 * list() 文件|目录字符串形式
 * listFiles()  
 * static listRoots()根目录
 * @author jiadaye
 *
 */
public class Demo4 {
public static void main(String[] args) {
	String path="E:/test/parent/test";
	File src = new File(path);
	//src.mkdir();
	src.mkdirs();
	if(src.isDirectory()){
		String [] subNames = src.list(); //子目录，文件名
		for(String tmp:subNames) {
			System.out.println(tmp);
		}
		File [] subFiles=src.listFiles();
		for(File tmp:subFiles) {
			System.out.println(tmp.getAbsolutePath());
		}
		//命令设计模式 找java文件
		subFiles=src.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				//dir 为目录
				return new File(dir,name).isFile() && name.endsWith(".java");
			}
			
		});
		for(File tmp:subFiles) {
			System.out.println(tmp.getAbsolutePath());
		}
		
	}
}
}
