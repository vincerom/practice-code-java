package top.licz.leetcode.threads;

/**
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 */
public class FooBar {

    private int n;
    private boolean flag;
    private static final Object lock = new Object();

    public FooBar(int n) {
        this.n = n;
        this.flag = true;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (!flag) {
                    lock.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = false;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (flag) {
                    lock.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = true;
                lock.notifyAll();
            }
        }
    }

}
