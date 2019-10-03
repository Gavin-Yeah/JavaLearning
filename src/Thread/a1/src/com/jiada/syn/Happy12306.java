package Thread.a1.src.com.jiada.syn;

import java.util.ArrayList;
import java.util.List;

public class Happy12306 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Web12306 c =new Web12306(20, "DMV");
		 new Passenger(c,"Gavin",2).start();
		 new Passenger(c,"justn",12).start();
		
	}

}
class Passenger extends Thread{
	int seats;
	public Passenger( Runnable target, String name,int seats) {
		super(target,name);
		this.seats = seats;
	}



}
class Web12306 implements Runnable{
	int  available;
	String name;
	public Web12306(int available, String name) {
		super();
		this.available = available;
		this.name = name;
	}
	public synchronized boolean bookTicket(int seats) {
		System.out.println("可用位置"+available);
		if(seats>available) {
			return false;
		}
		available -=seats;
		return true;
	}
	
	public void run() {
		Passenger p= (Passenger)Thread.currentThread();
			boolean flag=this.bookTicket(p.seats);
			if(flag) {
				System.out.println("购票成功"+Thread.currentThread().getName()+"--位置为"+p.seats);
			}else {
				System.out.println("出票失败"+Thread.currentThread().getName()+"位置不够");
			}
		}	
	}
