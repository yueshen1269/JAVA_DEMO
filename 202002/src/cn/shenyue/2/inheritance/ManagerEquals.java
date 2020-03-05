public class ManagerEquals extends  EmployeeEquals {
    private double bonus;

    public ManagerEquals(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public boolean equals(Object otherObject) {
        if(!super.equals(otherObject)) return false;
        ManagerEquals other = (ManagerEquals) otherObject;
        return bonus == other.bonus;
    }

    public int hashCode() {
        return super.hashCode() + 17 * Double.hashCode(bonus);
    }

    public String toString() {
        return super.toString() + "[bonus=" + bonus + "]";
    }
}
