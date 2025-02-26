package Lifecyle;

import org.hibernate.Session;

import static Lifecyle.Main.sessionFactory;

    public class hibernatelifecycle {

        public static void main(String[] args) {
            Session session = sessionFactory.openSession();
   //Transient state
            Company company = new Company("TCS", "pune");
            System.out.println("Company in Transient State: " + company);
            //Persistent state
            session.beginTransaction();
            System.out.println("saving the company");
            session.save(company);
            session.getTransaction().commit();
            System.out.println("Company in Persistent State: " + company);
//Detached state
            session = Main.getSession();
            session.beginTransaction();

            Company fetchedCompany = session.get(Company.class, company.getId());
            session.getTransaction().commit();
            session.close();
           System.out.println("Company in detached state: " + fetchedCompany);
//removed state
            session = Main.getSession();
            session.beginTransaction();
            session.delete(fetchedCompany);
            System.out.println("Company in removed state: " + fetchedCompany);

            session.close();
        }
    }





