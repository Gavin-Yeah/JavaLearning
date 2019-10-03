package IO.com.jiada.io.buffered;
/**
 * 字节流文件拷贝+缓冲流，提高性能
 * 缓冲流（节点流）
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedByteDemo {

	public static void main(String[] args) {
		
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
		if(!src.isFile()) {
			
			throw new IOException("not a file");
		
		}
		
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		OutputStream os = new BufferedOutputStream( new FileOutputStream(dest));
		
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
