package Thread.a1.src.com.jiada.syn;

public class HappyCinema {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cinema c =new Cinema(20, "DMV");
		Customer a= new Customer(c, 5);
		Customer b= new Customer(c, 6);
		new Thread(a,"gavin").start();
		new Thread(b,"billy").start();
		
	}

}
class Cinema{
	int available;
	String name;
	public Cinema(int available, String name) {
		super();
		this.available = available;
		this.name = name;
	}
	public boolean bookTicket(int seats) {
		System.out.println("可用位置"+available);
		if(seats>available) {
			return false;
		}
		available -=seats;
		return true;
	}
}
class Customer implements Runnable{
	Cinema cinema;
	int seats;
	
	public Customer(Cinema cinema, int seats) {
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