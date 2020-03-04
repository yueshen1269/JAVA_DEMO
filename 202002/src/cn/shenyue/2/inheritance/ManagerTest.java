public class ManagerTest {
    public static void main(String[] args) {
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        Employee1[] staff = new Employee1[3];

        staff[0] = boss;
        staff[1] = new Employee1("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee1("Tommy Tester", 40000, 1990, 3, 15);

        for(Employee1 e: staff)
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary());
    }
}
