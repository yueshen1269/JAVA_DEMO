/**
 * 单例模式 静态内部类实现
 * 1. 不会立即加载对象
 * 2. 线程安全，延时加载
 * 3. 可以防止反射和反序列化漏洞
 */
public class SingletonInnerClass {
    private static class Inner {
        public static final SingletonInnerClass single = new SingletonInnerClass();
    }

    private  SingletonInnerClass() {}

    public SingletonInnerClass getSingle() {
        return Inner.single;
    }
}
