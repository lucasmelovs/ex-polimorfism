package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourceEmployee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List <Employee> employees = new ArrayList<>();
		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i=1 ; i<=n ; i++) {
			
			System.out.println("Employee #" + i + " data:");
			System.out.print("Outsourced (y/n)?" );
			char response = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			sc.nextLine();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			if(response == 'n') {
				employees.add(new Employee(name, hours, valuePerHour));
			}else {
				System.out.print("Additional charge: ");
				double additionalCharge = sc.nextDouble();
				employees.add(new OutsourceEmployee(name, hours, valuePerHour, additionalCharge));
			}
			
			System.out.println("PAYMENTS:");
			for(Employee c : employees) {
				System.out.println(c.getName() + " - $" + c.payment());
			}
			
		}
		
		sc.close();
	}

}
