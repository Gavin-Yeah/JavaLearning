package Thread.a1.src.com.jiada.syn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HappyCinema1 {
	
	public static void main(String[] args) {
		// 可用位置
		List<Integer> available=new ArrayList<>();
		Integer[] arr= {1,2,3,4,5};
		available=Arrays.asList(arr);
		List<Integer> seats1=new ArrayList<>();
		seats1.add(1);
		seats1.add(2);
		List<Integer> seats2=new ArrayList<>();
		seats2.add(3);
		seats2.add(1);
		SxtCinema c =new SxtCinema(available, "DMV");
		HappyCustomer a= new HappyCustomer(c,seats1 );
		HappyCustomer b= new HappyCustomer(c, seats2);
		new Thread(a,"gavin").start();
		new Thread(b,"billy").start();
		
	}

}
class SxtCinema{
	List<Integer>  available;
	String name;
	public SxtCinema(List<Integer>  available, String name) {
		super();
		this.available = available;
		this.name = name;
	}
	public boolean bookTicket(List<Integer> seats) {
		System.out.println("欢迎光临"+Thread.currentThread().getName()+" 可用位置"+available);
		List<Integer> copy=new ArrayList<>();
		copy.addAll(available);
		copy.removeAll(seats);
		if(available.size()-copy.size()!=seats.size()) {
			return false;
		}
		available=copy;
		return true;
	}
}
class HappyCustomer implements Runnable{
	SxtCinema cinema;
	List<Integer> seats;
	
	public HappyCustomer(SxtCinema cinema, List<Integer> seats) {
		super();
		this.cinema = cinema;
		this.seats = seats;
	}

	@Override
	public void run() {
		synchronized (cinema) {
			// TODO Auto-generated method stub
			boolean flag=cinema.bookTicket(seats);
			if(flag) {
				System.out.println("购票成功"+Thread.currentThread().getName()+"--位置为"+seats);
			}else {
				System.out.println("出票失败"+Thread.currentThread().getName()+"位置不够");
			}
		}
		
		
	}
	
}