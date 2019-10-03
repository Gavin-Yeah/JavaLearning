package ServerStudy.a2.com.jiada.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * target: send back the response protocol
 * @author jiadaye
 *
 */
public class Server2 {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server2 server= new Server2();
		
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
			StringBuilder content= new StringBuilder();
			content.append("<html>");
			content.append("<head>");
			content.append("<title>");
			content.append("faf");
			content.append("</title>");
			content.append("</head>");
			content.append("<body>");
			content.append("finally back");
			content.append("</body>");
			content.append("</html>");
			int size=content.toString().getBytes().length;//the byte size
			StringBuilder responseInfo=new StringBuilder();
			String blank=" ";
			String CRLF="\r\n";
			
			
			//return 
			//1.response line: HTTP/1.1 200 OK
			responseInfo.append("HTTP/1.1").append(blank);
			responseInfo.append(200).append(blank);
			responseInfo.append("OK").append(CRLF);
			//2.HEADER (a blank line at the end)
			/*
			 * DATE:MON,31 Dec209903:23:34GMT
			 * SERVER:jiada Server/0.0.1;charset=GBK
			 * Content-type:text/html
			 * Content-length:3945553
			 */
			responseInfo.append("Date:").append(new Date()).append(CRLF);
			responseInfo.append("Server:").append("jiada Server/0.0.1;charset=GBK").append(CRLF);
			responseInfo.append("Content-type:text/html").append(CRLF);
			responseInfo.append("Content-length:").append(size).append(CRLF);
			responseInfo.append(CRLF);
			//3. body
			responseInfo.append(content.toString());
			
			//to the client
			BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(responseInfo.toString());
			bw.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("client error");
		}
		
	}
	public void stop() {
		
	}
}
