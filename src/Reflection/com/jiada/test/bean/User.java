package Reflection.com.jiada.test.bean;

public class User {
	private int id;
	private String uname;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public User(int id, int age, String uname) {
		super();
		this.id = id;
		this.uname = uname;
		this.age = age;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
