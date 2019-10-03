package IO.com.jiada.io.byteIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {

	/**
	 * 文件的拷贝
	 * @param 原文件路径
	 * @param 目标文件路径
	 * @throws FileNotFoundException,IOException
	 * @return
	 */
	public static void copyFile(String srcPath, String destPath) throws FileNotFoundException,IOException {

		copyFile(new File(srcPath), new File(destPath));
		
	}
	/**
	 * 文件的拷贝
	 * @param 原文件file
	 * @param 目标文件file
	 * @throws FileNotFoundException,IOException
	 * @return
	 */
	public static void copyFile(File src, File dest) throws FileNotFoundException,IOException {
		
		if(!src.isFile()) {
			System.out.println("只能拷贝文件");
			throw new IOException("not a file");
		
		}
		//dest为已经存在的文件夹，不能建立与文件夹同名的文件
		if(dest.isDirectory()) {
			System.out.println("不能建立与文件夹同名的文件");
			throw new IOException("不能建立与文件夹同名的文件");
		}
		InputStream is =  new BufferedInputStream(new FileInputStream(src));
		OutputStream os =  new BufferedOutputStream(new FileOutputStream(dest));
		
		//文件拷贝 循环 读取写出
		byte[] flush = new byte[1024];
		int len=0;
		while(-1!=(len=is.read(flush))) {
			os.write(flush, 0, len);
		}
		os.flush();
		os.close();
		is.close();
		
	}
}
