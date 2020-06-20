package cn.bigruili.server;

public class OthersServlet implements Servlet {

	public void service(Request rq, Response rs) {
		rs.print("<html>");
		rs.print("<head>");
		rs.print("<title>");
		rs.print("其他测试");
		rs.print("</title>");
		rs.print("</head>");
		rs.print("<body>");
		rs.print("bigruili server"+rq.getParameter("uname")+"其他测试页面");
		rs.print("</body>");
		rs.print("</html>");
		
	}
}
