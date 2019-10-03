package ServerStudy.a4.com.jiada.server.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebContext {
	private List<Entity> entities =null;
	private List<Mapping> mappings=null;
	
	//key-->servlet-name value->servlet-class
	private Map<String,String>entityMap= new HashMap();
	//key-->url-pattern value->servlet-name
	private Map<String,String>mappingMap= new HashMap();
	public WebContext(List<Entity> entities, List<Mapping> mappings) {
		super();
		this.entities = entities;
		this.mappings = mappings;
		//将entity的list转成对应的map
		for(Entity entity:entities) {
			entityMap.put(entity.getName(),entity.getClz());
		}
		for(Mapping mapping:mappings) {
			for(String pattern:mapping.getPatterns()) {
				mappingMap.put(pattern,mapping.getName());
			}
			
		}
	}
	/**
	 * 通过url的路径找到对应的class
	 * @param pattern
	 * @return
	 */
	public String getClz(String pattern) {
		String name= mappingMap.get(pattern);
		return entityMap.get(name);
	}

}
