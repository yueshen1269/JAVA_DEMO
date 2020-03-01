/**
 *  成员变量会被自动赋值
 *  测试用例
 */
public class DefaultValue {
    int a;
    char b;
    short c;
    long d;
    boolean f;
    float g;
    double h;
    String i;
    Object j;
    int[] ints;

    public void printDefaultValue() {
        System.out.println("Java各数据类型的初始值如下\n" +
                "Int:" + a + "\n" +
                "Short:" + c + "\n" +
                "Long:" + d + "\n" +
                "Boolean:" + f + "\n" +
                "Float:" + g + "\n" +
                "Double:" + h + "\n" +
                "Char:" + b + "\n" +
                "String:" + i + "\n" +
                "Object:" + j + "\n" +
                "Array:" + ints + "\n"
        );
    }
}

