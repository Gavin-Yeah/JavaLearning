package Generic.com.jiada.gen02;

public class Student<T> {
	private T score;

	public Student() {
		
	}
	public Student(T score) {
		this.score=score;
	}
	public T getScore() {
		return score;
	}

	public void setScore(T score) {
		this.score = score;
	}
	
}
