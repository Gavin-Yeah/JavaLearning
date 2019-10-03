package ServerStudy.a4.com.jiada.server.core;
/**
 * <servlet>
		<servlet-name>login</servlet-name>
		<servelet-class>com.shsxt.LoginServlet</servelet-class>
	</servlet>
 * @author jiadaye
 *
 */
public class Entity{
	private String name;
	private String clz;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClz() {
		return clz;
	}
	public void setClz(String clz) {
		this.clz = clz;
	}
	

}
