package cn.hnuc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Test_01 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String sql = "select * from xueyuan";
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oa","root","ab125936");
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(sql);
		while(rs.next()) {
			int xyNo=rs.getInt("xyno");
			String xyName=rs.getString(2);
			String xyCom=rs.getString(3);
			System.out.println("��ѯ�����ѧԺ��ţ�"+xyNo+",ѧԺ���ƣ�"+xyName+",��ע:"+xyCom);
		}
		rs.close();
		ps.close();
		conn.close();
	}
}
