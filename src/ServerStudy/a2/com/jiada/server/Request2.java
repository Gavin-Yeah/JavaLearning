package ServerStudy.a2.com.jiada.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装请求协议：封装请求参数
 * 
 * @author jiadaye
 *
 */
public class Request2 {
	//协议信息
	private String requestInfo;
	//请求方式
	private String method;
	//请求url
	private String url;
	//请求参数
	private String queryStr;
	//存储参数
	private Map<String,List<String>>parameterMap;
	
	private final String CRLF="\r\n";
	public Request2(InputStream is) {
		parameterMap=new HashMap<>();
		byte[] datas=new byte[1024*1024];
		int len;
		try {
			len = is.read(datas);
			 this.requestInfo=new String(datas,0,len);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		//分解字符串
		parseRequestInfo();
	}
	private void parseRequestInfo() {
		System.out.println("parsing-------------");
		System.out.println("--1。获取请求方式：开头第一个/----");
		this.method=this.requestInfo.substring(0,this.requestInfo.indexOf("/")).toLowerCase();
		this.method=this.method.trim();
		System.out.println("-------2.获取url：第一个/到HTTP/-----");
		System.out.println("可能包含请求参数？前面的为url------");
		//1）获取/的位置
		int startIdx= this.requestInfo.indexOf("/")+1;
		//2）获取HTTP/的位置
		int endIdx=this.requestInfo.indexOf("HTTP/");
		//3.分割字符串
		this.url=this.requestInfo.substring(startIdx,endIdx);
		
		//4.获取问号位置
		int queryIdx=this.url.indexOf("?");
		if(queryIdx>=0) {
			String [] urlArray= this.url.split("\\?");
			this.url=urlArray[0];
			queryStr=urlArray[1].trim();
			
		}
		System.out.println(this.url);
		System.out.println("--3.获取请求参数：如果get已经获取，如果是post可能在请求体里");
		
		if(method.equals("post")) {
			String qStr=this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
			
			if(null==queryStr) {
				queryStr=qStr;
			}else {
				queryStr+="&"+qStr;
			}
		}
		queryStr=null==queryStr?"":queryStr;
		System.out.println(method+"--->"+url+"--->"+queryStr);
		//转成map fav=1&fav=2&uname=jiada&age=18&other=
		convertMap();
	}
	private void convertMap() {
		//分割字符串
		String[]keyValues=this.queryStr.split("&");
		for(String query:keyValues) {
			String[]kv=query.split("=");
			kv=Arrays.copyOf(kv, 2);
			//获取key和value
			String key=kv[0];
			String value=kv[1]==null?null:decode(kv[1],"utf-8");
			//存储到map
			if(!parameterMap.containsKey(key)) {
				parameterMap.put(key, new ArrayList<String>());
			}
			parameterMap.get(key).add(value);
		}
	}
	/**
	 * 通过name获取对应的多个值
	 * @param key
	 * @return
	 */
	public String [] getParameterValues(String key) {
		List<String> value=this.parameterMap.get(key);
		if(null==value||value.size()<1) {
			return null;
		}
		return value.toArray(new String[0]);
	}
	/**
	 * 通过name获取对应的1个值
	 * @param key
	 * @return
	 */
	public String getParameterValue(String key) {
		String [] values=getParameterValues(key);
		
		return values==null?null:values[0];
	}
	private String decode(String value,String enc) {
		try {
			return java.net.URLDecoder.decode(value, enc);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Request2(Socket client) throws IOException {
		this(client.getInputStream());
	}
	public String getMethod() {
		return method;
	}
	
	public String getUrl() {
		return url;
	}

	public String getQueryStr() {
		return queryStr;
	}

	
}
