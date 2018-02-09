package Web;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import User.User;


public class AddUserServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String phone=request.getParameter("phone");
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
	
			try {
				User user=new User();
				user.setUname(uname);
				user.setPwd(pwd);
				user.setPhone(phone);
				//System.out.println("uname:"+uname+"pwd"+pwd+"phone"+phone);
				UserDao.save(user);
				
//				out.println("添加成功");
//				out.println("<p><a href='list'>用户列表</a></p>");
				//重定向到用户列表
				response.sendRedirect("list");
			} catch (Exception e) {
				
				e.printStackTrace();
				out.println("添加错误");
			}
	
		
	}
}
