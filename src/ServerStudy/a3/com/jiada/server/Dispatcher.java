package ServerStudy.a3.com.jiada.server;

import java.io.IOException;
import java.net.Socket;

public class Dispatcher implements Runnable{
	private Socket client;
	private Request request;
	private Response response;
	 public Dispatcher(Socket client) {
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
			Servlet servlet=WebApp.getServletFromUrl(request.getUrl());
			
			if(null!=servlet) {
				servlet.service(request, response);
				//关注了状态码
				response.pushToBrowser(200);
			}else {
				//错误页面
				response.pushToBrowser(404);
			}
			
		}catch(Exception e) {
			try {
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
