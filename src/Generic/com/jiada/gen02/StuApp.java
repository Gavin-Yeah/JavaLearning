package Generic.com.jiada.gen02;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 泛型嵌套 由外到内进行拆分
 * @author jiadaye
 *
 */
public class StuApp {
	public static void main(String[] args) {
		Student<String> stu = new Student<String>();
		stu.setScore("excellent");
		stu.getScore();
		//generic nest
		classroom <Student<String>> classr = new classroom <Student<String>>();
		classr.setStu(stu);
		stu=classr.getStu();
		stu.setScore("xx");
		String score = stu.getScore();
		
		//HashMap  使用泛型的嵌套
		Map<String,String> map= new HashMap<>();
		map.put("A", "javase");
		map.put("B", "MASHI");
		Set< Entry <String,String>>entrySet =map.entrySet();
		for(Entry<String,String> entry:entrySet) {
			String key =entry.getKey();
			String value= entry.getValue();
			System.out.println(key+"-->"+value);
		}
		
	}
}
