/**
 * 枚举实现单例模式
 * 没有延时加载
 */
public enum  SingletonEnum {
    // 这个枚举元素本身就是单例对象
    INSTANCE;

    // 添加需要的操作
    public void operation() {}
}
