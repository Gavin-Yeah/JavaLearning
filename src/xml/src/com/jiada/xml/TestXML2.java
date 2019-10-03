package xml.src.com.jiada.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class TestXML2 {
	public static void main(String[] args) throws IOException {
		//by DocumentHelper, generate an object of Document
		Document doc=DocumentHelper.createDocument();
		//doc.addElement("books").addElement("book").addAttribute("id", "b01");
		//add root elemt and get the element
		Element root=doc.addElement("books");
		//Add child element , chaining programming
		Element book=root.addElement("book");
		book.addAttribute("id", "b01");
		//add child elements
		Element name=book.addElement("name");
		Element author=book.addElement("author");
		Element price=book.addElement("price");
		//add text for the element
		name.addText("Thinking in JAVA");
		author.addText("mike");
		price.addText("88");
	/*	//outstream the doc to xml file
		Writer writer= new FileWriter(new File("src/book2.xml"));
		doc.write(writer);
		//close the resource
		writer.close();
		
	*/
		//get the output with good format
		OutputFormat format=OutputFormat.createPrettyPrint();
		 XMLWriter writer=new XMLWriter(new FileWriter(new File("src/book2.xml")),format);
		writer.write(doc);
		 //close the resource
		writer.close();
		
	}
}
