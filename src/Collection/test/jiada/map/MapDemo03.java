package Collection.test.jiada.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 方案：面向对象+分解存储
 * @author jiadaye
 *
 */
public class MapDemo03 {
	public static void main(String[] args) {
		//1.exam
		List <Student>stuList= exam();
		//2.分析成绩
		Map<String, ClassRoom> map=count(stuList);
		//3.查看成绩
		view(map);
	}
	
	
	/**
	 * 统计分析
	 * 1.面向对象
	 * 2.分解存储
	 */
	public static Map<String,ClassRoom> count(List<Student> list){
		Map<String,ClassRoom> map= new HashMap<>();
		//1.遍历list
		for(Student stu:list) {
			//分拣 查看是否存在 该编号的班级
			String no = stu.getNo();
			double score = stu.getScore();
			//如果不存在，创建班级
			ClassRoom room = map.get(no);
			if(null== room) {
				room = new ClassRoom(no);
				map.put(no, room);
				
				
			}
			room.getStuList().add(stu);//放入学生
			room.setTotal(room.getTotal()+score);//计算总分
		}
		
		
		return map;
	}
	/**
	 * 查看每班的平均分
	 * 
	 */
	public static void view(Map<String,ClassRoom>map) {
		Set<String>keys=map.keySet();
		//获取迭代器对象
		Iterator<String> keysIt=keys.iterator();
		//先判断
		while(keysIt.hasNext()) {
			String no= keysIt.next();
			ClassRoom room=map.get(no);
			//查看总分 平均分
			double total=room.getTotal();
			double average=total/room.getStuList().size();
			System.out.println(no+"-->"+total+"-->"+average);
		}
	}
	
	/**
	 * 模拟考试 测试数据到list中
	 */
	public static List<Student> exam(){
		List<Student> list= new ArrayList<>();
		//存放学生
		list.add(new Student("jaida","a",80));
		list.add(new Student("j","a",80));
		list.add(new Student("a","a",90));
		list.add(new Student("ja","b",80));
		list.add(new Student("da","a",100));
		return list;
	}
}
