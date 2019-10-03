package Thread.a1.src.com.jiada.thread.state;
/**
 * 
 * 终止线程
 * 1.线程正常执行完毕--》次数
 * 2.外部干涉--》加入标识
 * 不要使用stop destroy
 */
public class Terminatethread implements Runnable {
	//1.加入标识 标记线程提是否可以运行
	private boolean flag =true;
	private String name;
	public static void main(String[] args)  {
		Terminatethread tt=new Terminatethread("c罗");
		new Thread(tt).start();
		for(int i=0;i<99;i++) {
			if(i==88) {
				tt.terminate();//线程的终止
				System.out.println("tt games over");
			}
			System.out.println("main-->"+i);
		}
	}

	public Terminatethread(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		int i =0;
		// TODO Auto-generated method stub
		//2.关联标识，true--》运行 false-》停止
		while(flag) {
			System.out.println(name+"-->"+i++);
		}
	}
	//3.对外提供方法改变标识
	public void terminate() {
		this.flag=false;
	}

}
