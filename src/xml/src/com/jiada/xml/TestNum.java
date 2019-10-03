package xml.src.com.jiada.xml;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class TestNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start=System.currentTimeMillis();
		//1.将这些数据备份为xml文件
		List<Num> list= selAll();
		System.out.println(list.size());
		//将list的数据输出到xmlwenjianzhong
		writeNum2XML(list);
		long end= System.currentTimeMillis();
		System.out.println(end-start);
	}
	/**
	 * 将list中的数据写入xml文件
	 * @param list
	 */
private static void writeNum2XML(List<Num> list) {
		// TODO Auto-generated method stub
		Document doc= DocumentHelper.createDocument();
		Element nums=doc.addElement("nums");
		//循环为根元素添加子元素
		for (Num num : list) {
			nums.addElement("num")
			.addAttribute("id", num.getId())
			.addAttribute("type", num.getType())
			.addText(num.getNum()+"");
		}
		//输出文件
		OutputFormat format= OutputFormat.createPrettyPrint();
		XMLWriter writer=null;
		try {
			writer=new XMLWriter(new FileWriter("src/nums.xml"),format);
			writer.write(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
private static List<Num> selAll(){
	List<Num> list= new ArrayList();
	String sql="select * from t_num order by num";
	Connection conn=DBUtil.getconn();
	PreparedStatement pstmt= DBUtil.getPstmt(conn,sql);
	ResultSet rs=null;
	rs=pstmt.executeQuery();
	while(rs.next()) {
		Num num= new Num();
		num.setId(rs.getNString("id"));
		num.setNum(rs.getInt("num"));
		num.setType(rs.getString("type"));
		list.add(num);
		
	}
	//DBUtil.close(rs,pstmt,conn);
	return list;
}

}
