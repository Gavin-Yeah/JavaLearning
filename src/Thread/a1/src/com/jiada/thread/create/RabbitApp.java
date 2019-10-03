package Thread.a1.src.com.jiada.thread.create;

public class RabbitApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建子类对象
		Rabbit rab = new Rabbit();
		Tortoise tor = new Tortoise();
		//调用start（）方法
		rab.start();//不要调用run方法
		tor.start();
		for(int i=0;i<1000;i++) {
			System.out.println("main==>"+i);
			
		}
	}

}
