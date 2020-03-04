import java.time.LocalDate;

public class EmployeeAbs extends Person {
    private double salary;
    private LocalDate hireDay;

    public EmployeeAbs(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        hireDay = LocalDate.of(year,month,day);
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public String getDescription() {
        return String.format("an employee with a salary of $%.2f", salary);
    }

    public void raiseSalry(double byPercent) {
        double raise =  salary * byPercent /100;
        salary += raise;
    }
}
