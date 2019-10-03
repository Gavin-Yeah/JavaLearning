package NetStudy.com.jiada.chat3;

import java.io.IOException;
import java.net.Socket;



/**
 * x在线聊天室：客户端
 * 实现一个客户可以正常收发信息
 * @author jiadaye
 *
 */
public class TMultiClient {
public static void main(String[] args) throws IOException {
	System.out.println("------Client----");
	Socket client= new Socket("localhost",9999);
	//客户端发送消息
	new Thread(new Send(client)).start();
	 new Thread(new Receive(client)).start();
			
}

}
