package ServerStudy.a3.com.jiada.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * target: 处理404 505 和 首页
 * 
 * 
 * @author jiadaye
 *
 */
public class Server9 {
	private ServerSocket serverSocket;
	private boolean isRunning=true;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server9 server= new Server9();
		
		server.start();
	}
	
	public void start() {
		try {
			serverSocket=new ServerSocket(9999);
			isRunning=true;
			receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("server setups failure");
			stop();
		}
	}
	public void receive() {
		while(isRunning) {
		try {
		
			Socket client=serverSocket.accept();
			System.out.println("one client establishs a connection");
			//多线程处理
			new Thread(new Dispatcher2(client)).start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("client error");
			
		}
		}
	}
	public void stop() {
		isRunning=false;
		try {
			this.serverSocket.close();
			System.out.println("服务器已停止");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
