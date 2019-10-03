package ServerStudy.a4.com.jiada.user;

import com.jiada.server.core.Request;
import com.jiada.server.core.Response;

public class RegisterServlet implements Servlet {

	@Override
	public void service(Request request, Response response) {
		// TODO Auto-generated method stub
		String uname=request.getParameterValue("uname");
		String[]favs=request.getParameterValues("fav");
		
		
		
		response.print("<html>");
		response.print("<head>");
		response.print("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">");
		response.print("<title>");
		response.print("注册成功");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.println("你注册的信息:"+uname);
		response.println("你喜欢的类型:");
		for(String v:favs) {
			if(v.equals("0")) {
				response.println("萝莉型");
			}
			if(v.equals("1")) {
				response.println("豪放型");
			}
			if(v.equals("2")) {
				response.println("经济节约型");
			}
			
		}
		
		response.print("</body>");
		response.print("</html>");
	}

}
