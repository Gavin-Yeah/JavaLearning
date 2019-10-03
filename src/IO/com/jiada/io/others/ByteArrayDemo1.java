package IO.com.jiada.io.others;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节数组 节点流
 * 数组的长度有限，数组量不会很大
 * 
 * 文件内容不会太大
 * 1。文件内容-》程序-》字节数组
 * 2.字节数组-》程序-》文件
 * @author jiadaye
 *
 */
public class ByteArrayDemo1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		read(write());
	}
	/**
	 * 输入流操作与文件输入流一致
	 * 读取字节数组
	 */
	public static void read(byte[] src) throws IOException {
		//数据流
	//	String msg="输入流操作与文件输入流一致";
	//	byte[] src = msg.getBytes();
		
		//选择流
		InputStream is = new BufferedInputStream(
				new ByteArrayInputStream(src));
		//操作
		byte[] flush= new byte[1024];
		int len=0;
		while(-1!=(len=is.read(flush))) {
			System.out.println(new String(flush,0,len));
			
		}
		//释放资源
		is.close();
	}
	/**
	 * 输出流 操作 与 文件输出流有些不同，有新增方法
	 * @throws IOException 
	 */
	public static byte[] write() throws IOException {
		//目的地
		byte[] dest;
		//选择流
		ByteArrayOutputStream bos =new ByteArrayOutputStream();
		//写出
		String msg="输入流操作与文件输入流一致";
		byte[] info = msg.getBytes();
		bos.write(info, 0, info.length);
		//获取数据
		dest = bos.toByteArray();
		bos.close();
		return dest;
	}
}
