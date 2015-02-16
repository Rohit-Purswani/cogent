package com.rohit;
import java.awt.*;
import java.awt.event.*;


		public class AWT extends Frame implements ActionListener{

		Label l1,l2;
		TextField t1,t2;
		Button b1,b2;



		AWT(){
		setLayout(new FlowLayout(10,5,5));
				 
		l1=new Label("UserName");
		l2=new Label("Password");
		t1=new TextField(20);
		t2=new TextField(20);
		b1=new Button("submit");
		b2=new Button("RESET");
		add(l1);add(t1);add(l2);add(t2);add(b1);add(b2);


		b1.addActionListener(this);

		b2.addActionListener(this);


		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}});
		}
		public void actionPerformed(ActionEvent e){
			if (e.getSource()==b1){
				t1.setText("Pawan");
				b1.setBackground(Color.RED);
			}
			else if (e.getSource()==b2){
				t2.setText("tian");
				b2.setBackground(Color.CYAN);
			
			}
		}
		public static void main(String args[]){
			AWT a1=new AWT();
			a1.setSize(500,500);
			a1.setVisible(true);
		}
			}


