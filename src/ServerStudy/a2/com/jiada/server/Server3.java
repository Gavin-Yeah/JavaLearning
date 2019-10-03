package ServerStudy.a2.com.jiada.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * target: encapsulate the response info
 * 1.dynamically add content
 * 3.focus on the status code, joint the protocol info of response
 * 
 * 
 * @author jiadaye
 *
 */
public class Server3 {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server3 server= new Server3();
		
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
			
			Response response = new Response(client);
			
			
			//关注了内容
			response.print("<html>");
			response.print("<head>");
			response.print("<title>");
			response.print("faf");
			response.print("</title>");
			response.print("</head>");
			response.print("<body>");
			response.print("finally back");
			response.print("</body>");
			response.print("</html>");
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
