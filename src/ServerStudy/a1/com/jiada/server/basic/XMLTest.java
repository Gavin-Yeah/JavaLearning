package ServerStudy.a1.com.jiada.server.basic;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLTest {
public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
	//SAX解析
	//1.获取解析工厂
	SAXParserFactory factory= SAXParserFactory.newInstance();
	//从解析工厂获取解析器
	SAXParser parse= factory.newSAXParser();
	//加载文档Document 注册处理器
	//4.编写处理器
	Handler handler= new Handler();
	//解析
	parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/jiada/server/basic/p.xml"),handler);
	
	
	
}
}
class Handler extends DefaultHandler{
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("解析文档开始");
		super.startDocument();
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(qName+"-->解析开始");
		super.startElement(uri, localName, qName, attributes);
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String contents= new String(ch,start,length).trim();
		if(contents.length()>0) {
			System.out.println("内容为"+contents);
		}else {
			System.out.println("内容为空");
		}
		super.characters(ch, start, length);
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(qName+"-->解析结束");
		super.endElement(uri, localName, qName);
	}
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("解析文档结束");
		super.endDocument();
	}
}
