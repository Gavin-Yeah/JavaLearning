package Collection.test.jiada.list;


import java.io.File;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
 
public class requests {
	public static void main(String args[]) {
		try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw
 
			/* ����TXT�ļ� */
			String pathname = "D:\\input.txt"; // ����·�������·�������ԣ������Ǿ���·����д���ļ�ʱ��ʾ���·��
			File filename = new File(pathname); // Ҫ��ȡ����·����input��txt�ļ�
			InputStreamReader reader = new InputStreamReader(
					new FileInputStream(filename)); // ����һ������������reader
			BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������
			String line = null;
			HashMap<String,Integer> host =new HashMap<>();
			line = br.readLine();
			while (line != null) {
		
					String[] temp= line.split(" ");
					if(host.containsKey(temp[0])) {
						host.put(temp[0], host.get(temp[0])+1);
								}
					else {
						host.put(temp[0],1);
					}	
				
				line = br.readLine(); // һ�ζ���һ������
			
				
			}
		
			/* д��Txt�ļ� */
			File writename = new File("D:\\"+"records_"+"input.txt"); // ���·�������û����Ҫ����һ���µ�output��txt�ļ�
			writename.createNewFile(); // �������ļ�
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			for(Map.Entry<String, Integer> entry:host.entrySet()) {
				out.write(entry.getKey()+" "+ entry.getValue()+"\r\n"); // \r\n��Ϊ����
			}
			
			out.flush(); // �ѻ���������ѹ���ļ�
			out.close(); // ���ǵùر��ļ�
 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
