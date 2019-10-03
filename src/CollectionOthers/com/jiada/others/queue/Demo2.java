package CollectionOthers.com.jiada.others.queue;
/**
 * 测试自定义堆栈
 * @author jiadaye
 *
 */
public class Demo2 {
public static void main(String[] args) {
	
	MyStack<String> backHistory= new MyStack<>(3);
	backHistory.push("www.baidu.com");
	backHistory.push("www.google.com");
	backHistory.push("www.sina.com");
	backHistory.push("www.bjsxt.cn");
	System.out.println("大小"+backHistory.size());
	//遍历
	String item=null;
	while(null!=(item=backHistory.pop())){
		System.out.println(item);
	}
}
}
