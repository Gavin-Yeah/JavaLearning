package NetStudy.com.jiada.TCP;

import java.io.DataOutputStream;
import java.io.IOException;
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
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("-----client--------");
		//1.建立连接：使用socket创建服务器+服务器的地址和端口
		Socket client=new Socket("localhost",7777);
		
		// 2.操作：输入输出流
		DataOutputStream dos= new DataOutputStream(client.getOutputStream());
		String data="hello";
		dos.writeUTF(data);
		dos.flush();
		
		 // 3.释放资源
		dos.close();
		client.close();
	}
}
