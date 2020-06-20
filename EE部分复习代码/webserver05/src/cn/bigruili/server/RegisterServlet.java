package cn.bigruili.server;

public class RegisterServlet implements Servlet {

	public void service(Request rq, Response rs) {
		rs.print("<html>");
		rs.print("<head>");
		rs.print("<title>");
		rs.print("注册");
		rs.print("</title>");
		rs.print("</head>");
		rs.print("<body>");
		rs.print("bigruili server"+rq.getParameter("uname")+"注册成功");
		rs.print("</body>");
		rs.print("</html>");
		
	}
}
