package NetStudy.com.jiada.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 熟悉流程 多个客户端
 * 创建服务器
 * 1.指定端口，使用serversocket创建服务器
 * 2.阻塞式等待连接 accept
 * 3.操作输入流输出流
 * 4.释放资源
 * @author jiadaye
 *
 */
public class LoginMultiServer {
	public static void main(String[] args) throws IOException {

		System.out.println("-----server--------");
		//1.指定端口，使用serversocket创建服务器
		 ServerSocket server= new ServerSocket(7777);
		boolean isRunning=true;
		 while(isRunning) {// 2.阻塞式等待连接 accept
			 Socket client=server.accept();
			 System.out.println("一个客户端建立了连接");
			 new Thread(new Channel(client)).start();
		 }
			server.close();
	}
	static class Channel implements Runnable{
		private Socket client;
		//输入流
		private DataInputStream dis;
		//输出流
		private DataOutputStream dos;
		public Channel(Socket client) {
			this.client =client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos= new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				release();
			}
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			 //3.操作输入流输出流
			
				String uname="";
				String upwd="";
				String []dataArray=receive().split("&");
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
				
			if(uname.equals("qwe")&&upwd.equals("rty")) {
				send("success");
			}else {
			send("fail");
			}
				
			 //4.释放资源
			release();
		}
		//接收数据
		private String receive() {
			String datas="";
			try {
				datas = dis.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return datas;
		}
		//发送数据
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		private void release() {
			try {
				if(null!=dos)
				dos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				try {
					if(null!=dis)
					dis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(null!=client)
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
