public class KeywordFinal {
    /**
     * final 关键字表示常量，即变量声明后只能被赋值一次
     * 变量名通常全大写，单词之间用_隔开
     * 类常量： static final 关键字设置，定义在main方法外部，可供多个方法使用，
     */
    public static final int ZERO_DAYS = 0;
    public static void useFinal() {
        // 声明并赋值
        final int I_AM_A_FINAL_VARIABLE = 1;
        // 先声明，后赋值
        final double PI ;
        PI = 3.14;
        // 不能更改
        // I_AM_A_FINAL_VARIABLE = 2;
        // PI = 3.1;

        // 使用类常量
        System.out.println(KeywordFinal.ZERO_DAYS);
    }
}
