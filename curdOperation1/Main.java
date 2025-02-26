package curdOperation1;

import java.util.List;

        public class Main {
            public static void main(String[] args) {
                // Create employees
                EmployeeDAO.saveEmployee(new EmployeeCrud(1, "Anjali wangje", 80000));
                EmployeeDAO.saveEmployee(new EmployeeCrud(2, "Aboli wangje", 120000));

                // Read
                EmployeeCrud employeeCrud = EmployeeDAO.getEmployee(2);
                System.out.println("Get Employee: " + employeeCrud);

                // Read
                List<EmployeeCrud> employeeCruds = EmployeeDAO.getAllEmployee();
                System.out.println("All Employees: " + employeeCruds);

                // Update
                EmployeeDAO.updateEmployee(2);
                System.out.println("Updated Employee: " + EmployeeDAO.getEmployee(2));

                // Delete
                boolean isDeleted = EmployeeDAO.deleteEmployee(1);
                if (isDeleted) {
                    System.out.println("Employee with ID 1 deleted successfully.");
                } else {
                    System.out.println("Employee with ID 1 not found.");
                }

                List<EmployeeCrud> remainingEmployees = EmployeeDAO.getAllEmployee();
                System.out.println("Remaining Employees: " + remainingEmployees);
            }
        }
