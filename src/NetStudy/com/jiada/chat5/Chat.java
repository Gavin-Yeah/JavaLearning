package NetStudy.com.jiada.chat5;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * 实现多个客户端可以正常地收发消息
 * 
 * @author jiadaye
 *
 */
public class Chat {
	 private static CopyOnWriteArrayList<Channel> all= new CopyOnWriteArrayList<Channel>();
	public static void main(String[] args) throws IOException {
		
		System.out.println("----------server--------");
		ServerSocket server=new ServerSocket(9999);
		while(true) {
		Socket client =server.accept();
		System.out.println("一个客户端建立了链接");
		Channel c=new Channel(client);
		all.add(c);//管理所有的成员
		new Thread(c).start();
		
		}
		
	}
	static class Channel implements Runnable{
		private DataOutputStream dos;
		private DataInputStream dis;
		private Socket client;
		private boolean isRunning;
		private String name;
		public Channel( Socket client) {
			
			try {
				dos= new DataOutputStream(client.getOutputStream());
				dis=new DataInputStream(client.getInputStream());
				this.name=receive();
				isRunning=true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("stream failure");
				release();
				isRunning=false;
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
				isRunning=false;
			}
			return msg;
		}
		/**
		 * 私聊：约定数据格式： @xxx：msg
		 * @param msg
		 */
		//群发
		
		private void sendOthers(String msg) {
			boolean isPrivate=msg.startsWith("@");
			if(isPrivate) {
				int idx=msg.indexOf(":");
				//获取目标和数据
				
				String targetName=msg.substring(1,idx);
				msg=msg.substring(idx+1);
				for(Channel other:all) {
					if(other.name.equals(targetName)) {
						other.send(this.name+"悄悄对你说： "+msg);
						break;
					}
					
				}
				
				
			}else {
				for(Channel other:all) {
					if(other==this)continue;
					other.send(this.name+" says: "+msg);
				}
			}
			
			
			
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
					sendOthers(msg);
				}
			}
		}
	}
}

