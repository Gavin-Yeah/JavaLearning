package NetStudy.com.jiada.chat5;

import java.io.Closeable;
import java.io.IOException;

public class Utils {
//释放资源
	public static void close(Closeable ... targets) {
		for(Closeable target:targets) {
			try {
				target.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
	}
}
