package NetStudy.com.jiada.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 发送端
 * @author jiadaye
 *
 */
public class TalkSend implements Runnable {
	private DatagramSocket client;
	private BufferedReader reader;
	private String toIP;
	private int toPort;
	public TalkSend(int port, String toIP, int toPort) {
		this.toIP=toIP;
		this.toPort=toPort;
		try {
			client=new DatagramSocket(port);
			reader= new BufferedReader(new InputStreamReader(System.in));
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

@Override
public void run() {
	// TODO Auto-generated method stub
while(true) {
		
		String data;
		try {
			data=reader.readLine();
			byte[] datas=data.getBytes();
			// 封装成DatagranPacket 包裹， 需要指定目的地
			DatagramPacket packet = new DatagramPacket(datas, 0,datas.length,
											new InetSocketAddress(toIP,toPort));
			// 3.发送包裹 send（DatagramPocket p)
			client.send(packet);
			if(data.equals("bye")) {
			
				break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}
		// 4.释放资源
		client.close();

	}
}


