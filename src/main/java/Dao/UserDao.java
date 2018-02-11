package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import User.User;
import Web.DBUtils;

public class UserDao {
	public static void save(User user){
		if(user==null){
			throw new RuntimeException();
		}
		Connection conn=null;
		String dml="insert into t_user values(null,?,?,?)";
		
		String uname=user.getUname();
		String pwd=user.getPwd();
		String phone=user.getPhone();
			int n;
			try {
				conn=DBUtils.getConnection();
				PreparedStatement ps=conn.prepareStatement(dml);
				ps.setString(1, uname);
				ps.setString(2, pwd);
				ps.setString(3, phone);
				n = ps.executeUpdate();
				System.out.println("++++"+n);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally{
				DBUtils.closeConnection(conn);
			}
			
			
			
	}
	/*
	 * 查询出所有员工的信息
	 */
	public List<User> findAll(){
		List<User> users=new ArrayList<User>();
		Connection conn=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select*from t_user";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String uname=rs.getString("username");
				String pwd=rs.getString("password");
				String phone=rs.getString("phone");
				//将记录中的数据添加到对应的实体对象里面
				User user=new User();
				user.setId(id);
				user.setUname(uname);
				user.setPwd(pwd);
				user.setPhone(phone);
				users.add(user);
			}
		} catch (Exception e) {
			//记日志 保留现场
			e.printStackTrace();
			/*
			 * 看异常能否恢复, 如果不能恢复(发生了系统异常,比如数据库服务停止了),则提示用户稍后重试.如果能回复,则立即恢复.
			 */
			throw new RuntimeException(e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return users;
	}
	public void delete(int id){
		Connection conn=null;
		try {
			conn=DBUtils.getConnection();
			String sql="delete from t_user where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtils.closeConnection(conn);
		}
	}
}
