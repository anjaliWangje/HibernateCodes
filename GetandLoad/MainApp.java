package GetandLoad;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

    public class MainApp {
        public static void main(String[] args) {
            SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .buildSessionFactory();

            Session session = factory.getCurrentSession();

            Transaction transaction = session.beginTransaction();

            int employeeId = 1;

            Employee employee = session.get(Employee.class, employeeId);

            if (employee != null) {
                System.out.println("Employee: " + employee.getName());
            } else {
                System.out.println("Employee not found.");
            }

            transaction.commit();

            session.close();
            factory.close();
        }
    }

