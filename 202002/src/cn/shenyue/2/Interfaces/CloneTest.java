public class CloneTest {
    public static void main(String[] args) {
        try {
            EmployeeClone original = new EmployeeClone("John Q", 50000);
            original.setHireDay(2000, 1, 1);
            EmployeeClone copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2002, 12, 31);
            System.out.println("original =" + original);
            System.out.println("copy =" + copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
