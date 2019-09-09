package com.cg.hotelmanagement.ui;

public class MyApp {



	//Difference between array and arraylist and vector
	//Difference between array list and linked list 
	// how when and what to use

		
		public static void main(String[] args) {
			int choice;
//			List<Employee<Integer, Double>> myList = new LinkedList<Employee<Integer, Double>>();
			EmployeeServiceImpl service = new EmployeeServiceImpl();
			Scanner sc = new Scanner(System.in);
			do {
//				double start_time = Timer
				printDetail();
				choice = sc.nextInt();
				switch (choice) {
				case 1:
				System.out.println("Enter the id");
				Integer id = sc.nextInt();
				System.out.println("Enter the name");
				String name = sc.next();
				System.out.println("Enter the salary");
				Double sal = sc.nextDouble();
				Employee<Integer, Double> emp = new Employee<Integer, Double>();
				emp.setEmpId(id);
				emp.setEmpName(name);
				emp.setEmpSalary(sal);
				service.addEmployee(emp);
				
		
					
					break;

				case 2:
					List<Employee<Integer, Double>> myList = service.showEmployee();
					Collections.sort(myList, new Employee<Integer, Double>());
					Collections.sort(myList, new comparatorSal());
					for (Employee<Integer, Double> employee : myList) {
						System.out.println("ID"+employee.getEmpId());
						System.out.println("Name"+employee.getEmpName());
						System.out.println("Salary"+employee.getEmpSalary());
					}
					break;
					
				}
			} while (choice !=3);
			sc.close();
			
			

			
			
			

		

	}

	

}
