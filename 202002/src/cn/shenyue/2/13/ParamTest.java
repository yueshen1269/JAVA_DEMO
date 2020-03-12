public class ParamTest {
    public static void main(String[] args) {
        /**
         * Test1: Methods can't modify parameters
         */
        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before: percent=" + percent);
        tripleValue(percent);
        System.out.println("After: percent=" + percent);

        /**
         * Test2: Methods can change the state of object parameters
         */
        System.out.println("\nTesting tripleSalary:");
        Employee1 harry = new Employee1("Harry", 5000, 1999, 12, 1);
        System.out.println("Before salary=" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary=" + harry.getSalary());

        /**
         * Test 3: Methods can't attach new objects to object parameters
         */
        System.out.println("\nTesting swap:");
        Employee1 a = new Employee1("Alice", 70000, 2020, 1,1);
        Employee1 b = new Employee1("Bob", 60000, 2012,2,1);
        System.out.println("Before a:" + a.getName());
        System.out.println("Before b:" + b.getName());
        swap(a, b);
        System.out.println("After a:" + a.getName());
        System.out.println("After b:" + b.getName());
    }

    public static void tripleValue(double x) {
        x *= 3;
        System.out.println("End of method: x=" + x);
    }

    public static void tripleSalary(Employee1 x) {
        x.raiseSalary(200);
        System.out.println("End of method: salary=" + x.getSalary());
    }

    public static void swap(Employee1 x, Employee1 y) {
        Employee1 temp = x;
        x = y;
        y = temp;
        System.out.println("End of method: x=" + x.getName());
        System.out.println("End of method: y=" + y.getName());
    }
}
