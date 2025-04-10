package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao dep = DaoFactory.createDepartmentDao();
		System.out.println("________TEST DEPARTMENT.UPDATE________");
		Department department = dep.findById(5);
		department.setName("Brazucas");
		dep.update(department);
		System.out.println("Update completed");
		System.out.println("________TEST DEPARTMENT.FINDBYID________");
		department = dep.findById(5);
		System.out.println("Founded department: " + department);
		
		System.out.println("________TEST DEPARTMENT.FINDALL________");
		for(Department dept: dep.findAll()) {
			System.out.println(dept);
		}
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("________TEST DEPARTMENT.DELETE________");
		System.out.println("Department delete test, enter the department id: ");
		int deptodelete = sc.nextInt();
		dep.deleteById(deptodelete);
		
		
		
		System.out.println("________TEST DEPARTMENT.INSERT________");
		System.out.println("Department insert test, enter the department id: ");
		int depId = sc.nextInt();
		System.out.println("Enter department name: ");
		String depName = sc.next();
		sc.nextLine();
		dep.insert(new Department(depId, depName));
		
		sc.close();
	}

}
