/**
 * 创建者模式：
 * 单例模式： 一个类只创建一个实例对象（原因：创建实例的成本较高或者只需要一个实例）
 * 饿汉式： 调用效率高，但不能延时加载
 * 通过类访问
 * static变量在类初始化时加载，天然的线程安全
 */
public class SingletonHungry {
    private static SingletonHungry single = new SingletonHungry();
    private SingletonHungry() {};

    public SingletonHungry getSingle() {
        return single;
    }

}
