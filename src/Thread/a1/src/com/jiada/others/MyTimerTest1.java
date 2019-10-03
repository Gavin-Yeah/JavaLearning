package Thread.a1.src.com.jiada.others;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调度：借助Timer TimerTask
 * @author jiadaye
 *
 */
public class MyTimerTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer timer=new Timer();
		//timer.schedule(new MyTask(), 1000);执行任务1次
	//	timer.schedule(new MyTask(), 1000,200);//每隔200ms一次
		Calendar cal=new GregorianCalendar(2099,12,31,21,53,54);
		
		timer.schedule(new MyTask(),cal.getTime(),200);
	}

}
//任务类
class MyTask extends TimerTask{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			System.out.println("放空大脑");
			
		}
		System.out.println("end");
	}
	
}