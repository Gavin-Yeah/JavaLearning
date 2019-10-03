package Thread.a1.src.com.jiada.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 了解创建线程的方式三：
 * 
 * @author jiadaye
 *
 */
public class CDownLoader implements Callable<Boolean> {

private String url;  //远程路径
private String name; //存储名字
@Override
public Boolean call() throws Exception{
	// TODO Auto-generated method stub
	WebDownLoader wd = new WebDownLoader();
	wd.download(url, name);
	System.out.println(name);
	return true;
}
public CDownLoader(String url, String name) {
	super();
	this.url = url;
	this.name = name;
}

public static void main(String[] args) throws InterruptedException, ExecutionException {
	CDownLoader cd1 = new CDownLoader("https://www.mgmresorts.com/content/dam/MGM/shared/park-mgm/park-theater/lady-gaga/park-mgm-entertainment-park-theater-artist-lady-gaga.jpg", "poster.jpg");
	CDownLoader cd2 = new CDownLoader("https://i.imgur.com/yTo4yre.jpg", "poster2.jpg");
	CDownLoader cd3 = new CDownLoader("https://www.ydn.com.tw/ArticleFile/20181119/2018111915314331003.jpg?id=313508&m=v", "poster3.jpg");
	//创建执行服务：
	ExecutorService ser = Executors.newFixedThreadPool(3);
	//提交执行：
	Future<Boolean> result1=ser.submit(cd1);
	Future<Boolean> result2=ser.submit(cd2);
	Future<Boolean> result3=ser.submit(cd3);
	//获取结果
	boolean r1=result1.get();
	boolean r2=result2.get();
	boolean r3=result3.get();
	System.out.println(r3);
	//关闭服务
	ser.shutdownNow();
	
}
}
