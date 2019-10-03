package ServerStudy.a3.com.jiada.server;

public class LoginServlet implements Servlet {

	@Override
	public void service(Request request, Response response) {
		// TODO Auto-generated method stub
		response.print("<html>");
		response.print("<head>");
		response.print("<title>");
		response.print("第一个servlet");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.print("欢迎回来："+request.getParameterValue("uname"));
		response.print("</body>");
		response.print("</html>");
	}

}
