package NetStudy.com.jiada.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 发送端
 *  1.使用dataGramSocket 指定端口 创建发送端
 * 2.准备数据 一定转成字节数据
 * 封装成DatagranPacket 包裹， 需要指定目的地
 * 3.发送包裹 send（DatagramPocket p)
 * 4.释放资源
 * @author jiadaye
 *
 */
public class UDPClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("发送方启动中");
		 //1.使用dataGramSocket 指定端口 创建发送端
		DatagramSocket client=new DatagramSocket(8888);
		 //* 2.准备数据 一定转成字节数据
		String data="wenzhoukean";
		byte[] datas=data.getBytes();
		// 封装成DatagranPacket 包裹， 需要指定目的地
		DatagramPacket packet = new DatagramPacket(datas, 0,datas.length,
										new InetSocketAddress("localhost",1234));
		// 3.发送包裹 send（DatagramPocket p)
		client.send(packet);
		// 4.释放资源
		client.close();

	}

}
