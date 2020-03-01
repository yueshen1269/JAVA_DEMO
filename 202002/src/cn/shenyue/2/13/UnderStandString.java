public class UnderStandString {
    public static void main(String[] args) {
        api();
    }

    public static void api() {
        String test = "My name in yueshen1269!";

        System.out.println("test:" + test);
        System.out.println("length():" + test.length());
        System.out.println("codePintCount():" + test.codePointCount(0, test.length()));
        System.out.println("charAt():" + test.charAt(4));
        System.out.println("codePointAt():" + test.codePointAt(4));
        System.out.println("offsetByCodePoints():" + test.offsetByCodePoints(0, 4));
        System.out.println("codePoints():" + test.codePoints());
        System.out.println("codePoints().toArray():" + test.codePoints().toArray());

    }
}
