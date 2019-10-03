package NetStudy.com.jiada.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {

		System.out.println("-----server--------");
		//1.指定端口，使用serversocket创建服务器
		 ServerSocket server= new ServerSocket(7777);
		 // 2.阻塞式等待连接 accept
		 Socket client=server.accept();
		 System.out.println("一个客户端建立了连接");
		 //3.操作输入流输出流
		 DataInputStream dis= new DataInputStream(client.getInputStream());
			String data=dis.readUTF();
			System.out.println(data);
			
		 //4.释放资源
			dis.close();
			client.close();
			server.close();
	}
}
