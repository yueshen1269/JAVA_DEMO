public class ArraryDefaultValue {
    /**
     * 数组初始化： 默认会将数值类型的初始化为0，布尔型的初始化为false,
     *      对象初始化为null
     *
     */
    public static void main(String[] args) {
        int[] a = new int[3];
        for(int i: a) System.out.println(i);
        boolean[] b = new boolean[3];
        for(boolean i: b) System.out.println(i);
        String[] c = new String[3];
        for(String i: c) System.out.println(i);
    }
}
