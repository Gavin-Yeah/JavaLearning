package ServerStudy.a3.com.jiada.server;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class WebHandler extends DefaultHandler{
	private List<Entity>entities= new ArrayList<Entity>();
	private List<Mapping>mappings=new ArrayList<Mapping>();
	private Entity entity;
	private Mapping mapping;
	private String tag;
	private boolean isMapping;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(qName+"-->解析开始");
		if(null!=qName) {
			tag=qName;//存储标签吗
			if(tag.equals("servlet")) {
				entity=new Entity();
				isMapping=false;
			}else if(tag.equals("servlet-mapping")) {
				mapping= new Mapping();
				isMapping=true;
			}
		}
		
	
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String contents= new String(ch,start,length).trim();
		if(null!=tag) {
			if(isMapping) {//operate servlet mapping
			if(tag.equals("servlet-name")) {
				mapping.setName(contents);
			}else if(tag.equals("url-pattern")) {
			mapping.addPattern(contents);
			}
			}else {
				if(tag.equals("servlet-name")) {
					entity.setName(contents);
				}else if(tag.equals("servlet-class")) {
						entity.setClz(contents);
				
				}	
			}
	
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		if(null!=qName) {
		System.out.println(qName+"-->解析结束");
		if(qName.equals("servlet")) {
			entities.add(entity);
		}else if(qName.equals("servlet-mapping")) {
			mappings.add(mapping);
		}
		}
		tag=null;//丢弃
	}
	public List<Entity> getEntities() {
		return entities;
	}
	
	public List<Mapping> getMappings() {
		return mappings;
	}


}

