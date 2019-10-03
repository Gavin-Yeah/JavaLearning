package NetStudy.com.jiada.chat3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
/**
 *使用线程 封装 发送端
 *发送消息
 *释放资源
 *重写run
 * @author jiadaye
 *
 */
public class Send implements Runnable {
	String name;
	private DataOutputStream dos;
	private Socket client;
	private BufferedReader console;
	private boolean isRunning;

	public Send(Socket client) {
		this.client = client;
		this.name=name;
		console = new BufferedReader(new InputStreamReader(System.in));
		try {
			dos = new DataOutputStream(client.getOutputStream());

			isRunning = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("send fail");
			release();
		}

	}

	private String getStringFromConsole() {
		try {
			return console.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";

	}

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

	private void release() {
		Utils.close(dos, client);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isRunning) {
			String msg = getStringFromConsole();
			if (!msg.equals("")) {
				send(msg);
			}
		}
	}

}
