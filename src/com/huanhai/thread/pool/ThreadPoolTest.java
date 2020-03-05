package com.huanhai.thread.pool;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入目录");
        String directory = in.nextLine();
        System.out.println("输入关键字");
        String keyWord = in.nextLine();
        ExecutorService pool=Executors.newCachedThreadPool();
        MatchCounter counter = new MatchCounter(new File(directory),keyWord,pool);
        Future<Integer> result = pool.submit(counter);
        try{
            System.out.println(result.get()+" macth files:");
        }catch (ExecutionException e){

        }catch (InterruptedException e){

        }
        pool.shutdown();
        int largestPoolSize=((ThreadPoolExecutor)pool).getLargestPoolSize();
        System.out.println("large pool size = "+largestPoolSize);
    }
}
class MatchCounter implements Callable<Integer> {
    private String keyWord;
    private File diretory;
    private ExecutorService pool;
    private int count;

    public MatchCounter(File diretory, String keyWord, ExecutorService pool) {
        this.keyWord = keyWord;
        this.diretory = diretory;
        this.pool=pool;
    }

    @Override
    public Integer call() throws Exception {
        count = 0;
        try {
            File[] files = diretory.listFiles();
            ArrayList<Future<Integer>> results = new ArrayList<>();
            for (File file : files) {
                if (file.isDirectory()) {
                    MatchCounter counter = new MatchCounter(file, keyWord,pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);

                } else {
                    if (search(file)) {
                        count++;
                    }


                }
            }
            for (Future<Integer> result : results) {
                try {
                    count += result.get();

                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {

        }
        return count;

    }

    public boolean search(File file) {
        try {
            Scanner in = new Scanner(new FileInputStream(file));
            boolean found = false;
            while (!found && in.hasNextLine()) {
                String line = in.nextLine();
                if (line.contains(keyWord)) {
                    found = true;
                }

            }
            in.close();
            return found;
        } catch (IOException e) {
            return false;
        }


    }
}


