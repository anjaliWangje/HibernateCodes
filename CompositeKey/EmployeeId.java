package CompositeKey;


    import jakarta.persistence.Embeddable;

    import java.io.Serializable;

@Embeddable
    public class EmployeeId implements Serializable {
        private int id;
        private String department;


        public EmployeeId() {}

        public EmployeeId(int id, String department) {
            this.id = id;
            this.department = department;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDepartment() {

            return department;
        }

        public void setDepartment(String department) {

            this.department = department;
        }

        @Override
        public int hashCode() {
            return (id + department).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            EmployeeId other = (EmployeeId) obj;
            return id == other.id && department.equals(other.department);
        }
    }


