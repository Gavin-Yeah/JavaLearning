package NetStudy.com.jiada.chat3;


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
		new Thread(new Channel(client)).start();
		
		}
		
	}
	static class Channel implements Runnable{
		private DataOutputStream dos;
		private DataInputStream dis;
		private Socket client;
		private boolean isRunning;
		
		public Channel( Socket client) {
			super();
			try {
				dos= new DataOutputStream(client.getOutputStream());
				dis=new DataInputStream(client.getInputStream());
				isRunning=true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("stream failure");
				release();
			}
			this.client = client;
		}
		//接收消息
		private String receive() {
			String msg="";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				System.out.println("receive failure");
				release();
			}
			return msg;
		}
		//发送消息
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("send failure");
				release();
			}
		}
		//释放资源
		private void release() {
			Utils.close(dis,dos,client);
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isRunning) {
				String msg=receive();
				if(!msg.equals("")) {
					send(msg);
				}
			}
		}
	}
}

