package CollectionOthers.com.jiada.others.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 使用队列模拟银行存款业务
 * @author jiadaye
 *
 */
public class Demo1 {
public static void main(String[] args) {
		Queue<Request> que= new ArrayDeque<>();
		//模拟排序情况
		for(int i=0;i<10;i++) {
			final int num= i;
			que.offer(new Request() {
				//只能访问final 修饰的对象
				@Override
				public void deposit() {
					// TODO Auto-generated method stub
				System.out.println("第"+num+"个人办理存款业务，存款额度为"+(Math.random()*10000));	
				}
				
			});
			
		}
		dealWith(que);
}
public static void dealWith(Queue <Request>que) {
	Request req=null; 
	while(null!=(req=que.poll())) {
		req.deposit();
	}
}
}
interface Request{
	void deposit();
}
