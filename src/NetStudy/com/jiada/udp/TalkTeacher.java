package NetStudy.com.jiada.udp;

public class TalkTeacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new TalkReceive(9999,"学生")).start();//接收
		new Thread(new TalkSend(5555, "localhost", 8888)).start();
	
	}

}
