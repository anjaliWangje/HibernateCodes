package GetandLoad;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class maindemo {


        public static void main(String[] args) {
            SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .buildSessionFactory();
            Session session = factory.getCurrentSession();
            Transaction transaction = session.beginTransaction();
            int employeeId = 1;
            Employee employee = session.load(Employee.class, employeeId);
            System.out.println("Employee: " + employee.getName());
            transaction.commit();
            session.close();
            factory.close();
        }
    }

