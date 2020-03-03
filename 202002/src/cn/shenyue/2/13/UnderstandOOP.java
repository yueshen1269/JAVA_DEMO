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
     *
     * private: 只有类自身的方法能够访问
     * 构造器：
     * 1. 构造器与类同名
     * 2. 每个类都可以有一个以上的构造器
     * 3. 构造器可以有0个、1个或多个参数
     * 4. 构造器没有返回值
     * 5. 构造器总是随着new操作仪器调用
     *
     * 实例值相关
     * 1. 一个私有的数据域
     * 2. 一个公有的域访问器方法
     * 3.一个公有的域更改器方法
     * 好处：
     * 1. 可以改变内部实现，不会影响其他代码
     * 2. 更改器方法可以执行错误检查
     * 注意：
     * 1. 不要编写返回引用可变对象的访问器方法
     * 2. 如果需要返回一个可变对象的引用，应该首先对它进行克隆（Obj.clone())
     *
     * 一个方法可以访问所属类的所有对象的私有数据
     *
     * 以下情况下使用静态方法：
     * 1. 一个方法不需要访问对象状态，其所需参数都是通过显式参数提供
     * 2. 一个方法只需要访问类的静态域
     * 3. 作为静态工厂方法构造对象（原因： 1. 无法命名构造器，因为构造器的名字必须与类名相同
     *      2. 使用构造器是，无法改变所构造的对象类型）
     *
     * 参数调用： Java语言总是采用按值调用
     * Java中方法参数的使用情况：
     * 1. 一个方法不能修改一个基本数据类型的参数（数值型和布尔型）
     * 2. 一个方法可以改变一个对象参数的状态
     * 3. 一个方法不能让对象参数引用一个新的对象
     *
     * 重载： 多个方法拥有相同的名字、不同的参数变产生了重载
     * 方法签名： 方法名和参数类型，返回类型不是方法签名的一部分
     *
     * 默认域初始化： 如果在构造器中没有显示地给域赋值，那么就会被自动地赋为默认值（数字：0，布尔：false,对象引用null)
     *
     * 编写类时没有编写构造器，那么系统就会提供一个无参数构造器
     *
     * 显示域初始化： 在执行构造器之前，先执行赋值操作
     * 通过this调用另一个构造器
     * 使用初始化块（包含静态和实例初始化块，静态初始化块要加static关键字），
     *  首先运行初始化块，然后才运行构造器的主体部分
     *
     * 调用构造器的具体步骤：
     * 1. 所有数据被初始化为默认值
     * 2. 按照在类声明中出现的次序，一次执行所有域初始化语句和初始化块
     * 3. 如果构造器第一行调用了第二个构造器，则执行第二个构造器主体
     * 4. 执行这个构造器的主体
     *
     * 类设计技巧：
     * 1. 一定要保证数据私有
     * 2. 一定要对数据初始化
     * 3. 不要在类中使用过多的基本类型
     * 4. 不是所有的域都需要独立的域访问器和更改器
     * 5. 将职责过多的类进行分解
     * 6. 类名和方法名要体现他们的职责
     * 7. 优先使用不可变的类
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

