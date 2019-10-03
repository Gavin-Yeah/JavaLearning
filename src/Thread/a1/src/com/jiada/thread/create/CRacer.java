
package Thread.a1.src.com.jiada.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 模拟龟兔赛跑
 * @author jiadaye
 *
 */
public class CRacer implements Callable<Integer> {
	private String winner;
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		CRacer racer= new CRacer();
		//创建执行服务：
		ExecutorService ser = Executors.newFixedThreadPool(2);
		//提交执行：
		Future<Integer> result1=ser.submit(racer);
		Future<Integer> result2=ser.submit(racer);
		
		//获取结果
		Integer r1=result1.get();
		Integer r2=result2.get();
	
		System.out.println(r1);
		//关闭服务
		ser.shutdownNow();
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		for(int step=1;step<=100;step++) {
			//模拟休息
			if(Thread.currentThread().getName().equals("pool-1-thread-1")&&step%10==0) {
				
					Thread.sleep(100);
				
			}
			System.out.println(Thread.currentThread().getName()+"-->"+step);
			//比赛是否结束
			boolean flag = gameOver(step);
			if(flag) {
				return step;
			}
		}
		return null;
	}
	private boolean gameOver(int step) {
		if(winner!=null) {
			return true;
		}else {
			if(step==100) {
				winner=Thread.currentThread().getName();
				System.out.println("winner-->" +winner);
				return true;
			}
		}
		return false;
	}

}
