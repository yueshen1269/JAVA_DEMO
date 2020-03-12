import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Employee1> staff = new HashMap<>();
        staff.put("144-25-5464", new Employee1("Amy Lee", 200, 2002,1,2));
        staff.put("567-24-5464", new Employee1("Harry Lee", 300, 2012,1,2));
        staff.put("157-62-5464", new Employee1("Gary Lee", 400, 2022,1,2));
        staff.put("456-62-5464", new Employee1("John Lee", 500, 2032,1,2));

        System.out.println(staff);

        staff.remove("567-24-5464");

        staff.put("456-62-5464", new Employee1("Kobe Lee", 2000, 1967,2,1));

        System.out.println(staff.get("157-62-5464"));

        staff.forEach((k,v) -> System.out.println("key=" + k + " value=" + v));
    }
}
