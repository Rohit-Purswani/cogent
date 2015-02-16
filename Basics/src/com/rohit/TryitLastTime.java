package com.rohit;

import java.sql.*; 
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TryitLastTime extends Frame implements ActionListener{

TextField tf1=new TextField(10);
TextField tf2=new TextField(10);
TextField tf3=new TextField(10);

Button b1=new Button("NEXT");
Button b2=new Button("PREVIOUS");
Button b3=new Button("FIRST");
Button b4=new Button("LAST");
Button b5=new Button("LIST");
Button b6=new Button("DELETE");
Button b7=new Button("UPDATE");
Button b8=new Button("ADD");
Connection con;
Statement st;
ResultSet rs;

public TryitLastTime(){
try{
setLayout(new FlowLayout());
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/cogent","root","3361120");
st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
ResultSet.CONCUR_READ_ONLY);
rs=st.executeQuery("select * from employeeinformation");
}catch(Exception ex){}
add(tf1);
add(tf2);
add(tf3);

add(b1);
add(b2);
add(b3);
add(b4);
add(b5);
add(b6);
add(b7);
add(b8);



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
    
    
    else if(e1.getSource()==b6){
    	
    	
    	JFrame parent = new JFrame();
        JButton button = new JButton();
        JTextArea textarea=new JTextArea();
        button.setText("Delete");
        textarea.setText("111!");
        button.setLocation(200,400);
        textarea.setLocation(400,400);
        parent.add(textarea);
        parent.add(button);
        parent.pack();
        parent.setVisible(true);
        JPanel panel=new JPanel();
        
        
        JTextArea jt= new JTextArea("Enter ENO",5,5);   
        
        parent.add(panel);
        panel.add(jt);
        parent.setSize(1000,1000);
        parent.setVisible(true);
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        parent.pack();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String contents = jt.getText();
                int DeEno =Integer.parseInt(contents);
                System.out.println("Employee No. Selected:"+"   "+DeEno);
       
       
        try {
        	PreparedStatement stmt = con.prepareStatement("DELETE from employeeinformation WHERE ENO = ?");
            stmt.setInt(1, DeEno);
			stmt.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
            }});
        }
  
    
    else if(e1.getSource()==b7){
    	
    	JFrame parent = new JFrame();
        JButton button = new JButton();
        JTextArea textarea=new JTextArea();
        JTextArea textarea1=new JTextArea();
        JTextArea textarea2=new JTextArea();
        button.setText("UPDATE");      
        button.setLocation(200,400);
        textarea.setLocation(400,400);
        textarea1.setLocation(600,400);
        textarea2.setLocation(800,400);
        parent.add(textarea);
        parent.add(textarea);
        parent.add(textarea);
        parent.add(button);
        parent.pack();
        parent.setVisible(true);
        JPanel panel=new JPanel();
        
        
        JTextArea jt= new JTextArea("Enter ENO",5,5);
       
        JTextArea jt1= new JTextArea("Enter NEW ENAME",5,5);
              
        JTextArea jt2= new JTextArea("Enter NEW EMPOLYEESALARY",5,5);
        
        parent.add(panel);
        panel.add(jt);
        panel.add(jt1);
        panel.add(jt2);
        parent.setSize(1000,1000);
        parent.setVisible(true);
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        parent.pack();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String contents = jt.getText();
                int ChosenEno =Integer.parseInt(contents);
                System.out.println("Employee No. Selected:"+"   "+ChosenEno);
                String contents2 = jt1.getText();
                String contents3 = jt2.getText();
                int ChosenSalary =Integer.parseInt(contents3);
                
                
                
                
                
                System.out.println("New Employee Name:"+"   "+contents2);	
                System.out.println("New Employee Salary:"+"   "+contents3);	
       
        try {
        	PreparedStatement stmt = con.prepareStatement("UPDATE employeeinformation SET ENAME=?, EADDRESS=? WHERE ENO=?");
            stmt.setString(1, contents2);
            stmt.setString(2, contents3);
            stmt.setInt(3, ChosenSalary);
            stmt.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
            }});
        }
        

    
    else if(e1.getSource()==b8){
    	
    	
        String a=tf1.getText();
        int NewEno =Integer.parseInt(a);
        String NewName=tf2.getText();
        String b=tf3.getText();
        int NewSal =Integer.parseInt(b);
        
        System.out.println("New Employee No.:"+"   "+NewEno);	
        System.out.println("New Employee Name:"+"   "+NewName);	
        System.out.println("New Employee Salary:"+"   "+NewSal);	
        
        
        PreparedStatement stmt = con.prepareStatement("insert into employeeinformation values (?,?,?)");
        stmt.setInt(1, NewEno);
        stmt.setString(2, NewName);
        stmt.setInt(3, NewSal);
        stmt.executeUpdate();
       
       
           
    }
    }catch(Exception eeee){
    	eeee.printStackTrace();
    	
    	
    }
    	
    }
    
	public void call(){
    try{
    tf1.setText(""+rs.getInt(1));
    tf2.setText(""+rs.getString(2));
    tf3.setText(""+rs.getString(3));
    
     }catch(Exception cc){System.out.println(cc);}
    }

     

public static void main(String args[]){


TryitLastTime pp=new TryitLastTime();
pp.setSize(400,400);
pp.setVisible(true);
}
}



