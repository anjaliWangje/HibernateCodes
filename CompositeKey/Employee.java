package CompositeKey;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
    public class Employee {

        @EmbeddedId
        private EmployeeId employeeId;

        private String name;


        public Employee() {}

        public Employee(EmployeeId employeeId, String name) {
            this.employeeId = employeeId;
            this.name = name;
        }


        public EmployeeId getEmployeeId() {

            return employeeId;
        }

        public void setEmployeeId(EmployeeId employeeId) {
            this.employeeId = employeeId;
        }

        public String getName() {



            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                '}';
    }
}



