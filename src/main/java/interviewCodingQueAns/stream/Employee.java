package interviewCodingQueAns.stream;

public class Employee {
    String name;
    String department;
    double salary;
    String gender;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Employee(String name, String department, String gender) {
        this.name = name;
        this.department = department;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                '}';
    }
}
