package leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author = wangyilin29
 * @date = 2023/11/29
 **/
public class LeetCode1115 {
    private int n = 2;
    private ReentrantLock firstRL = new ReentrantLock();
    private Condition first = firstRL.newCondition();
    private Condition second = firstRL.newCondition();
    private ReentrantLock secondRL = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        LeetCode1115 leetCode1115 = new LeetCode1115();
        Thread thread1 = new Thread(() -> {
            try {
                leetCode1115.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                leetCode1115.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread2.start();

//        Thread.sleep(1000);
//        thread2.stop();
//        thread1.stop();
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            firstRL.lock();

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            first.signal();
            second.await();
            firstRL.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
        }
    }
}
