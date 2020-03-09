public class DocsChapter6 {
    /**
     * 接口： 主要用来描述类具有什么功能，而并不给出每个功能的实现
     * lambda表达式： 一种表示可以在将来某个时间点执行的代码块的简洁方法
     * 6.1 接口
     *  1. 接口不是类，而是对类的一组需求描述
     *  2. 接口中的所有方法自动地属于public，在接口中声明方法时可不用提供关键字public
     *  3. 接口中不能含有实例域， Java 8 以前也不能在接口中实现方法
     *  5. 类实现一个接口通常有两个步骤：
     *      1.将类声明为实现给定的接口， 需要使用关键字 implements
     *      2.对接口中的所有方法进行定义
     *  6. 在实现接口时，必须将方法声明为public
     *  7. 不能使用new运算符实例化一个接口
     *  8. 能声明接口变量，接口变量必须引用实现了接口的类对象
     *  9. 也可以使用instanceof检查一个对象是否属于某个特定的接口
     *  10. 接口也可以被继承
     *  11. 接口中不能包含实例域或静态方法，但却可以包含常量，接口中的域会被自动设为public static final
     *  12. 每个类只能拥有一个超类，但却可以实现多个接口，用逗号隔开
     *  13. Java 8 中，允许在接口中增加静态方法
     *  14. 可以为接口方法提供一个默认实现，用default修饰符标记这样一个方法，默认方法可以调用任何其他方法
     *  15. 默认方法冲突（接口和接口、接口和超类之间定义了同样的方法）
     *          1.超类优先，如果超类提供了一个具体方法，则会忽视接口中提供的同名且参数相同的默认方法，类优先的原则
     *              可以确保与Java 7的兼容性，即即使在接口中新增默认方法，也不会影响到原来正常工作的代码
     *          2.接口冲突
     *              1.如果一个超接口提供了一个默认方法，另一个接口提供了一个同名且参数类型相同的方法，必须
     *              覆盖这个方法来解决冲突
     *              2.只要有一个接口提供了默认实现，那么编译器就会报错，必须解决这个二义性
     *              3.如果都没有提供默认实现，那么可以 1.实现 2. 不是实现（这个类本事就是抽象的）
     *              4.如果覆盖方法时需要引用接口的默认方法，需要interface.super.getName()调用
     *  16. 不要在接口中默认方法重新定义Object类中的某个方法，因为类优先原则
     * 6.2 接口示例
     *  1. java.swing.Timer类，可以使用它在到达给定的时间间隔时发出通告
     *  2. 定时器调用的方法所在的对象的所属类需要实现java.awt.event包的ActionListener接口
     *      public interface ActionListener {void actionPerformed(ActionEvent event);}
     *     当到达指定时间间隔，定时器就会调用actionPerformed方法
     *  3. 对一个对象数组排序，前提是这些对象是实现了Comparable接口的类的实例，例如对一个字符串数组排序，是
     *      因为String类实现了Comparable<String>,而且String.CompareTo方法可以按字典顺序比较字符串
     *  4. Arrays.sort方法还有第二个版本，有一个数组和一个比较器作为参数，比较器是实现了Comparator接口的类的实例
     *      public interface Comparator<T> { int compare(T first, T second);}
     *  5. 对象克隆接口Cloneable接口，这个接口指示一个类提供了一个安全的clone方法
     *  6. Object.clone() 方法是protected，说明不能直接调用这个方法。只有Employee类可以克隆Employee对象
     *  7. 默认的克隆操作时浅拷贝，如果原对象和浅克隆对象共享的子对象不是可变的，那么这种共享就是安全的
     *  8. 如果子对象是可变的，必须重新定义clone方法来建立一个深拷贝，同时克隆所有子对象
     *  9. 对于每一个类，需要确实：
     *      1. 默认的clone方法是否满足要求
     *      2. 是否可以在可变的子对象上调用clone来修补默认的clone方法
     *      3. 是否不该使用clone
     *  10. 所有数组类型都有一个public的clone方法，而不是protected
     * 6.3 lambda表达式
     *  1. 引入原因： 在Java中传递一个代码段并不容易，不能直接传递代码段，必须构造一个对象
     *  2. (String first, String second) -> first.length() - second.length();
     *  3. lambda表达式就是一个代码块，以及必须传入代码的变量规范
     *  4. 表达式形式
     *      1. 由参数、箭头、以及一个表达式
     *      2. 无法放在一个表达式内，可以将这些代码放在{}中
     *      3. 即使没有参数，仍要提供一个空括号
     *      4. 如果可以推导出一个lambda表达式的类型，则可以忽略其类型
     *      5. 如果只有一个参数并且类型可以推导出来，那么还可以省略小括号
     *      6. 无需指定lambda表达式的类型，返回类型总是有上下午推导得出
     *  5. 函数式接口： 对于只有一个<em>抽象方法</em>的接口，需要这种接口的对时，就可以提供一个lambda表达式
     *      例子： Arrays.sort(words, (first, second> -> first.length() -second.length());
     *  6. 类似Comparator的接口往往有一个特定的用途，而不只是提供一个指定参数和返回类型的方法
     *  7. 方法引用： 使用现成的方法来完成你想要传递到替他代码的某个动作
     *      Timer t = new Timer(1000, event -> System.out.println(event));
     *      Timer t = new Timer(1000, System.out::println);
     *      表达式System.out::println 是一个方法引用，等价于上面的lambda表达式
     *  8. 方法引用要使用:: 操作符分割方法名与对象或类名，三种情况：
     *      1.object::instanceMethod
     *      2.Class::staticMethod
     *      3.Class::instanceMethod
     *      对于前两种情况中，方法引用等价于提供方法参数的lambda表达式
     *      对于第三种情况，第一个参数会成为方法的目标
     *  9. 可以在方法引用中使用this参数，例如 this::equals 等价于 x -> this.equals(x)
     *     使用super也是合法的
     *  10.构造器引用，与方法引用类似，只不过方法名为new，例如 Person::new 是Person构造器的一个引用
     *  11.可以使用数组类型建立构造器引用，例如 int[]::new是一个构造器引用，他有一个参数，即数组的长度，
     *      等价于lambda表达式 x -> new int[x]
     *  12.变量作用域： 在lambda表达式中访问外围方法或类中的变量，lambda表达式可以捕获外围作用域中变量的值，并且
     *      只能引用值不会改变的变量，并且捕获的变量必须实际上是最终变量，即初始化后就不会为他赋值
     *  13.lambda表达安徽的体育嵌套块具有相同的作用域
     *  14.在一个lambda表达式中使用this关键字，是指创建这个lambda表达式的方法的this参数
     *  15.Comparator接口包含很多方便的静态方法来创建比较器，这些方法可以用于lambda表达式或方法引用
     *      静态comparing方法取一个“键提取器” 函数，他将类型T映射为一个可比较的类型（如String),
     *      可以按名字多这些对象排序
     *      Arrays.sort(people, Comparator.comparing(Person::getName));
     *      Arrays.sort(people,
     *          Comparator.comparing(Person::getName)
     *          .thenComparing(Person::getFirstName));
     *      Arrays.sort(people, Comparator.comparing(Person::getName,
     *              (s, t) -> Integer.compares(s.length(), t.length())));
     *      Arrays.sort(people, Comparator.comparingInt(p -> p.getName().length()));
     *      ...等等
     *6.4 内部类
     *  1. 内部类：定义在另一个类中的类
     *  2. 使用内部类的原因：
     *      1.内部类方法可以访问该类定义所在的作用域中的数据，包括私有数据
     *      2.内部类可以对同一个保重的其他类隐藏起来
     *      3.当想要定义一个回调函数且不想编写大量大马士，使用匿名内部类比较便捷
     *  3. 内部类对象总有一个隐式引用outer，他指向了创建他的外部类对象
     *  4. 表达式OuterClass.this 表示外围类的引用
     *  5. 编写内部类的构造器采用下列语法格式
     *      outerObject.new InnerClass(construction parameters), 如
     *      ActionListener listener = this.new TimePrinter();
     *  6. 可以通过显示地命名将外部类引用设置为其他的对象。例如，如果TimePrinter是一个公有内部类，对于任意的
     *      语音时钟都可以构造一个TimePrinter
     *      Talking jabberer = new TalkingClock(1000, true);
     *      TalkingClock.TimePrinter listener = jabberer.new TimePrinter();
     *      在外围类的作用域之外，可以这样引用内部类：
     *      OuterClass.InnerClass
     *  7. 内部类中声明的所有静态域都必须是final
     *  8. 内部类不能有static方法，也允许有静态方法，不过只能访问外围类的静态域和方法
     *  9. 内部类可以拥有访问特权，所以与常规类比较起来功能更加强大
     *  10. 局部内部类： 局部类不能用public或private访问说明符进行声明，他的作用域被限定在声明这个局部类的块中
     *  11. 局部类不仅能访问包含他的外部类，还能访问局部变量，这些局部变量必须事实上为final
     *  12. 匿名内部类： 只创建这个类的一个对象，不必命名
     *          格式： new SuperType(construction parameters) {
     *              inner class methods and data
     *          }, 其中，
     *        SuperType可以是接口，于是内部类就要实现这个接口， 也可以是一个类，于是内部类就要扩展他
     *  13. 匿名内部类不能有构造器，需要将构造器参数传递给超类
     *  14. 习惯的做法是使用匿名内部类实现事件监听器和其他回答，如今最好还是使用lambda表达式
     *  15. 构造一个数组列表并将它传递到一个方法
     *      ArrayList<String> friends = new ArrayList<>();
     *      friends.add("Harry");
     *      friends.add("Tony");
     *      invite(friends);
     *
     *      双括号初始化：
     *      invite(new ArrayList<String>() {{add("Harry"); add("Tony");}});
     *      外层括号建立以一个ArrayList的匿名子类，内层括号则是一个对象构造块
     *  16. 静态内部类： 有时候使用内部类只是为了把一个类隐藏在另外一个类的内部，并不需要内部类引用外围类对象，
     *      为此可以将内部类声明为static，以便取消产生的引用
     *
     */
}
