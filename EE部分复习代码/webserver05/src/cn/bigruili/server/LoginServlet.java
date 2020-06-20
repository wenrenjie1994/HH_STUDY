package cn.bigruili.server;

public class LoginServlet implements Servlet{

	@Override
	public void service(Request rq, Response rs) {
		rs.print("<html>");
		rs.print("<head>");
		rs.print("<title>");
		rs.print("登录");
		rs.print("</title>");
		rs.print("</head>");
		rs.print("<body>");
		rs.print("bigruili server"+rq.getParameter("uname")+"登录成功");
		rs.print("</body>");
		rs.print("</html>");
	}

}
