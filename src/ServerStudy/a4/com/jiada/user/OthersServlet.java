package ServerStudy.a4.com.jiada.user;

import com.jiada.server.core.Request;
import com.jiada.server.core.Response;

public class OthersServlet implements Servlet {

	@Override
	public void service(Request request, Response response) {
		// TODO Auto-generated method stub
		response.print("其他测试页面");
	}

}
