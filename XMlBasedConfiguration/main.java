package XMlBasedConfiguration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class main {
    public static void main(String[] args){
        System.out.println("hello");

        Configuration configuration=new Configuration();

        SessionFactory sessionFactory =configuration.configure("hibernateXMLBased.cfg.xml").buildSessionFactory();

        Session session =sessionFactory.openSession();

        Company company=new Company();
        company.setCompanyName("hibernate");
        company.setAddress("mumbai");
        company.setNoEmployee(200);

        Employee employee=new Employee();
        employee.setEmpName("anjali");
        employee.setAddress("pune");

        Transaction transaction =session.beginTransaction();
        session.save(company);
        session.save(employee);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

}

