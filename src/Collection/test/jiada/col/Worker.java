package Collection.test.jiada.col;

public class Worker implements Comparable<Worker> {
	private String type;
	private int salary;
	public Worker(String type, int salary) {
		super();
		this.type = type;
		this.salary = salary;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Worker() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(Worker o) {
		// TODO Auto-generated method stub
		return this.salary>o.salary?1:this.salary<o.salary?-1:0;
	}
	@Override
	public String toString() {
		return "Worker [type=" + type + ", salary=" + salary + "]";
	}
	
	
	
	
}
