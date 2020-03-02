import java.time.DayOfWeek;
import java.time.LocalDate;

public class UnderstandOOP {
    /**
     * 面向对象的程序是由对象组成的，每个对象都包含对用户公开的特定功能部分和隐藏的实际部分
     * OOP中不关心对象的实现，只要能满足用户的需求即可
     * OOP将数据放在第一位，然后再考虑操作数据的算法
     *
     * 类： 构造对象的模板或蓝图
     * 封装： 将数据和行为组合在一个包里，并对对象使用者隐藏数据的实现方式，封装的关键在于决定不能让类中的方法直接地访问
     *      其他类的实例域，程序仅通过对象的方法与对象数据进行交互
     * 实例域： 对象中的数据
     * 方法： 操作数据的过程
     * 对象的状态： 对象实例域值的集合
     *
     * 对象的三个主要特性：
     * 1. 对象的行为： 可以对对象施加哪些操作或方法
     * 2. 对象的状态： 当施加那些方法是，对象如何响应（对象保存的描述当前特征的信息）
     * 3. 对象标识： 如何分辨具有相同行为与状态的不同对象
     * 对象的关键特性在彼此之间相互影响
     *
     * 类之间的关系：
     * 依赖（“uses-a"): 如果一个类的方法操纵另一个类的对象，我们就说一个类依赖于另一个类
     * 聚合（”has-a")： 意味着类A的对象包含类B的对象
     * 继承（“is-a")： 用于表示特殊与一般关系
     *
     * 区分对象与对象变量之间的关系，对象变量仅仅引用一个对象，并不是实际包含一个对象
     * 更改器方法与访问器方法
     * 更改器方法： 调用方法后对象的状态会改变
     * 访问器方法： 只访问对象而不修改对象的方法
     */

    public static void main(String[] args) {
        // 不要使用构造器来构造LocalDate类的对象，应当使用静态工厂方法
        LocalDate now = LocalDate.now();
        LocalDate yesterday = LocalDate.of(2020, 3, 1);
        LocalDate tomorrow = yesterday.plusDays(2);
        int year = yesterday.getYear();
        int month = yesterday.getMonthValue();
        int day = yesterday.getDayOfMonth();
        int day2 = tomorrow.getDayOfMonth();
        System.out.println("" + year + month + day + day2 + "");
        calenderTest();
    }

    public static void calenderTest() {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for(int i=1; i<value; i++) {
            System.out.print("    ");
        }
        while(date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if(date.getDayOfMonth() == today) {
                System.out.print("*");
            } else {
                System.out.print("　");
            }
            date = date.plusDays(1);
            if(date.getDayOfWeek().getValue() == 1) System.out.println();
        }
        if(date.getDayOfWeek().getValue() != 1) System.out.println();
    }
}

