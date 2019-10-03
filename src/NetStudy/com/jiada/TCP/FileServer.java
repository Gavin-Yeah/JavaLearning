package NetStudy.com.jiada.TCP;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 熟悉流程
 * 创建服务器
 * 1.指定端口，使用serversocket创建服务器
 * 2.阻塞式等待连接 accept
 * 3.操作输入流输出流
 * 4.释放资源
 * @author jiadaye

 */
public class FileServer {
	public static void main(String[] args) throws IOException {

		System.out.println("-----server--------");
		//1.指定端口，使用serversocket创建服务器
		 ServerSocket server= new ServerSocket(7777);
		 // 2.阻塞式等待连接 accept
		 Socket client=server.accept();
		 System.out.println("一个客户端建立了连接");
		 //3.文件存储
		 InputStream is= new BufferedInputStream(client.getInputStream());
			OutputStream os= new BufferedOutputStream(new FileOutputStream("src/11.jpg"));
			byte[]flush=new byte[1024];
			int len=-1;
			while(-1!=(len=is.read(flush))) {
				os.write(flush,0,len);
			}
			
		 //4.释放资源
			os.flush();
			os.close();
			is.close();
			client.close();
			server.close();
	}
}
