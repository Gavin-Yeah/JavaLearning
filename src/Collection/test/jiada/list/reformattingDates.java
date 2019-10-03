package Collection.test.jiada.list;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class reformattingDates {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String a = "1st Mar 1984";
		String[] sep = a.split(" ");

		String day = sep[0].substring(0, sep[0].length() - 2);
		String[] arr = { "", "Jan", "Feb", "Mar", "April", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec" };
		int mon = Arrays.asList(arr).indexOf(sep[1]);
		String year = sep[2];
	//	ArrayList<Integer> l=new ArrayList<>();
	//	l.sort(new c());
		 HashMap <Integer,Boolean>map = new HashMap<>();
		
		String c = day + "-" + mon + "-" + year;
		System.out.println(c);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date date1 = df.parse(c);
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		String out = df2.format(date1);
		System.out.println(out);

	}
	

}
class c implements java.util.Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1-o2;
	}


	
}
