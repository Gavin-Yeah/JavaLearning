package xml.src.com.jiada.xml;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class testxml {
	public static void main(String[] args) throws DocumentException {
		//create a SAXReader, to read xml file
		SAXReader reader=new SAXReader();
		//load the xml file.get the object of Document
		Document doc=reader.read(new File("src/score2.xml"));
		System.out.println(doc);
		//get the root element
		Element root=doc.getRootElement();
		System.out.println(root.getName());
		//get all elements under the root element
		Iterator<Element> it=root.elementIterator();
		while(it.hasNext()) {
			//get the element
			Element e=it.next();
			System.out.println(e.getName());
			//get attribute of the element
			Attribute id= e.attribute("id");
			System.out.println(id.getName()+" = "+id.getValue());
			//get the child elements of the elment
			Element name=e.element("name");
			Element course=e.element("course");
			Element score=e.element("score");
			//print
			System.out.println(name.getName()+"="+name.getStringValue());
			System.out.println(course.getName()+"="+course.getText());
			System.out.println(score.getName()+"="+score.getText());
			System.out.println("--------------");
		}
		
		
	}
}
