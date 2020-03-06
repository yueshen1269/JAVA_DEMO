public class EmployeeInterface implements Comparable<EmployeeInterface> {
    private String name;
    private double salary;

    public EmployeeInterface(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public int compareTo(EmployeeInterface other) {
        return Double.compare(salary, other.salary);
    }
}
