package NetStudy.com.jiada.TCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *模拟登陆 单向
 * 熟悉流程
 * 创建客户端
 * 1.建立连接：使用socket创建服务器+服务器的地址和端口
 * 2.操作：输入输出流
 * 
 * 3.释放资源
 * @author jiadaye
 *
 */
public class LoginClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("-----client--------");
		BufferedReader console =new BufferedReader(new InputStreamReader(System.in));
		System.out.println("please input user name");
		String uname=console.readLine();
		System.out.println("please input user password");
		String upwd=console.readLine();
		//1.建立连接：使用socket创建服务器+服务器的地址和端口
		Socket client=new Socket("localhost",7777);
		
		// 2.操作：输入输出流
		DataOutputStream dos= new DataOutputStream(client.getOutputStream());
		dos.writeUTF("uname="+uname+"&"+"upwd="+upwd);
		
		dos.flush();
		
		 // 3.释放资源
		dos.close();
		client.close();
	}
}
