package ServerStudy.a1.com.jiada.server.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLTest2 {
public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
	//SAX解析
	//1.获取解析工厂
	SAXParserFactory factory= SAXParserFactory.newInstance();
	//从解析工厂获取解析器
	SAXParser parse= factory.newSAXParser();
	//加载文档Document 注册处理器
	//4.编写处理器
	PersonHandler handler= new PersonHandler();
	//解析
	parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/jiada/server/basic/p.xml"),handler);
	//获取数据
	List<Person> persons =handler.getPersons();
	for(Person p:persons) {
		System.out.println(p.getName()+"-->"+p.getAge());
	}
	
	
}
}
class PersonHandler extends DefaultHandler{
	List<Person>persons;
	private Person person;
	private String tag;
	
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		persons= new ArrayList<Person>();
		System.out.println("解析文档开始");
		
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(qName+"-->解析开始");
		if(null!=qName) {
			tag=qName;//存储标签吗
			if(tag.equals("person")) {
				person=new Person();
			}
		}
		
	
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String contents= new String(ch,start,length).trim();
		if(null!=tag) {
		if(tag.equals("name")) {
			person.setName(contents);
		}else if(tag.equals("age")) {
			if(contents.length()>0) {
				person.setAge(Integer.valueOf(contents));
			}
		}
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		if(null!=qName) {
		System.out.println(qName+"-->解析结束");
		if(qName.equals("person")) {
			persons.add(person);
		}
		}
		tag=null;//丢器
	}
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("解析文档结束");
		super.endDocument();
	}
	
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person>persons) {
		this.persons=persons;
	}
}
