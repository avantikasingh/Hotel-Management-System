package com.cg.hotelmanagement.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MyApp {
		public static void userAdmin() {
			System.out.println("1 for User");
			System.out.println("2 for Admin");
			System.out.println("3 for Exit");
			
		}
		public static void printUserAction() {
			System.out.println("1 for make Booking");
			System.out.println("2 for view Booking");
			
		}	
		public static void printAdminAction() {
			System.out.println("1 for Add Hotel");
			System.out.println("2 for Remove Hotel");
			System.out.println("3 for Update Hotel");
			System.out.println("4 for Add Room");
			System.out.println("5 for Remove Room");
			System.out.println("6 for Update Room");
			System.out.println("7 for Approve Room");
			
		}
		public static void main(String[] args) throws ParseException {
			int choice;
			Scanner sc = new Scanner(System.in);
			do {
			
//			List<Employee<Integer, Double>> myList = new LinkedList<Employee<Integer, Double>>();
//			EmployeeServiceImpl service = new EmployeeServiceImpl();
			userAdmin();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Your Name");
				String name = sc.next();
				System.out.println("Enter Your User Name");
				String userName = sc.next();
				System.out.println("Enter Your emailId");
				String emailId = sc.next();
				System.out.println("Enter Your Phone Number");
				String phoneNumber = sc.next();
				System.out.println("Enter Your Date of Birth in dd-mm-yyyy format");
				String dob = sc.next();
				SimpleDateFormat format=new SimpleDateFormat("dd-mm-yyyy");
				Date DOB =format.parse(dob);
				printUserAction();
				int ch = sc.nextInt();
				switch (ch) {
				case 1:
//					make booking
					
					break;
				case 2:
//					view booking
					
					break;

				default:
					break;
				}
				
				break;
			case 2:
				printAdminAction();
				System.out.println("1 for Add Hotel");
				System.out.println("2 for Remove Hotel");
				System.out.println("3 for Update Hotel");
				System.out.println("4 for Add Room");
				System.out.println("5 for Remove Room");
				System.out.println("6 for Update Room");
				System.out.println("7 for Approve Room");
				int adminChoice = sc.nextInt();
				switch (adminChoice) {
				case 1:
					//addHotel()
					break;
				case 2:
					//removeHotel()
					break;
				case 3:
					//removeHotel()
					break;
				case 4:
					//addRoom()
					break;
				case 5:
					//removeRoom()
					break;
				case 6:
					//removeRoom()
					break;
				case 7:
					//approveBooking()
					break;
				
				default:
					break;
				}

				break;

			default:
				break;
			}
			} while(choice != 3);
//			do {
////				double start_time = Timer
//				printDetail();
//				choice = sc.nextInt();
//				switch (choice) {
//				case 1:
//				Employee<Integer, Double> emp = new Employee<Integer, Double>();
//				emp.setEmpId(id);
//				emp.setEmpName(name);
//				emp.setEmpSalary(sal);
//				service.addEmployee(emp);
//					break;
//				case 2:
//					List<Employee<Integer, Double>> myList = service.showEmployee();
//					Collections.sort(myList, new Employee<Integer, Double>());
//					Collections.sort(myList, new comparatorSal());
//					for (Employee<Integer, Double> employee : myList) {
//						System.out.println("ID"+employee.getEmpId());
//						System.out.println("Name"+employee.getEmpName());
//						System.out.println("Salary"+employee.getEmpSalary());
//					}
//					break;
//				}
//			} while (choice !=3);
			sc.close();
			
			

			
			
			

		

	}

	

}
