package com.binde.core.jdbc;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClients {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String yn;
		
		do {
			ApplicationContext context = new ClassPathXmlApplicationContext("TestCfg.xml");
			StudentDea std = (StudentDea) context.getBean("studentDea");

			
			Scanner sc = new Scanner(System.in);

			System.out.println("INSERT   UPDATE   DELETE   FIND  FIND ALL");
			String str = sc.nextLine();

			switch (str) {

			case "INSERT":
				Student student = new Student();
				System.out.println("ENTER THE STUDENT ID:");
				Integer num = sc.nextInt();
				System.out.println("ENTER THE STUDENT NAME:");
				String name = sc.next();
				System.out.println("ENTER THE STUDENT CITY:");
				String citis = sc.next();

				student.setId(num);
				student.setName(name);
				student.setCity(citis);

				Integer nums = std.addRecord(student);
				if (nums != 0)
					System.out.println("INSERT DATA INTO TABLE");
				else
					System.out.println("IT IS NOT INSERT DATA INTO TABLE");
				break;
			case "UPDATE":
				Student student1 = new Student();
				System.out.println("ENTER THE STUDENT ID:");
				Integer num1 = sc.nextInt();
				System.out.println("ENTER THE STUDENT NAME:");
				String name1 = sc.next();
				System.out.println("ENTER THE STUDENT CITY:");
				String citis1 = sc.next();

				student1.setId(num1);
				student1.setName(name1);
				student1.setCity(citis1);

				Integer rs = std.updateRecord(student1);
				if (rs != 0)
					System.out.println("UPDATED RECORD TABLE ROW:" + rs);
				else
					System.out.println("IS NOT UPDATE TABLE ROW");
				break;

			case "DELETE":
				Student student2 = new Student();
				System.out.println("ENTER THE STUDENT ID:");
				Integer num2 = sc.nextInt();
				student2.setId(num2);

				Integer rs1 = std.deleteRecord(student2);
				if (rs1 != 0)
					System.out.println("DELETE ROW IN THE TABLE:" + rs1);
				else
					System.out.println("DOES NOT DELETE ROW IN THE TABLE");
				break;
			case "FIND":
				System.out.println("FIND STUDENT SINGLE DETAILS:");
				System.out.println("ENTER THE STUDENT ID:");
				Integer n = sc.nextInt();
				try {
					Student st = std.getStudent(n);
					System.out.println(st);
				} catch (org.springframework.dao.EmptyResultDataAccessException e) {
					System.out.println("STUDENT ID CAN NOT MATCH DATABASE TRY AGAIN ");
				}
				break;
				
			case "FINDALL":
				System.out.println("ALL STUDENT DEATILS..");
				List<Student> studentS=std.getAllStudent();
				Iterator<Student> i=studentS.iterator();
				while(i.hasNext()==true)
				{
					Student nameS=i.next();
					System.out.println(nameS);
				}

			}
			System.out.println("DO YOU WANT TO CONTINUE PRESS Y AND y");
			yn=sc.next();


		}while(yn.equals("Y")||yn.equals("y"));
		}

}
