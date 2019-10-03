package CollectionOthers.com.jiada.others.guava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;




/**
 * 只读
 * @author jiadaye
 *
 */
public class Demo1 {
public static void main(String[] args) {
	List<String> list= new ArrayList<>();
	list.add("a");
	list.add("b");
	list.add("c");
	//对原有list进行包装，相当于原有list的一个视图，快照,不够安全
	List<String> readList = Collections.unmodifiableList(list);
	//Exception in thread "main" java.lang.UnsupportedOperationException
	//readList.add("d");
	list.add("d");//改变原有list，视图也跟着改变
	System.out.println(readList);
	//对比查看
	List<String> immutableList = ImmutableList.of("a","b","c");
}
}
