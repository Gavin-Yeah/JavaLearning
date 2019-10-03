package ServerStudy.a2.com.jiada.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * target: user ServerSocket to build the connection to the browser, and get request protocol 
 * @author jiadaye
 *
 */
public class Server01 {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server01 server= new Server01();
		
		server.start();
	}
	
	public void start() {
		try {
			serverSocket=new ServerSocket(9999);
			receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("server setups failure");
		}
	}
	public void receive() {
		try {
			Socket client=serverSocket.accept();
			System.out.println("one client establishs a connection");
			InputStream is= client.getInputStream();
			byte[] datas=new byte[1024*1024];
			int len= is.read(datas);
			String requestInfo=new String(datas,0,len);
			System.out.println(requestInfo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("client error");
		}
		
	}
	public void stop() {
		
	}
}
