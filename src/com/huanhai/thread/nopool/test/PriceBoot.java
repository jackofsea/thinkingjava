package com.huanhai.thread.nopool.test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 测试多线程间的可见性
 *
 * -Djava.compiler=NONE 关闭JIT编译
 * <p>
 * 尽量避免使用volatile关键字修饰引用变量，因为多线程间看不到对象数据域的变化，
 * 应使用基础类型或者CAS
 * </p>
 * Thread.sleep()在循环调用时，会让共享变量对其他线程可见(需要进一步的证明)
 * 如：
 * while (flag){
 * //打印函数证明锁粗化的存在
 * //System.out.println("测试");
 * try {
 * TimeUnit.MILLISECONDS.sleep(10);
 * }catch (Exception e){
 * }
 * }
 *
 * @author 覃波
 * @version 1.0
 * @date 2020-12-14 11:13
 **/
public class PriceBoot {


    public static boolean flag = true;
    public static PriceRunnable p = new PriceRunnable();
    public static Map<String, PriceThread> pool = new HashMap<>();

    public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
//        testThread();
//        testThreadPool();
//        testJIT();
       testThreadHash();



    }

    static void testThread() throws InterruptedException {

        p.setStop(true);
        Thread thread = new Thread(p);
        thread.start();

        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.stop();

            System.out.println("修改了p" + p.getStop() + Thread.currentThread().getName());
        }
        ).start();
    }

    static void testJIT() {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = false;
            System.out.println("线程启动！");
        }).start();
        Map<String, Integer> m = new HashMap();
        while (flag) {
            //打印函数证明锁粗化的存在
            //System.out.println("测试");
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (Exception e) {

            }

        }

    }

    static void testThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        p.setStop(true);
        Thread thread1 = new Thread(p);
        executorService.execute(thread1);

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.stop();

            System.out.println("线程池修改了p" + p.getStop() + Thread.currentThread().getName());
        }
        );
        executorService.execute(thread2);
    }

    /**
     * 示例三
     * @throws InterruptedException
     */
    static  void testThreadHash() throws InterruptedException {
        PriceThread thread1 = new PriceThread();
        thread1.start();
        pool.put("test1", thread1);
        TimeUnit.MILLISECONDS.sleep(2000);
        PriceThread tmp = pool.get("test1");
        tmp.stopPriceThread();
        System.out.println("停止线程:"+tmp.getStop());
    }

}


