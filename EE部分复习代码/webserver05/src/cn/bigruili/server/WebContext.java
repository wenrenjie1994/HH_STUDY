package cn.bigruili.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * list转map
 */
public class WebContext {
	private List<Entity> entitys;
	private List<Mapping> mappings;
	//key-servlet-name  value-servlet-class
	private Map<String,String> entityMap=new HashMap<>();
	//key-url-pattern  value-servlet-name
	private Map<String,String> mappingMap=new HashMap<>();
	public WebContext(List<Entity> entitys, List<Mapping> mappings) {
		this.entitys = entitys;
		this.mappings = mappings;
		for (Entity entity : entitys) {
			entityMap.put(entity.getName(), entity.getClz());	
			}
		for (Mapping mapping : mappings) {
			for (String pattern : mapping.getPatterns()) {
				mappingMap.put(pattern, mapping.getName());
			}
		}
	}
	public String getClz(String pattern){
		String name=mappingMap.get(pattern);
		return entityMap.get(name);
	}
	
}
