package com.rohit;
import java.sql.*;
public class TestJdbc {

	public static void main(String[] args) {
		try
		{
		Class.forName("oracle.jdbc.OracleDriver");
		//Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:cogent","rohitp","Cogent123");
		//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cogent","root","");
		Statement st=con.createStatement();
		st.execute("create table jan(eno number(5),ename varchar2(80),esal number(8,2))");
		st.execute("insert into jan values(1,'Rohit',40000.00)");
		st.execute("insert into jan values(2,'Pawan',35000.00)");
		st.execute("insert into jan values(3,'Tian',30000.00)");
		st.execute("insert into jan values(4,'Saran',25000.00)");
		st.execute("insert into jan values(5,'ABC',10000.00)");
		st.execute("update jan set esal=45000.00 where eno=1");
		st.execute("delete from jan where eno=5");
		ResultSet rs=st.executeQuery("select * from jan");
		while(rs.next())
		{
			System.out.println("Eno"+rs.getInt("eno"));
			System.out.println("Ename"+rs.getString(2));
			System.out.println("Esal"+rs.getInt("esal"));
		}
		con.close();
		st.close();
		rs.close();
	}catch(Exception e){
		e.printStackTrace();
	}
}
}