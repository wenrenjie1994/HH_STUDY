package cn.bigruili.server.peoplexml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * SAX解析
 */
public class XmlTest01 {
public static void main(String[] args) throws Exception, IOException, ParserConfigurationException {
	//1.获取解析工厂
	SAXParserFactory factory=SAXParserFactory.newInstance();
	//2.从解析工厂获取解析器
	SAXParser parser=factory.newSAXParser();
	//3编写处理器
	//4.加载处理器
	PersonHandler handler=new PersonHandler();
	//5.解析
	parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/bigruili/server/peoplexml/person.xml"),handler );
    //获取数据
	List<Person> persons=handler.getPersons();
	for (Person p : persons) {
		System.out.println(p.getName()+"-->"+p.getAge());
	}
}
public static class PersonHandler extends DefaultHandler{
    private List<Person> persons;
    private Person person;
    private String tag;//存储操作标签
	@Override
	public void startDocument() throws SAXException {
		System.out.println("---解析文档开始---");
		persons=new ArrayList<Person>();
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
         System.out.println("---解析开始---");
		if(qName!=null){
        	 tag=qName;//存储标签名
        	 if(tag.equals("person")){
        		 person=new Person();
        	 }
         }
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("---解析中---");
		String contents=new String(ch,start,length).trim();//去空格
		if(tag!=null){//处理空
			if(tag.equals("name")){
				person.setName(contents);
			}else if(tag.equals("age")){
				if(contents.length()>0){
					person.setAge(Integer.valueOf(contents));
				}
			}
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("---解析结束---");
		if(qName!=null){
        	 if(qName.equals("person")){
        		 persons.add(person);
        	 }
         }
         tag=null;
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("---解析文档结束---");
	}
	public List<Person> getPersons() {
		return persons;
	}
	
}
}
