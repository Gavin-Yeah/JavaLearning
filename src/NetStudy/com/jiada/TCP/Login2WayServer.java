package NetStudy.com.jiada.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 熟悉流程 双向登陆
 * 创建服务器
 * 1.指定端口，使用serversocket创建服务器
 * 2.阻塞式等待连接 accept
 * 3.操作输入流输出流
 * 4.释放资源
 * @author jiadaye
 *
 */
public class Login2WayServer {
	public static void main(String[] args) throws IOException {

		System.out.println("-----server--------");
		//1.指定端口，使用serversocket创建服务器
		 ServerSocket server= new ServerSocket(7777);
		 // 2.阻塞式等待连接 accept
		 Socket client=server.accept();
		 System.out.println("一个客户端建立了连接");
		 //3.操作输入流输出流
		 DataInputStream dis= new DataInputStream(client.getInputStream());
			String datas=dis.readUTF();
			String uname="";
			String upwd="";
			String []dataArray=datas.split("&");
			for(String info:dataArray) {
				String[] userInfo=info.split("=");
			//	System.out.println(userInfo[0]+"-->"+userInfo[1]);
				if(userInfo[0].equals("uname")) {
					System.out.println("Your username:"+userInfo[1]);
					uname=userInfo[1];
				}
				else if(userInfo[0].equals("upwd")) {
					System.out.println("Your userpwd:"+userInfo[1]);
					upwd=userInfo[1];
				}
			}
			DataOutputStream dos= new DataOutputStream(client.getOutputStream());
		if(uname.equals("qwe")&&upwd.equals("rty")) {
			dos.writeUTF("success");
		}else {
			dos.writeUTF("fail");
		}
			
		 //4.释放资源
			dis.close();
			client.close();
			server.close();
	}
}
