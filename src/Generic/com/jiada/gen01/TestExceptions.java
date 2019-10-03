package Generic.com.jiada.gen01;

public class TestExceptions {
	public static void main(String[] args) {
		int a=1;
		int b=0;
		if(b!=0) {
			int c=a/b;
		}
		
		
		String d= null;
		if(d!=null) {
			System.out.println(d.length());
		}
		
		
		Animal dog=new Dog();
		if(d instanceof Cat) {
		Cat  cat =(Cat)dog;  
		}
		
		
		int []arr= new int [5];
		int a2=5;
		if(a2<arr.length) {
			System.out.println(arr[a2]);
			
		}
		
	}
}
