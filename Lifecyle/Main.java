package Lifecyle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
    public class Main {
        static SessionFactory sessionFactory;

        static {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Company.class)
                    .buildSessionFactory();
        }

        public static Session getSession() {
            return sessionFactory.getCurrentSession();
        }
    }


