package NetStudy.com.jiada.loc;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPTest {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		addr=InetAddress.getByName("www.163.com");
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		
	}

}
