import java.util.Arrays;

public class StandardOutput {
    public static void main(String[] args) {
        // 标志 宽度 . 精度

        // 2位精度
        System.out.printf("%,.2f", 10000.0 / 3.0);
        // 10个字符宽度， +号 打印正数和负数的符号
        System.out.printf("%+,10.2f", -10000.0 / 3.0);
        // 空格 表示在正数之前添加空格
        System.out.printf("%, 10.2f", 10000.0 / 3.0);
        // 左括号， 把负数包含在内
        System.out.printf("%(,10.2f", -10000.0 / 3.0);
        // -号， 左对齐
        System.out.printf("%-,10.2f", 10000.0 / 3.0);

    }
}
