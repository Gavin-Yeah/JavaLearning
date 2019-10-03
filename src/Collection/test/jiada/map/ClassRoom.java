package Collection.test.jiada.map;

import java.util.ArrayList;
import java.util.List;

/*
 * 一个班级多个学生
 */
public class ClassRoom {
	private String no;
	private List<Student> stuList;
	private double total;
	public ClassRoom() {
		super();
		stuList= new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	
	
	public ClassRoom(String no) {
		this();
		this.no=no;
		// TODO Auto-generated constructor stub
	}
	public ClassRoom(String no, List<Student> stuList, double total) {
		super();
		this.no = no;
		this.stuList = stuList;
		this.total = total;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public List<Student> getStuList() {
		return stuList;
	}
	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
