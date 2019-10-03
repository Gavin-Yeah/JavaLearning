package CollectionSort.com.jiada.sort.refType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.jiada.sort.innertype.Utils;

/**
 * 使用Collections
 * @author jiadaye
 *
 */
public class NewsItemApp {
	public static void main(String[] args) {
		List<NewsItem>list=new ArrayList<>();
		list.add(new NewsItem("美利坚",100,new Date()));
		list.add(new NewsItem("mmm",1000,new Date(System.currentTimeMillis()-1000*60*60)));
		list.add(new NewsItem("工程图",50,new Date(System.currentTimeMillis()+1000*60*60)));
		list.add(new NewsItem("bh",100,new Date(System.currentTimeMillis()-1000*60*60)));
		System.out.println("排序前"+list);
		//排序
		//Utils.sort(list);
		Collections.sort(list);
		
		System.out.println("排序后"+list);
	}
}
