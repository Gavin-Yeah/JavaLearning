package NetStudy.com.jiada.chat5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class Response {
	private BufferedWriter bw;
	
	//正文
	private StringBuilder content;
	//协议头信息
	private StringBuilder headInfo;
	private int len;//正文长度
	
	
	private final String BLANK=" ";
	private final String CRLF="\r\n";
	private Response() {
		content= new StringBuilder();
		headInfo=new StringBuilder();
		len=0;
	}
	public Response(Socket client) {
		this();
		try {
			bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			headInfo=null;
			
		}
	}
	public Response(OutputStream os) {
		this();
		bw=new BufferedWriter(new OutputStreamWriter(os));
	}
	//动态添加内容
	public Response print(String info) {
		content.append(info);
		len+=info.getBytes().length;
		return this;
	}
	public Response println(String info) {
		content.append(info).append(CRLF);
		len+=(info+CRLF).getBytes().length;
		return this;
	}
	//推送响应头头信息
	public void pushToBrowser(int code) throws IOException {
		if(null==headInfo) {
			code=505;
		}
		createHeadInfo(code);
		bw.append(headInfo);
		bw.append(content);
		bw.flush();
	}
	private void createHeadInfo(int code) {
		//1.response line: HTTP/1.1 200 OK
		headInfo.append("GET /v4/groups/Bj4264l4HMs/countries HTTP/1.1").append(CRLF);
		headInfo.append("Host: api-ssl.bitly.com").append(CRLF);
		
		
		//2.HEADER (a blank line at the end)
		/*
		 * DATE:MON,31 Dec209903:23:34GMT
		 * SERVER:jiada Server/0.0.1;charset=GBK
		 * Content-type:text/html
		 * Content-length:3945553
		 */
		headInfo.append("Date:").append(new Date()).append(CRLF);
		headInfo.append("Server:").append("jiada Server/0.0.1;charset=GBK").append(CRLF);
		
		headInfo.append("Content-length:").append(len).append(CRLF);
		headInfo.append(CRLF);
	}
}
