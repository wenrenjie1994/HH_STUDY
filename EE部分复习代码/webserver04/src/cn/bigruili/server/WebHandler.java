package cn.bigruili.server;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 
 * @author RuiLi
 *  xml处理器
 */
public class WebHandler extends DefaultHandler{
	private List<Entity> entitys;
	private List<Mapping> mappings;
	private Entity entity;
	private Mapping mapping;
    private String tag;//存储操作标签
    private boolean isMapping;//存储操作标签
    
	@Override
	public void startDocument() throws SAXException {
		System.out.println("---解析文档开始---");
		entitys=new ArrayList<Entity>();
		mappings=new ArrayList<Mapping>();
		isMapping=false;
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
         System.out.println("---解析开始---");
		if(qName!=null){
        	 tag=qName;//存储标签名
        	 if(tag.equals("servlet")){
        		 entity=new Entity();
        		 isMapping=false;
        	 }else  if(tag.equals("servlet-mapping")){
        		 mapping=new Mapping();
        		 isMapping=true;
        	 }
         }
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("---解析中---");
		String contents=new String(ch,start,length).trim();//去空格
		if(tag!=null){//处理空
			if(isMapping){
			if(tag.equals("servlet-name")){
				mapping.setName(contents);
			}else if(tag.equals("url-pattern")){
				mapping.addPatterns(contents);				
			}
		  }else{//操作servlet
			  if(tag.equals("servlet-name")){
				  entity.setName(contents);
				}else if(tag.equals("servlet-class")){
					entity.setClz(contents);				
				}
		  }  
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("---解析结束---");
		if(qName!=null){
        	 if(qName.equals("servlet")){
        		 entitys.add(entity);
        	 }else if(qName.equals("servlet-mapping")){
        		 mappings.add(mapping);
        	 }
         }
         tag=null;
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("---解析文档结束---");
	}
	public List<Entity> getEntitys() {
		return entitys;
	}
	
	public List<Mapping> getMappings() {
		return mappings;
	}
	
}