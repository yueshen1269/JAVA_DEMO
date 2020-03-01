public class UseAfterDeclare {
    public static void main(String[] args) {

    }

    public static void variableUse() {
        /**
         * 变量必须先声明，再使用，没有js里面的变量提升
         */
        int k;
        k = 2;
        // g = 3;  error
        int g;
    }
}
