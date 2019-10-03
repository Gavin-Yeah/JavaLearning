package Thread.a1.src.com.jiada.thread.create;

public class IDownLoader implements Runnable {

private String url;  //远程路径
private String name; //存储名字
@Override
public void run() {
	// TODO Auto-generated method stub
	WebDownLoader wd = new WebDownLoader();
	wd.download(url, name);
	System.out.println(name);
}
public IDownLoader(String url, String name) {
	super();
	this.url = url;
	this.name = name;
}

public static void main(String[] args) {
	IDownLoader td1 = new IDownLoader("https://www.mgmresorts.com/content/dam/MGM/shared/park-mgm/park-theater/lady-gaga/park-mgm-entertainment-park-theater-artist-lady-gaga.jpg", "poster.jpg");
	IDownLoader td2 = new IDownLoader("https://i.imgur.com/yTo4yre.jpg", "poster2.jpg");
	IDownLoader td3 = new IDownLoader("https://www.ydn.com.tw/ArticleFile/20181119/2018111915314331003.jpg?id=313508&m=v", "poster3.jpg");
	//启动三个线程
	new Thread(td1).start();
	new Thread(td2).start();
	new Thread(td3).start();
}
}
