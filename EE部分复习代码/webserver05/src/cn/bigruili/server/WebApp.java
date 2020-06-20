package cn.bigruili.server;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * 
 * @author RuiLi
 * SAX解析+web.xml的url获取servlet
 */
public class WebApp {
	private static WebContext context;
      static{
			try {
				//1.获取解析工厂
				SAXParserFactory factory=SAXParserFactory.newInstance();
				//2.从解析工厂获取解析器
				SAXParser parser=factory.newSAXParser();
				//3编写处理器
				//4.加载处理器
				WebHandler handler=new WebHandler();
				//5.解析
				parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/bigruili/server/web.xml"),handler );
				//获取数据
			    context=new WebContext(handler.getEntitys(),handler.getMappings());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("WebApp出错");
			} 
      }
      public static Servlet getServletFromUrl(String url){
    		//测试
    		String className=context.getClz("/"+url);
    		try {
    		   Class clz=Class.forName(className);
    		   Servlet servlet=(Servlet) clz.getConstructor().newInstance();
    		   return servlet;
			} catch (Exception e) {
				System.out.println("url转servlet错误");
			}
			return null;
      }
}
