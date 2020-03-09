public class DocsGeneric {
    /**
     * 泛型对于集合类尤其有用
     * 8.1
     *  1. 泛型程序设计意味着编写的代码可以被很多不同类型的对象所重用
     *  2. 泛型提供了一个类型参数，用来指示元素的类型，ArrayList<String> files = new ArrayList<>(),
     *      这使得代码具有良好的可读性
     * 8.2 定义简单泛型类
     *  1. 一个泛型类就是具有一个或多个类型变量的类
     *  2. 类定义中的类型变量指定方法的返回类型以及域和局部变量的类型
     * 8.3 泛型方法
     *  1. 还可以定义一个带有类型参数的简单方法 public static <T> T getMiddle(){}
     *  2. 泛型变量放在修饰符（public static)的后面，返回类型的前面
     * 8.4 类型变量的限定
     *  1. <T extends Comparable> 将T限制为实现了Comparable接口的类
     *  2. <T extends BoundingType> 表示T应该是绑定类型的子类型。 T和绑定类型可以是类，也可以是接口
     *  3. 一个类型变量或通配符可以有多个限定 T extends Comparable & Serializable,
     *      限定类型用 & 分隔，用逗号来分隔类型变量
     * 8.5 泛型代码和虚拟机
     *  1. 虚拟机没有反省类型对象，所有对象都属于普通类
     *  2. 无论何时定义一个泛型类型，都自动提供了一个相应的原始类型，原始类型的名字就是删去类型参数后的泛型类型名
     *      擦除类型变量，并替换为限定类型（无限定的变量用Object）
     *  3. Pair<T>的原始类型如下：
     *      public class Pair {
     *          private Object first; private Object second;
     *          public pair(Object first, Object second) {...}
     *          public Object getFirst(){}
     *          public Object getSecond(){}
     *      }
     *      ...
     *  4. 在程序中可以包含不同类型的Pair，而擦除类型后就变成原始了Pair类型了
     *  5. 原始类型用第一个限定的类型变量来替换，如果没有给定限定就用Object替换
     *  6. 如： public class Interval<T extends Comparable & Serializable> implements Serializable {
     *      private T lower;
     *      public Interval(T first, T second){}
     *      }
     *      原始类型Interval如下
     *      public class Interval implements Serializable {
     *          private Comparable lower;
     *          public Interval(Comparable first, Comparable Second){}
     *      }
     *  7.
     */
}
