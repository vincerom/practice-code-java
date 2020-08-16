package top.licz.thread;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 原代码只输出一次当前时间
 * 增加一行代码，使其每秒输出当前时间
 */
public class Item1 {

    public static void main(String[] args) {
        final ScheduledExecutorService es = Executors.newSingleThreadScheduledExecutor();
        es.schedule(new Runnable() {
            @Override
            public void run() {
                // 增加此行
                es.schedule(this, 1, TimeUnit.SECONDS);
                System.out.println("now " + new Date());
            }
        }, 1, TimeUnit.SECONDS);
    }

}
