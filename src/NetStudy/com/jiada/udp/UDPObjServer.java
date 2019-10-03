package NetStudy.com.jiada.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**
 * 文件 接收端
 *  Address already in use (Bind failed) 统一协议下，端口不允许冲突
 * 1.使用dataGramSocket 指定端口 创建接收端
 * 2.准备容器 封装成DatagranPacket 包裹
 * 3.阻塞式接收包裹 receive（DatagramPocket p)
 * 4.分析数据
 * byte[] getData()
 * getLength()
 * 4.释放资源
 * @author jiadaye
 *
 */
public class UDPObjServer {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
	// TODO Auto-generated method stub
	System.out.println("接受方启动中");
		 // 1.使用dataGramSocket 指定端口 创建接收端
	DatagramSocket server=new DatagramSocket(1234);
		// * 2.准备容器 封装成DatagranPacket 包裹
	byte[] container = new byte[1024*60];
	DatagramPacket packet= new DatagramPacket(container,0,container.length);
	
		// * 3.阻塞式接收包裹 receive（DatagramPocket p)
	server.receive(packet);
		 //* 4.分析数据
		  byte[] datas= packet.getData();
		int len=packet.getLength();
		ObjectInputStream ois= new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		String msg= ois.readUTF();
		int age = ois.readInt();
		boolean flag= ois.readBoolean();
		char ch=ois.readChar();
		Object str=ois.readObject();
		Object date=ois.readObject();
		Object employee=ois.readObject();
		if(str instanceof String) {
			String strObj=(String)str;
		}
		if(date instanceof Date) {
			Date dObj=(Date)date;
		}
		if(employee instanceof Employee) {
			Employee emObj=(Employee)employee;
		}
		
		
		System.out.println(flag);
		System.out.println(msg);
		 //* 4.释放资源
		server.close();
	}

}
