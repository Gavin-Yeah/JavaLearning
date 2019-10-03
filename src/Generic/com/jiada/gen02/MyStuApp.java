package Generic.com.jiada.gen02;

/**
 * 泛型的擦除：使用时【实现】继承没有指定类型
 * 类似于object,不等同于object
 * @author jiadaye
 *
 */
public class MyStuApp {
	public static void main(String[] args) {
		//擦除 --》没有指定泛型的具体类型
			Student student = new Student();
			student.setScore(100);//100--》int --》integer
			Object object=student.getScore();
			test(student);
			Student<Object> student2 = new Student();
			//不等于object
			//test(student2);
}
		public static void test(Student<Integer> stu) {
			
		}
}
