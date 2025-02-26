package curdOperation;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

    public class StudentCRUDExample {

        // Create SessionFactory
        private static SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        public static void main(String[] args) {

            createStudent();
            readStudent(1);
            updateStudent(1);
            deleteStudent(1);


            factory.close();
        }

        // CREATE
        public static void createStudent() {

            Session session = factory.openSession();
            session.beginTransaction();
            Student student = new Student(1, "Anjali wangje");
            session.save(student);
            session.getTransaction().commit();
            session.close();
            System.out.println("Student created successfully!");
        }

        // READ
        public static void readStudent(int studentId) {

            Session session = factory.openSession();
            session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            session.getTransaction().commit();
            session.close();
            if (student != null) {
                System.out.println("Student found: " + student);
            } else {
                System.out.println("No student found with ID: " + studentId);
            }
        }

        // UPDATE
        public static void updateStudent(int studentId) {
            Session session = factory.openSession();
            session.beginTransaction();
            Student student = session.get(Student.class, studentId);

            if (student != null) {
                student.setName("Pranali wangje");
                session.getTransaction().commit();

                System.out.println("Student updated: " + student);
            }
            session.close();
        }

        // DELETE
        public static void deleteStudent(int studentId) {

            Session session = factory.openSession();
            session.beginTransaction();
            Student student = session.get(Student.class, studentId);

            if (student != null) {

                session.delete(student);

                System.out.println("Student deleted: " + student);
            } else {
                System.out.println("No student found with ID: " + studentId);
            }
            session.getTransaction().commit();
            session.close();
        }
    }


