public class Docs {
    /**
     *  继承已存在的类就是复用（继承）这些类的方法和域
     * 5.1 类、超类和子类
     *  1. “is-a"关系是继承的一个明显特征
     *  2. 重载在编译时确定，重写在运行时确定
     *  3. private域是否继承： 不继承，但可以通过公有的访问器和更改器访问
     *  4. super不是一个对象的引用，只是一个指示编译器调用父类方法的关键字
     *  5. 子类构造器不能访问父类的私有域，因此需要通过super来调用父类的构造函数进行初始化
     *  6. 多态： 一个变量可以指示多种实际类型的现象
     *  7. 方法调用 x.f(args)， 隐式参数x声明为类C的一个对象：
     *      1. 编译器查看对象的声明类型和方法名，一一列举所有C类中名为f的方法和超类中访问属性为public且名为f的方法
     *      2. 查看调用时提供的参数类型，重载解析
     *      3. private方法、static方法和final方法或者构造器，编译器可以准确知道应该调用哪个方法，这种调用方式
     *          称为静态绑定。与此对应，调用的方法依赖于隐式参数的实际类型，在运行时实现动态绑定
     *      4. 程序运行时，并且采用动态绑定调用方法时，虚拟机调用与x所引用对象的实际类型最合适的那个类的方法
     *   8. 在覆盖一个方法是，子类方法不能低于超类方法的可见性
     *   9. final类不允许继承，final方法不允许重写
     *   10. 一个类声明为final，只有其中的方法自动地成为final而不包括域
     *   11. 声明final类或方法的主要目的是：确保它们不会在子类中改变语义
     *   12. 强制类型转换
     *      1. 只能在继承层次内进行类型转换
     *      2. 在将超类转换成子类前，应使用instanceof 进行检查
     *   13. 抽象类： 只作为其他类的基类，而不作为想使用的特定的实力类
     *   14. abstract方法不需要实现，充当着占位的角色，它们的实现在子类中如 public abstract String getDes();
     *   15. 拥有一个或多个抽象方法的类必须被声明为抽象的，抽象类不能被实例化，
     *          抽象类的对象变量可以引用一个非抽象子类的实现
     *   16. 有时候希望超类的某些方法允许被子类访问，或允许子类的方法访问超类的某个域，需要将这些方法声明为protected
     *   17. Manger类（子类）中的方法只能访问Manger对象中的hireDay域(protected)，
     *          而不能访问其他Employee（父类）对象中的这个域
     *   18， protected属性谨慎使用，protected方法更有实际意义(如Object.clone()方法）
     * 5.2 Object： 所有类的超类
     *   1. Java中的所有类的始祖---Object类， 所有的数组类型都扩展了Object类
     *   2. Object.equals()
     *      1. 在自定义类中重写equals方法主要注意方法签名中的参数类型 Boolean equals(Object otherObject);
     *      2. 如果子类能够拥有自己的相等概念，则对称性需求将强制采用getClass进行检测
     *      3. 如果有超类决定相等的概念，就可以使用instanceof进行检测
     *      4. 对于数组类型的域，可以使用静态的Arrays.equals() 方法检测是否相等
     *   3. Object.hashCode()
     *      1. 散列码是由对象导出的一个整型值
     *      2. Object类的默认hashcode方法导出的是对象的对象存储值
     *      3. 字符串的散列码是由内容导出的
     *      4. Objects.hashCode() Double.hashCode() 单个值
     *      5. Objects.hash() 多个值
     *      6. Arrays.hashCode()
     *   4. Object.toString()
     *      1. Arrays.toString()
     * 5.3 泛型数组列表
     *  1. ArrayList<Employee> staff = new ArrayList<Employee>();
     *  2. 简写： ArrayList<Employee> staff = new ArrayList<>(100); (100可选，为初始容量)
     *  3. staff.add(new Employee()) staff.add(n, e) staff.ensureCapacity(100) staff.size()
     *      staff.trimToSize() staff.set(i, harry) staff.get(i) staff.toArray(array)
     *      staff.remove(n)
     *  4. 类型参数不允许是基本类型，如ArrayList<int>, 须写成ArrayList<Integer> list = new ArrayList<>();
     *  5. 使用add方法添加元素，set方法替换元素
     * 5.4 自动装箱和自动拆箱
     *      list.add(3) => list.add(Integer.valueOf(3)) 自动装箱
     *      int n = list.get(i) => int n = list.get(i).intValue(); 自动拆箱
     * 5.5 参数可变的方法
     *       Object... args
     * 5.6 枚举类
     *   1. public enum Size { SMALL， MEDIUM, LARGE, EXTRA_LARGE}
     *   2. 比较两个枚举类的值是，直接使用 ==, 而不要使用equals
     *   3. 所有的枚举类型都是Enum类的子类，继承了很多方法， 如 Size.SMALL.toString()
     *   4. toString的逆方法是静态方法valueOf, 如 Size s = Enum.valueOf(Size.class, "SMALL");
     *   5. 每个枚举类型都有一个静态的values方法，他将返回一个包含全部枚举值的数组 Size[] values = Size.values();
     *   6. ordinal方法返回enum声明中枚举常量的位置，从0开始，如 Size.LARGE.ordinal()
     * 5.7 反射
     *  1. 能够分析类能力的程序称为反射
     *  2. 反射机制可以用来：
     *      *在运行时分析类的能力
     *      *在运行时查看对象，例如，编写一个toString方法供所有类使用
     *      *实现通用的数组操作代码
     *      *利用Method对象，这个对象很像C++中的函数指针
     *  3. 在程序运行期间，Java运行时系统始终为所有的对象维护一个被称为运行时的类型标识。这个信息跟踪着每个对象所属的类，
     *      虚拟机利用运行时类型信息选择相应的方法执行。可以通过专门的Java类信息访问这些信息，保存这些信息的类
     *      被称为Class，
     *      这个名字很容日让人混淆。Object类中的getClass()方法将会返回一个Class类型的实例。
     *  4. 一个Class对象将表示一个特定类的属性，最常用的Class方法是getName，这个方法将返回类的名字，如果类在一个包里，
     *      包的名字也作为类名的一部分，还可以调用静态方法forName获得类名对应的Class对象
     *          String className = "java.util.Random";
     *          Class cl = Class.forName(className);
     *       这个方法只有在className是类名或者是接口名是才能够执行，否则，forName方法将抛出一个
     *       checked exception(已检查异常）。无论何时使用这个方法，都应该提供一个异常处理器。
     *  5. 获得Class类对象的第三种方法非常简单，如果T是任意的Java类型（或void关键字），T.class 将代表匹配
     *      的类对象，例如
     *          Class cl1 = Random.class; // if you import java.util.*;
     *          Class cl2 = int.class;
     *          Class cl3 = Double[].class;
     *      一个Class对象实际上表示的是一个类型，而这个类型未必一定是一种类。例如，int不是类，但int.class是一个
     *      Class类型的对象。Class类实际上是一个泛型类。例如，Employee.class的类型是Class<Employee>.
     *  6. 虚拟机为每个类型管理一个Class对象，因此可以利用 == 运算符实现两个类对象比较的操作。例如：
     *      if(e.getClass() == Employee.class) ...
     *     还有一个很有用的方法newInstance(),可以用来动态地创建一个类的实例，例如，
     *     e.getClass().newInstance();
     *     创建了一个与e具有相同类类型的实例，newInstance调用默认的构造器初始化新的对象，没有则抛出一个异常
     *  7. 反射机制最重要的内容--检查类的结构
     *      java.lang.reflect包中有三个类Filed、Method和Constructor分别用于描述类的域、方法和构造器,
     *      这三个类都有一个叫做getName 的方法，用来返回项目的名称
     *      Field类有一个getType方法，用来返回描述域所属类型的Class对象
     *      java.lang.reflect包中的Modifier类
     *      Class类中的getFields、getMethods和getConstructors方法将分别返回类提供的public域、方法和构造器数组
     *      其中包括超类的公有成员
     *      Class类的getDeclareFields、getDeclaredMethods和getDeclaredConstructors方法将分别返回类中
     *      声明的全部域、方法和构造器，其中包括私有和受保护成员，但不包括超类的成员
     *      详见ReflectionTest.java
     *
     * 5.8 继承的设计技巧
     *  1. 将公共操作和域放在超类
     *  2. 不要使用受保护的域
     *  3. 使用继承实现”is-a"关系
     *  4. 除非所有继承的方法都有意义，否则不要使用继承
     *  5. 在覆盖方法是，不要改变预期的行为
     *  6. 使用多态，而非类型信息
     *  7. 不要过多使用反射
     *
     *
     *
     *
     */
}
