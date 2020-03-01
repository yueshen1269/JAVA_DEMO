public class IsNaN {
    public static void main(String[] args) {
        System.out.println(verifyByEquals(10)); // false
        System.out.println(verifyByEquals(Double.NaN)); // false

        System.out.println(verifyByFun(10)); // false
        System.out.println(verifyByFun(Double.NaN)); // true
        System.out.println(Double.isNaN(0.0D/0)); // true
    }

    public static boolean verifyByEquals(double num) {
        return num == Double.NaN;
    }

    public static boolean verifyByFun(double num) {
        return Double.isNaN(num);
    }
}
