import java.util.Arrays;

public class EmployeeSortTest {
    public static void main(String[] args) {
        EmployeeInterface[] staff = new EmployeeInterface[3];

        staff[0] = new EmployeeInterface("Harry", 35000);
        staff[1] = new EmployeeInterface("Carl", 75000);
        staff[2] = new EmployeeInterface("Tony", 38000);

        Arrays.sort(staff);

        for(EmployeeInterface e: staff)
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary());
    }
}
