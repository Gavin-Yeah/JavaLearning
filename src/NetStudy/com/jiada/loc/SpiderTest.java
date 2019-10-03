package NetStudy.com.jiada.loc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 网络爬虫的原理+模拟浏览器
 * @author jiadaye
 *
 */
public class SpiderTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//获取url
		//URL url=new URL("https://www.jd.com");
		URL url=new URL("http://www.dianping.com/shanghai");
		File dest = new File("/Users/jiadaye/workspace/b.txt");
		BufferedWriter wr = null;
		wr=new BufferedWriter(new FileWriter(dest));
		//下载资源
	HttpURLConnection conn=(HttpURLConnection)url.openConnection();
	conn.setRequestMethod("GET");
	conn.setRequestProperty("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.119 Safari/537.36");
		BufferedReader br =new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		String msg=null;
		while(null!=(msg=br.readLine())) {
			System.out.println(msg);
			wr.write(msg);
			//	wr.append("\r\n");
				wr.newLine();//换行符号
		}
		br.close();
		//分析
		
		//处理
	}

}
