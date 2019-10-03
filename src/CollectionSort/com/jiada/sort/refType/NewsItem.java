package CollectionSort.com.jiada.sort.refType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewsItem implements Comparable<NewsItem> {
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("title is ").append(title);
		sb.append("time is ").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(pubTime));
		sb.append("hits is ").append(this.hits).append("\n");
		return  sb.toString();
	}
	private String title;
	private int hits;
	private Date pubTime;
	public NewsItem() {
		
	}
	public NewsItem(String title, int hits, Date pubTime) {
		super();
		this.title = title;
		this.hits = hits;
		this.pubTime = pubTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public Date getPubTime() {
		return pubTime;
	}
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}
	//时间降序，点击量升序，标题降序
	@Override
	public int compareTo(NewsItem o) {
		// TODO Auto-generated method stub
		 int result=0;
		 //比较时间
		 result=-this.pubTime.compareTo(o.pubTime);//降序
		 if(0==result) {
			 //比较点击量 
			 result=this.hits-o.hits;
			 if(0==result) {
				result=-this.title.compareTo(o.title);
			 }
		 }
		
		 
		return result;
	}
	
}
