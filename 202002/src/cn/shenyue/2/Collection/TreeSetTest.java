import java.util.*;

public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<ItemInSet> parts = new TreeSet<>();
        parts.add(new ItemInSet("Toaster", 1234));
        parts.add(new ItemInSet("Widget", 4562));
        parts.add(new ItemInSet("Modem", 9912));
        System.out.println(parts);

        NavigableSet<ItemInSet> sortByDescription = new TreeSet<>(
                Comparator.comparing(ItemInSet::getDescription)
        );
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
