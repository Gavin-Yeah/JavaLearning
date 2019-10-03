package NetStudy.com.jiada.chat2;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 实现多个客户端可以正常地收发消息
 * 问题：代码不好维护
 * 客户端读写没有分开，必须先写后读
 * 
 * @author jiadaye
 *
 */
public class TMultiChat {
	public static void main(String[] args) throws IOException {

		System.out.println("----------server--------");
		ServerSocket server=new ServerSocket(9999);
		while(true) {
		Socket client =server.accept();
		System.out.println("一个客户端建立了链接");
		new Thread(()-> {
			DataOutputStream dos=null;
			DataInputStream dis=null;
			try {
				dos = new DataOutputStream(client.getOutputStream());
				dis= new DataInputStream(client.getInputStream());
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		
			
				boolean isRunning= true;
				while(isRunning) {
					//接收消息
				String datas;
				try {
				datas = dis.readUTF();
				System.out.println(datas);
				//4.返回消息
				dos.writeUTF(datas);
				dos.flush();
				}catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					isRunning=false;
				}
				
			} 
			
				try {
					if(null!=dos)
					dos.close();
					if(null!=dis)
						dis.close();
						if(null!=client)
						client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			
			
		}).start();
		
		}
		
	}
}
