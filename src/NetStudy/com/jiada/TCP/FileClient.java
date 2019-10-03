package NetStudy.com.jiada.TCP;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 熟悉流程
 * 创建客户端
 * 1.建立连接：使用socket创建服务器+服务器的地址和端口
 * 2.操作：输入输出流
 * 
 * 3.释放资源
 * @author jiadaye
 *
 */
public class FileClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("-----client--------");
		//1.建立连接：使用socket创建服务器+服务器的地址和端口
		Socket client=new Socket("localhost",7777);
		
		// 2.操作：文件拷贝
		InputStream is= new BufferedInputStream(new FileInputStream("/Users/jiadaye/workspace/1.jpg"));
		OutputStream os= new BufferedOutputStream(client.getOutputStream());
		
		byte[]flush=new byte[1024];
		int len=-1;
		while(-1!=(len=is.read(flush))) {
			os.write(flush,0,len);
		}
		
		 // 3.释放资源
		os.flush();
		os.close();
		is.close();
		client.close();
	}
}
