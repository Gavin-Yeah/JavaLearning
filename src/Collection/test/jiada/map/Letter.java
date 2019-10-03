package Collection.test.jiada.map;
/**
 * javabean 存储数据 po bo vo  包含setter 与getter访问器的类
 * @author jiadaye
 *
 */
public class Letter {
	private String name;
	private int count;
//	OPTION+COMMAND+S
	public Letter(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}
	public Letter(String name) {
		super();
		this.name = name;
	
	}
	public 	Letter() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
