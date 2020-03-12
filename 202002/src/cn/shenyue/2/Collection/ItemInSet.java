import java.util.*;

public class ItemInSet implements Comparable<ItemInSet> {
    private String description;
    private int partNumber;

    public ItemInSet(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ItemInSet{" +
                "description='" + description + '\'' +
                ", partNumber=" + partNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemInSet itemInSet = (ItemInSet) o;
        return partNumber == itemInSet.partNumber &&
                Objects.equals(description, itemInSet.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    @Override
    public int compareTo(ItemInSet other) {
        int diff = Integer.compare(partNumber, other.partNumber);
        return diff != 0 ? diff : description.compareTo(other.description);
    }
}
