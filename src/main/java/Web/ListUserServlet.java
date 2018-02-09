package Web;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import User.User;

public class ListUserServlet {
public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		//使用DAO查询数据库,将所有用户信息查询出来
		
		try {
			UserDao dao=new UserDao();
			List<User> users=dao.findAll();
			out.println("<table border='1' width='60%'>");
			out.println("<tr><td>id</td><td>用户名</td><td>密码</td><td>电话</td></tr>");
			for(int i=0; i< users.size(); i++){
				User user = users.get(i);
			int id=user.getId();
	    	String username=user.getUname();
	    	String password=user.getPwd();
	    	String phone=user.getPhone();
	    	out.println("<tr><td>"+id+"</td><td>"+username+"</td><td>"+password+"</td><td>"+phone+"</td><td><a href='del?id="+id+"'>删除</a></td></tr>");
			}
			out.println("</table>");
			out.println("<p><a href='addUser.html'>添加用户</a></p>");
	
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙，稍后重试");
		}
		
	}
}
