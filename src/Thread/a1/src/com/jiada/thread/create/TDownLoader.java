package Thread.a1.src.com.jiada.thread.create;

public class TDownLoader extends Thread {

private String url;  //远程路径
private String name; //存储名字
@Override
public void run() {
	// TODO Auto-generated method stub
	WebDownLoader wd = new WebDownLoader();
	wd.download(url, name);
	System.out.println(name);
}
public TDownLoader(String url, String name) {
	super();
	this.url = url;
	this.name = name;
}

public static void main(String[] args) {
	TDownLoader td1 = new TDownLoader("https://www.mgmresorts.com/content/dam/MGM/shared/park-mgm/park-theater/lady-gaga/park-mgm-entertainment-park-theater-artist-lady-gaga.jpg", "poster.jpg");
	TDownLoader td2 = new TDownLoader("https://i.imgur.com/yTo4yre.jpg", "poster2.jpg");
	TDownLoader td3 = new TDownLoader("https://www.ydn.com.tw/ArticleFile/20181119/2018111915314331003.jpg?id=313508&m=v", "poster3.jpg");
	//启动三个线程
	td1.start();
	td2.start();
	td3.start();
}
}
