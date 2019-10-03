package NetStudy.com.jiada.chat2;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 实现多个客户端可以正常地收发消息
 * 问题：其他客户必须等待之前的客户退出
 * @author jiadaye
 *
 */
public class MultiChat {
	public static void main(String[] args) throws IOException {

		System.out.println("----------server--------");
		ServerSocket server=new ServerSocket(9999);
		while(true) {
		Socket client =server.accept();
		System.out.println("一个客户端建立了链接");
		DataOutputStream dos= new DataOutputStream(client.getOutputStream());
		//接收消息
		DataInputStream dis= new DataInputStream(client.getInputStream());
		boolean isRunning= true;
		while(isRunning) {
		String datas=dis.readUTF();
		//4.返回消息
		
		dos.writeUTF(datas);
		dos.flush();
		}
		dos.close();
		dis.close();
		client.close();
		}
		
	}
}
