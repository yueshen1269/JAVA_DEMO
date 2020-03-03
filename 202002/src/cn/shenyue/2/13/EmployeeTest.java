import java.time.*;
import java.util.Random;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] Staff = new Employee[3];

        Staff[0] = new Employee("Carl Craker", 75000, 1987, 12, 15);
        Staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        Staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        for(Employee e: Staff)
            e.raiseSalary(5);

        for(Employee e: Staff) {
            e.setId();
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ", hireDay="
                    + e.getHireDay());
        }
        int n = Employee.getNextId();
        System.out.println("Next available id=" + n);
    }
}

class Employee {
    private static int nextId = 1;

    private int id;
    private String name = ""; // 实例域初始化
    private double salary;
    private LocalDate hireDay;

    // 静态初始化块
    static {
        Random generator = new Random();
        nextId = generator.nextInt(10000);
    }

    // 对象初始化块
    {
        id = nextId;
        nextId++;
    }

    public Employee(String n, double s) {
        name = n;
        salary =s;
    }

    public  Employee(double s) {
        // 构造器调用
        this("Employee #" + nextId, s);
    }

    // 默认初始化
    public Employee() {

    }

    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
        id = 0;
    }

    public static int getNextId() {
        return nextId;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        id = nextId;
        nextId++;
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

    public void raiseSalary(double byPerent) {
        double raise = salary * byPerent / 100;
        salary += raise;
    }

    public boolean equals(Employee other) {
        return name.equals(other.name);
    }



}