package NetStudy.com.jiada.chat5;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 使用多线程 接收端
 * 
 * @author jiadaye
 *
 */
public class Receive implements Runnable {
	private DataInputStream dis;
	private Socket client;
	private boolean isRunning;

	public Receive(Socket client) {

		try {
			this.client = client;
			dis = new DataInputStream(client.getInputStream());
			isRunning = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			release();
			isRunning=false;
		}
	}

	// 接收消息
	private String receive() {
		String msg = "";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			System.out.println("receive failure");
			release();
			isRunning=false;
		}
		return msg;
	}

	// 释放资源
	private void release() {
		Utils.close(dis, client);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isRunning) {
			String msg = receive();
			if (!msg.equals("")) {
				System.out.println(msg);
			}
		}
	}

}
