package Lifecyle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Company.class).buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static Session getSession() {
        return sessionFactory.getCurrentSession();

    }
}

