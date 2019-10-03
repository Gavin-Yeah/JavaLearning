package NetStudy.com.jiada.chat;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Chat {
	public static void main(String[] args) throws IOException {

		System.out.println("----------server--------");
		ServerSocket server=new ServerSocket(9999);
		Socket client =server.accept();
		System.out.println("一个客户端建立了链接");
		//接收消息
		DataInputStream dis= new DataInputStream(client.getInputStream());
		String datas=dis.readUTF();
		//4.返回消息
		DataOutputStream dos= new DataOutputStream(client.getOutputStream());
		dos.writeUTF(datas);
		dos.flush();
		dos.close();
		dis.close();
		client.close();
	}
}
