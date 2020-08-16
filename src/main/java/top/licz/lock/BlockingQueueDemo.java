package top.licz.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock实现阻塞队列(栈)
 */
public class BlockingQueueDemo {
    private Lock lock = new ReentrantLock();
    private Condition fullCon = lock.newCondition();
    private Condition emptyCon = lock.newCondition();
    private Object[] arr = null;
    private int length;
    private int index = 0;
    private int size = 0;

    public static void main(String[] args) throws InterruptedException {
        final BlockingQueueDemo queue = new BlockingQueueDemo(5);
        while (true) {
            new Thread(new Runnable() {
                public void run() {
                    queue.push(new Object());
                }
            }).start();
            new Thread(new Runnable() {
                public void run() {
                    queue.pop();
                }
            }).start();
        }
    }

    public BlockingQueueDemo(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("阻塞队列长度有误");
        }
        this.arr = new Object[length];
        this.length = length;
    }

    public void push(Object o) {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId() + "PUSH, SIZE:" + size);
            // 必须用while而不是if，进入语句块后阻塞一段时间后如果被唤醒时不检查，有可能不满足条件
            while (size >= length) {
                System.out.println(Thread.currentThread().getId() + "FULL");
                fullCon.await();
            }
            arr[index] = o;
            index++;
            size++;
            emptyCon.signalAll();
        } catch (Exception e) {
            System.out.println("====" + Thread.currentThread().getId());
            e.printStackTrace();
            System.exit(1);
        } finally {
            lock.unlock();
        }
    }

    public Object pop() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId() + "POP, SIZE:" + size);
            // 必须用while而不是if，进入语句块后阻塞一段时间后如果被唤醒时不检查，有可能不满足条件
            while (size <= 0) {
                System.out.println(Thread.currentThread().getId() + "EMPTY");
                emptyCon.await();
            }
            Object o = arr[--index];
            size--;
            fullCon.signalAll();
            return o;
        } catch (Exception e) {
            System.out.println("====" + Thread.currentThread().getId());
            e.printStackTrace();
            System.exit(1);
            return null;
        } finally {
            lock.unlock();
        }
    }

}
