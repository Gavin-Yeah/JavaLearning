package IO.com.jiada.io.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String src = "/Users/jiadaye/workspace/1.jpg";
	String dest="/Users/jiadaye/workspace/100.jpg";
		try {
			copyFile(src, dest);
		}  catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件不存在");
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("拷贝文件失败|关闭流失败");
		}
		
	}
	/**
	 * 文件的拷贝
	 * @param 原文件路径
	 * @param 目标文件路径
	 * @throws FileNotFoundException,IOException
	 * @return
	 */
	public static void copyFile(String srcPath, String destPath) throws FileNotFoundException,IOException {
		// TODO Auto-generated method stub
		File src = new File(srcPath);
		File dest = new File(destPath);
		if (!src.isFile()) {

			throw new IOException("not a file");

		}
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);

		// 文件拷贝 循环 读取写出
		byte[] flush = new byte[1024];
		int len = 0;
		while (-1 != (len = is.read(flush))) {
			os.write(flush, 0, len);
		}
		os.flush();
		// 关闭流
		FileUtil.close(is, os);

	}

	/**
	 * 1.7 新特性 try-with-resource
	 * @param srcPath
	 * @param destPath
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	public static void copyFile2(String srcPath, String destPath) throws FileNotFoundException,IOException {
		// TODO Auto-generated method stub
		File src = new File(srcPath);
		File dest = new File(destPath);
		if (!src.isFile()) {

			throw new IOException("not a file");

		}
		try (InputStream is = new FileInputStream(src); OutputStream os = new FileOutputStream(dest);) {
			// 文件拷贝 循环 读取写出
			byte[] flush = new byte[1024];
			int len = 0;
			while (-1 != (len = is.read(flush))) {
				os.write(flush, 0, len);
			}
		os.flush();
		}
		//关闭流
	//	FileUtil.close(is,os);
		
	}
}
