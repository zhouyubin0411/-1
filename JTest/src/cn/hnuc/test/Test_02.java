package cn.hnuc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test_02 {

		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			//���÷���
			//�������ݿ�
			//1.��������
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.ͨ�������������������
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oa", "root", "ab125936");
			//���������Ƿ�ɹ�
			//System.out.println(conn);
			//�������ݱ�
			
			//3.׼��sql���
			//String sql="insert into xueyuan(xyname,com) value('�����Ժ','ר��ѧJava������ѧ����')";
			String sql="select * from xueyuan";
			//4.��ȡԤ����ָ�����
			Statement stat=conn.createStatement();
			//5.ִ��sql���
			/*boolean flag=stat.execute(sql);//false
			System.out.println(flag);*/
			//ִ�в�ѯ
			ResultSet rs=stat.executeQuery(sql);
			//ѭ���õ�����
			while(rs.next()){
				int xyno=rs.getInt("xyno");
				String xyname=rs.getString(2);
				String com=rs.getString(3);
				System.out.println("��ѯ�����ѧԺ��ţ�"+xyno+",Ժ��"+xyname+",Ժ��飺"+com);
			}
			
			//6.�ر���Դ���ȿ���أ�
			stat.close();
			conn.close();
			
			
		}


}
