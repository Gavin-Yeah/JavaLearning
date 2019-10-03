package ServerStudy.a3.com.jiada.server;
/**
 * 加状态内容处理
 */
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Dispatcher2 implements Runnable{
	private Socket client;
	private Request request;
	private Response response;
	 public Dispatcher2(Socket client) {
		// TODO Auto-generated constructor stub
		this.client=client;
		
			 try {
				//获取请求协议
				request=new Request(client);
				//获取响应协议
				response = new Response(client);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.release();
			}
	
	}
	@Override
	public void run() {
		
		try{	
			if(null==request.getUrl()||request.getUrl().equals("")) {
				InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("index.html");
				byte[]input=new byte[1024*1024];
				int a=is.read(input);
				response.print(new String(input,0,a) );
				response.pushToBrowser(200);
				
				is.close();
				return;
				
			}
			
			Servlet servlet=WebApp.getServletFromUrl(request.getUrl());
			
			if(null!=servlet) {
				servlet.service(request, response);
				//关注了状态码
				response.pushToBrowser(200);
			}else {
				//错误页面
				InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("error.html");
				byte[]input=new byte[1024*1024];
				int a=is.read(input);
				response.print(new String(input,0,a) );
				response.pushToBrowser(404);
				is.close();
			}
			
		}catch(Exception e) {
			try {
				response.println("你好我不好，我会马上好");
				response.pushToBrowser(500);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		release();
		
		
	}
	//释放资源
	private void release() {
		try {
			client.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
