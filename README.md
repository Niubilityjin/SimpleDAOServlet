# SimpleDAOServlet
 基于Tomcat的一个增删用户信息的项目
 
在这个项目中AddUser从浏览器get到输入的三个信息,经过User类变成user对象传入Dao,在Dao中将Adduer的具体实现方法进行了方法的封装,将user对象中的属性get出来通过建立Mysql计划,将各个属性值传入sql语句中并运行,以达到存储客户信息的功能.
 
 
 
 
ListUser 实现了展示所有用户信息的功能,在DAO中封装了方法可以从数据库中读出用户信息并封装成User对象,存入集合users中,再在ListServlet中循环各个用户的各个属性并输出到页面中
 
 
 
 
 
Del实现了删除用户信息功能,方法是取得被点击的用户id,传入mysql语句中,并删除
 
 
 
 
 
 
实现了可以在添加用户后重定向到用户列表的功能,也可以从用户列表重定向到添加用户页面,但是此功能存在一定BUG,有时候会无法跳转,还没查出来原因(->=)!
