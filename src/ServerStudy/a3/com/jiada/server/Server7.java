package ServerStudy.a3.com.jiada.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * target: 整合配置文件
 * 
 * 
 * @author jiadaye
 *
 */
public class Server7 {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server7 server= new Server7();
		
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
			//获取响应协议
			Response response = new Response(client);
			Servlet servlet=WebApp.getServletFromUrl(request.getUrl());
			
			if(null!=servlet) {
				servlet.service(request, response);
				//关注了状态码
				response.pushToBrowser(200);
			}else {
				//错误页面
				response.pushToBrowser(404);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("client error");
		}
		
	}
	public void stop() {
		
	}
}
