package ServerStudy.a4.com.jiada.user;

import ServerStudy.a4.com.jiada.server.core.Request;
import ServerStudy.a4.com.jiada.server.core.Response;

/**
 * 服务器小脚本接口
 * @author jiadaye
 *
 */
public interface Servlet {
	void service(Request request, Response response);
	//void doGet(Request request, Response response);
	//void doPost(Request request, Response response);

}
