package NetStudy.com.jiada.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端：使用面向对象封装
 * @author jiadaye
 *
 */
public class TalkReceive implements Runnable {
	private DatagramSocket server ;
	private String from;
	public TalkReceive(int port, String from) {
		this.from=from;
		try {
			server=new DatagramSocket(port);
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
		byte[] container = new byte[1024*60];
		DatagramPacket packet= new DatagramPacket(container,0,container.length);
		
			// * 3.阻塞式接收包裹 receive（DatagramPocket p)
		try {
			server.receive(packet);
			 //* 4.分析数据
			  byte[] datas= packet.getData();
			
			int len=packet.getLength();
			String str=new String(datas,0,len);
		
			System.out.println("from "+from+" "+str);
			 if( str.equals("bye")) {
				 
				 break;
			 
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	
			//* 4.释放资源
				server.close();
			
}

}
