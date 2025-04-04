package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao dep = DaoFactory.createDepartmentDao();
		
		Scanner sc = new Scanner(System.in);
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
