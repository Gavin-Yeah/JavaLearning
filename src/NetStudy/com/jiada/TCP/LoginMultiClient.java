package NetStudy.com.jiada.TCP;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *模拟登陆 双向
 * 熟悉流程
 * 创建客户端
 * 1.建立连接：使用socket创建服务器+服务器的地址和端口
 * 2.操作：输入输出流
 * 
 * 3.释放资源
 * @author jiadaye
 *
 */
public class LoginMultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("-----client--------");
		
	
		//1.建立连接：使用socket创建服务器+服务器的地址和端口
		Socket client=new Socket("localhost",7777);
		
		// 2.操作：输入输出流
		
		new Send(client).send();
		new Receive(client).receive();
			
		 // 3.释放资源
	
		client.close();
	}
	static class Send{
		private BufferedReader console ;
		private Socket client;
		private DataOutputStream dos;
		private String msg;
		public Send(Socket client) {
			console=new BufferedReader(new InputStreamReader(System.in));
			this.msg=init();
			this.client=client;
			try {
				
				dos= new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		public void send() {
			try {
				dos.writeUTF(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		private String init() {
			
			try {
				System.out.println("please input user name");
				String uname=console.readLine();
				System.out.println("please input user password");
				String upwd=console.readLine();
				return "uname="+uname+"&"+"upwd="+upwd;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
			
		}
	}
	static class Receive{
		private DataInputStream dis;
		private Socket client;
		public Receive(Socket client) {
			this.client=client;
			try {
				dis= new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void receive() {
			String result;
			try {
				result = dis.readUTF();
				System.out.println(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
			
	}
}
