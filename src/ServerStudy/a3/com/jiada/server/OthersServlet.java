package ServerStudy.a3.com.jiada.server;

public class OthersServlet implements Servlet {

	@Override
	public void service(Request request, Response response) {
		// TODO Auto-generated method stub
		response.print("其他测试页面");
	}

}
