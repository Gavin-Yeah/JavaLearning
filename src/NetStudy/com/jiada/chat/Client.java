package NetStudy.com.jiada.chat;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import org.xml.sax.InputSource;

/**
 * x在线聊天室：客户端
 * 实现一个客户可以正常收发信息
 * @author jiadaye
 *
 */
public class Client {
public static void main(String[] args) throws IOException {
	System.out.println("------Client----");
	Socket client= new Socket("localhost",9999);
	//客户端发送消息
	DataOutputStream dos= new DataOutputStream(client.getOutputStream());
	BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	String msg=console.readLine();
	dos.writeUTF(msg);
	dos.flush();
	DataInputStream dis=new DataInputStream(client.getInputStream());
	msg=dis.readUTF();
	System.out.println(msg);
	dos.close();
	dis.close();
	client.close();
			
}
}
