package curdOperation1;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
    public class EmployeeCrud {
        @Id
        private  int id;
        private  String name;
        private  double salary;

        public EmployeeCrud() {
        }

        public EmployeeCrud(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "EmployeeCrud{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

