package Del;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;

public class DelUserServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//读取要删除的用户id
		String id=request.getParameter("id");
		//调用Dao对象的方法来删除制定id的用户
		UserDao dao=new UserDao();
		try {
			dao.delete(Integer.parseInt(id));
			//重定向到用户列表
			response.sendRedirect("list");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙");
		}
	}
}
