package Generic.com.jiada.gen01;

public class TestEnum {
public static void main(String[] args) {
	 week a= week.mon;
	 switch(a) {
	 case mon:
		 System.out.println("mon");
		 break;
	 case tues:
		 System.out.println("tues");
	 }
		
			 
}
}


enum week{
	mon,tues,weds,thurs,fri,sat,sun
}
