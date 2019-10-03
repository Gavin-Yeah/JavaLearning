package NetStudy.com.jiada.loc;
/**
 * 
 * 端口
 * 区分软件
 * 2个字节 0-95535 udp tcp
 * 同一个协议端口不能冲突
 * 定义端口越大越好
 * InetSocketAddress
 * 构造器
 * new InetSocketAddress(域名|地址,端口);
 * 方法
 * getAddress()
 * getPort()
 */
import java.net.InetSocketAddress;

public class PortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
InetSocketAddress soc1=new InetSocketAddress("127.0.0.1",8080);
InetSocketAddress soc2=new InetSocketAddress("localhost",9000);
System.out.println(soc1.getHostName());
System.out.println(soc1.getAddress());
System.out.println(soc2.getAddress());
System.out.println(soc1.getPort());

	}

}
