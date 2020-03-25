/**
 * 单例模式： 一个类只创建一个实例对象（原因：创建实例的成本较高或者只需要一个实例）
 * 懒汉式： 调用效率低，可以延时加载， 资源利用率高，但并发效率较低
 * 通过 类访问, 可能有多个线程同时访问，因此要加synchronized关键字
 */
public class SingletonLazy {
    private static SingletonLazy single;

    private SingletonLazy() {};

    public synchronized SingletonLazy getSingle() {
        if(single == null) {
            single = new SingletonLazy();
        }
        return single;
    }
}