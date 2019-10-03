package NetStudy.com.jiada.chat4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;



/**
 * x在线聊天室：客户端
 * 实现一个客户可以正常收发信息
 * @author jiadaye
 *
 */
public class Client {
public static void main(String[] args) throws IOException {
	System.out.println("------Client----");
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("请输入用户名");
	String name= br.readLine();
	Socket client= new Socket("localhost",9999);

	//客户端发送消息
	new Thread(new Send(client,name)).start();
	 new Thread(new Receive(client)).start();
			
}

}
