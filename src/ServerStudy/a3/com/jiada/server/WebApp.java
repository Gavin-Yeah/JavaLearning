package ServerStudy.a3.com.jiada.server;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;




public class WebApp {
	private static WebContext webContext;
	static {
		try {
			//SAX解析
			//1.获取解析工厂
			SAXParserFactory factory= SAXParserFactory.newInstance();
			//从解析工厂获取解析器
			SAXParser parse= factory.newSAXParser();
			//加载文档Document 注册处理器
			//4.编写处理器
			WebHandler handler= new WebHandler();
			
			//解析
			parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("web.xml"),handler);
			//获取数据
			webContext=new WebContext(handler.getEntities(), handler.getMappings());
		}catch(Exception e) {
			System.out.println("解析配置文件错误");
		}
	}
	
	/**
	 * 通过url获取配置文件对应的servlet
	 * @param url
	 * @return
	 */
	
	public static Servlet getServletFromUrl(String url) {
		//假设你输入了 /login
		String className=webContext.getClz("/"+url);
		Class clz;
		try {
			clz = Class.forName(className);
			Servlet servlet= (Servlet) clz.getConstructor().newInstance();
			return servlet;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return null;
			
	}
}
