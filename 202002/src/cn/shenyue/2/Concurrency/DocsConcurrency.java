public class DocsConcurrency {
    /**
     * 一个程序同时执行多个任务，通常，每个任务称为一个线程，他是线程控制的简称
     * 多线程与多进程的区别： 本质的区别在于每个进程都拥有自己的一整套变量，而线程都共享数据
     * 14.1 创建线程
     *  方法1； 1.实现Runnable接口  Runnable r = () -> { task code 实现run方法};
     *         2.由Runnable创建一个Thread对象 Thread t = new Thread(r);
     *         3.启动线程  t.start() // 不是t.run()
     *  方法2： 通过构建Thread类的一个子类，并重写run方法，然后调用start方法（不再推荐）
     *  方法3： 线程池
     * 14.2 中断线程
     *  1. 当线程的run方法执行方法体中最后一条语句后，并经由执行return语句返回时，或者出现了在方法中没有捕获的
     *  异常时，线程将终止
     *  2. 没有可以强制线程终止的方法，然而，interrupt方法可以用来请求终止线程
     *  3. 当对一个线程调用interrupt方法时，线程的<em>中断状态</em>将被置位，这是每一个线程都具有的boolean标志
     *     调用静态的Thread.currentThread方法获得当前线程，然后调用isInterrupted方位获得中断状态是否被置位
     *      while(!Thread.currentThread.isInterrupted()&& more work to do) {
     *          do more work
     *      }
     *  4. 如果线程被阻塞，就无法检测中断状态，这是产生InterruptedException异常的地方
     *
     */
}
