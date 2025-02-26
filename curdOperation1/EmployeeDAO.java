package curdOperation1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.List;

    public class EmployeeDAO {

        private static SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeCrud.class)
                .buildSessionFactory();

        // Create
        public static void saveEmployee(EmployeeCrud employeeCrud) {
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save(employeeCrud);

            transaction.commit();
            session.close();
        }

        // Read
        public static EmployeeCrud getEmployee(int id) {
            Session session = factory.openSession();
            EmployeeCrud employeeCrud = session.get(EmployeeCrud.class, id);
            session.close();
            return employeeCrud;
        }

        // Read
        public static List<EmployeeCrud> getAllEmployee() {
            Session session = factory.openSession();
            List<EmployeeCrud> employeeCrudList = session.createQuery("from EmployeeCrud", EmployeeCrud.class).list();
            session.close();
            return employeeCrudList;
        }

        // Update
        public static void updateEmployee(int id) {
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            EmployeeCrud employeeCrud = session.get(EmployeeCrud.class, id);
            if (employeeCrud != null) {
                employeeCrud.setName("Updated Name");
                employeeCrud.setSalary(2500000);
                session.update(employeeCrud);
            }

            transaction.commit();
            session.close();
        }

        // Delete
        public static boolean deleteEmployee(int id) {
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            EmployeeCrud employeeCrud = session.get(EmployeeCrud.class, id);
            if (employeeCrud != null) {
                session.delete(employeeCrud);
                transaction.commit();
                session.close();
                return true;
            }
            session.close();
            return false;
        }
    }


