package CompositeKey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(EmployeeId.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        EmployeeId employeeId = new EmployeeId(1, "IT");
        Employee employee = new Employee(employeeId, "Anjali Wangje");

        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();


        session.close();
        factory.close();
    }
}
