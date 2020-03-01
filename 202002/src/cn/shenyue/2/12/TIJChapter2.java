import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class TIJChapter2 {
    // 类常量，用static final 关键字修饰，可以在类的多个方法中访问
    public static final double CM_PER_INCH = 2.54;
    public static boolean canUp = true;
    public final int month = 30;
    public enum Size {
        EXTRA_LARGE, LARGE, MEDIUM, SMALL
    }
    ;

    public static void main(String[] args) {
        // 测试成员变量的默认值
        DefaultValue dv = new DefaultValue();
        dv.printDefaultValue();
        // 一般不建议使用char类型的值
        char c = '\u1121';
        // 用final关键字来表示常量，常量命名一般全部大写
        final int daysOfWeek = 7;
        System.out.println(c);
        // static静态方法中不能访问非静态作用域的变量
        //System.out.println(month);
        System.out.println("main 方法访问类常量CM_PER_INCH=" + CM_PER_INCH);
        new TIJChapter2().print1();
        new Func(10);
    }

    public void print1() {
        // 成员方法可以访问成员变量
        System.out.println(month);
        // 成员方法也可以访问静态作用域内的常量或变量
        System.out.println(canUp);
        System.out.println("print1 方法访问类常量CM_PER_INCH=" + CM_PER_INCH);
    }

    public void aboutMath() {
        double x = 3.14;
        // 小数默认是double类型的，所以float类型后面要加f，一般不使用float类型
        float y = 0.2f;
        // 平方根
        double sqrtX = Math.sqrt(x);
        // 次方
        double powX = Math.pow(x, 2);
        // 求正的余数
        int position = -8;
        int adjustment = 4;
        int circle = 12;
        int absPos = Math.floorMod(position + adjustment, circle);
    }

    // 自动类型转换
    public void typeInvert() {
        // i所能表示的位数超过了float类型，所以会造成精度缺失
        int i = 123456789;
        float f = i;
        // 两个类型不同的数值进行二元操作时，会将两个数转换为同一个类型
        /**
         * 转换规则：
         * 1. 其中有double类型的，会将另一个数转换为double类型
         * 2. 否则，其中若有float类型的，会将另一个数转换为float类型
         * 3. 否则，其中若有long类型的，会将另一个数转换为long类型
         * 4. 否则，会将两个数转换为int类型
         */
        // float + int 不能赋值给int，下面作法错误
        //int k = f + i;
        double d = 2.3;
        double doub = d + f;
        // float + int 是float类型，但可以赋值个double类型
        float flo = f + i;
        double doub1 = f + i;
        short s = 2;
        short s1 = 3;
        // short + short = int, 因此下面一行是错误的
        //short s3 = s + s1;
        int s3 = s + s1;
        byte b = 1;
        // byte + short = int, 同上
        int s4 = b + s;
    }

    // 强制类型转换
    public void cast() {
        // 语法格式： (type) variable
        double d = 3.12;
        int i = (int) d;
        // Math.round 返回的是long类型的值
        int k = (int) Math.round(d);
        /**
         * 注意： 不要将boolean类型的值和其他类型进行强制转换
         * 可以使用三元表达式
         * 如： boolean b = true;
         *     b ? 1 : 0;
         */
    }

    // 枚举类型
    public void typeEnum() {

        Size s = Size.EXTRA_LARGE;
    }

    // 字符串类型
    public void typeString() {
        // 每个用双引号包含起来的字符串都是String一个类的实例
        String s = "string";
        String greeting = "Hello World!";

        // 子串方法，两个参数左闭右开，二者相减为子串长度
        String subS = greeting.substring(0, 3);

        // 字符串拼接 +
        String plusString = s + subS + "plus";

        // 多个字符串以某个符号为间隔拼接
        // join方法第一个参数为分割符号，其余参数为要拼接的字符串
        String joinString = String.join(";", s, subS, plusString);

        // 字符串比较，不能用==来比较两个字符串
        plusString.equals(joinString);
        // 忽略大小写
        plusString.equalsIgnoreCase(joinString);

        // 判断是否为空串
        if(plusString.length() == 0) {
        }
        if(plusString.equals("")) {
        }

        // 判断是否为null
        if(plusString == null) {

        }

        // 字符串比较，返回-1,0,1
        int compRst = plusString.compareTo(s);

        // StringBuilder insert delete append length toString
        StringBuilder stringB = new StringBuilder();
        stringB.append("sb");
        String fromBuilder = stringB.toString();


        // scanner 读取输入 next等（如nextLine,nextInt），hasNext等(如hasNext, hasNextInt)
        Scanner userInput = new Scanner(System.in);
        // 获取一行
        String name = userInput.nextLine();
        // 获取一个单词，以空白符为分割
        String firstName = userInput.next();
        // 获取数字
        int age = userInput.nextInt();
        double salary = userInput.nextDouble();

        // 获取密码，输入不可见，且只能获取一行，没有Scanner灵活
        Console cons = System.console();
        // 安全起见放在一维字符数组内
        char[] password = cons.readPassword();
    }

    public void formatOut() {
        System.out.printf("%,.2f", 1000/3.0);
    }

    public void fileRead() throws IOException {
        PrintWriter out = new PrintWriter("D:\\Java8\\README.txt", "UTF-8");
        Scanner in = new Scanner(Paths.get("D:\\Java8\\README.txt"), "UTF-8");
    }

    public void aboutArray() {
        // 声明一个数组 type[] name
        int[] iArray;
        // 初始化数组，数组大小一旦确定就不能更改，默认赋值
        iArray = new int[10];
        // 初始化的简便写法
        int[] iArray2 = {1,2,3,4,5};
        // 创建一个匿名数组
        iArray2 = new int[] {3,4,5,5,6,7};
        // foreach 遍历
        for(int i : iArray) {
            // do something
        }
        // 一个打印数组中所有值的简单方法
        System.out.println(Arrays.toString(iArray));
        // copy数组，不引用同一个对象, 第二个参数为数组的长度
        int[] copiedIArray = Arrays.copyOf(iArray2, 20);
        // 数组排序
        Arrays.sort(iArray2);
    }
}
