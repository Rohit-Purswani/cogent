package com.rohit;
import java.sql.*;
import java.awt.*;

import java.awt.event.*;
import java.util.*;
public class Operation extends Frame implements ActionListener{
		TextField tf1=new TextField(10);
		TextField tf2=new TextField(10);
		TextField tf3=new TextField(10);
		TextField tf4=new TextField(10);
		Button b1=new Button(">");
		Button b2=new Button("<");
		Button b3=new Button("|<");
		Button b4=new Button(">|");
		Button b5=new Button("add");
		Button b6=new Button("update");
		Button b7=new Button("delete");
		Button b8=new Button("list");
		java.awt.List l1=new java.awt.List();
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		public Operation(){
		try{
		setLayout(new FlowLayout());
		Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:cogent","rohitp","Cogent123");
		st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		ResultSet.CONCUR_READ_ONLY);
		rs=st.executeQuery("select * from JAN");
		}catch(Exception ex){}
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(l1);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){System.exit(0);}});

		}



		    public void actionPerformed(ActionEvent e1){
		    try{ 
		    if(e1.getSource()==b1){
		    rs.next();
		    if(rs.isAfterLast())
		    rs.first();
		    call();
		    }


		    else if(e1.getSource()==b2){
		    rs.previous();
		    if(rs.isBeforeFirst())
		    rs.last();
		    call();
		    }

		    else if(e1.getSource()==b3){
		    rs.first();
		    call();
		    }

		    else if(e1.getSource()==b4){
		    rs.last();
		    call();
		    }
		    else if(e1.getSource()==b5){
		    	String e=tf1.getText();
		    	int eno=Integer.parseInt(e);
		    	String ename=tf2.getText();
		    	String a=tf3.getText();
		    	double esal=Double.parseDouble(a);
		    	System.out.println("b4 insert");
		    	String addvalues = "INSERT INTO JAN"
						+ "(ENO, ENAME, ESAL) VALUES"
						+ "(?,?,?)";
		    	PreparedStatement pst= con.prepareStatement(addvalues);
		    	pst.setInt(1, eno);
		    	pst.setString(2, ename);
		    	pst.setDouble(3, esal);
		    	pst.executeUpdate();
		    	System.out.println("after insert");
		    }
		    else if(e1.getSource()==b8){
		    Select1();
		    }
		    else if(e1.getSource()==b7){
		    	tf4.getText();
		    }
		    
		    }
		    catch(Exception eeee){}
		}
		    public void call(){
		    try{
		    tf1.setText(""+rs.getInt(1));
		    tf2.setText(""+rs.getString(2));
		    tf3.setText(""+rs.getDouble(3));
		     }catch(Exception cc){System.out.println(cc);}
		    }

		     public void Select1() 
		     {
		    	 try
		    	 {
		    	 rs = st.executeQuery("select * from JAN");
		    	 
		    	    while (rs.next()){ 
		    	    	ArrayList<String> s=new ArrayList<String>();
		    	    	int no=rs.getInt(1);
		    	    	s.add(String.valueOf(no));
		    	    	String name=rs.getString(2);
		    	    	s.add(name);
		    	    	int sal=rs.getInt(3);
		    	    	s.add(String.valueOf(sal));
		    	    	String a=s.toString();
		    	    	l1.add(a);
		    	}}catch(Exception e){
		    		System.out.println(e);
		    	}		     }

		public static void main(String args[]){
		Operation pp=new Operation();
		pp.setSize(400,400);
		pp.setVisible(true);
		}
		
	}


