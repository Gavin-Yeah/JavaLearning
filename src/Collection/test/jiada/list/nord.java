package Collection.test.jiada.list;

import java.util.Scanner;

public class nord {
public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	String line = input.nextLine();
	if(line!=null) {
	String a= function(line);
	System.out.println(a);
	}
}
public static String function(String a) {
	StringBuilder ret= new StringBuilder();
	char []b=a.toCharArray();
//	if(a==null||a.length()==0) return "NONE";
	for(int i=0;i<b.length;i++) {
		if(b[i]>'j'||b[i]<'a') {
			return "NONE";
		}
		else {
			ret.append(b[i]-'a');
		}
	}
	return ret.toString();
	
	
}
}
