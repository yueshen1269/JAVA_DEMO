import java.time.*;
import java.util.Objects;

public class Employee1 {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee1(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent /100;
        salary += raise;
    }

    public boolean equals(Object otherObject) {
        if(this == otherObject) return true;
        if(otherObject == null) return false;
        if(getClass() != otherObject.getClass()) return false;
        Employee1 other = (Employee1) otherObject;

        return Objects.equals(name, other.name)
                && salary == other.salary
                && Objects.equals(hireDay, other.hireDay);
    }

    @Override
    public String toString() {
        return getClass() + "{" +
                "name='" + name + '\'' +
                '}';
    }
}
