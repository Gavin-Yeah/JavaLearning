package ServerStudy.a3.com.jiada.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * target: 封装请求信息中参数转成map
 * 
 * 
 * @author jiadaye
 *
 */
public class Server6 {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server6 server= new Server6();
		
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
			//获取请求协议
			Request request=new Request(client);
			
			Response response = new Response(client);
			Servlet servlet=null;
			if(request.getUrl().equals("login")) {
				servlet = new LoginServlet();
			}else if(request.getUrl().equals("reg")) {
				servlet = new RegisterServlet();
			}else {
				
			}
			
			servlet.service(request, response);
			//关注了状态码
			response.pushToBrowser(200);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("client error");
		}
		
	}
	public void stop() {
		
	}
}
