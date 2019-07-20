package cn.hnuc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test_02 {

		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			//调用方法
			//连接数据库
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.通过驱动管理器获得连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oa", "root", "ab125936");
			//测试连接是否成功
			//System.out.println(conn);
			//操作数据表
			
			//3.准备sql语句
			//String sql="insert into xueyuan(xyname,com) value('计算机院','专门学Java的优秀学生！')";
			String sql="select * from xueyuan";
			//4.获取预处理指令对象
			Statement stat=conn.createStatement();
			//5.执行sql语句
			/*boolean flag=stat.execute(sql);//false
			System.out.println(flag);*/
			//执行查询
			ResultSet rs=stat.executeQuery(sql);
			//循环拿到数据
			while(rs.next()){
				int xyno=rs.getInt("xyno");
				String xyname=rs.getString(2);
				String com=rs.getString(3);
				System.out.println("查询结果：学院编号："+xyno+",院名"+xyname+",院简介："+com);
			}
			
			//6.关闭资源（先开后关）
			stat.close();
			conn.close();
			
			
		}


}
