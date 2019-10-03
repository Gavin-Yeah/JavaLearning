package NetStudy.com.jiada.chat5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

public class bitly {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		try {
			URL bitly = new URL("https://api-ssl.bitly.com/v4/groups/Bj4264l4HMs/countries");
			String host= bitly.getHost();
			int port=80;
			Socket client= new Socket(host,port);
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			DataInputStream dis=new DataInputStream(client.getInputStream());
		
			System.out.println(host+" "+port);
			StringBuilder headInfo = new StringBuilder();
			 String CRLF="\r\n";
			 headInfo.append("GET /groups/Bj4264l4HMs/countries HTTP/1.1").append(CRLF);
			headInfo.append("Host: api-ssl.bitly.com").append(CRLF);
			headInfo.append("Content-Type: application/x-www-form-urlencoded").append(CRLF);
			headInfo.append("Authentication: Bearer f3a76915a0cc8469d7e05d164e92374b38ba92f2").append(CRLF);
			bw.append(headInfo);
			bw.flush();
			while(true) {
			System.out.println(dis.readUTF());
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
