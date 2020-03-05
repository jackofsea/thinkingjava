package com.huanhai.thread.nopool.t001;

import javafx.concurrent.Task;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入目录");
        String directory = in.nextLine();
        System.out.println("输入关键字");
        String keyWord = in.nextLine();
        MatchCounter counter = new MatchCounter(new File(directory),keyWord);
        FutureTask<Integer> task = new FutureTask<>(counter);
        Thread t = new Thread(task);
        t.start();
       try{
           System.out.println(task.get()+" macth files:");
       }catch (ExecutionException e){

       }catch (InterruptedException e){

       }

    }
}

class MatchCounter implements Callable<Integer> {
    private String keyWord;
    private File diretory;
    private int count;

    public MatchCounter(File diretory, String keyWord) {
        this.keyWord = keyWord;
        this.diretory = diretory;
    }

    @Override
    public Integer call() throws Exception {
        count = 0;
        try {
            File[] files = diretory.listFiles();
            ArrayList<Future<Integer>> results = new ArrayList<>();
            for (File file : files) {
                if (file.isDirectory()) {
                    MatchCounter counter = new MatchCounter(file, keyWord);
                    FutureTask<Integer> task = new FutureTask<>(counter);
                    results.add(task);
                    Thread t = new Thread(task);
                    t.start();

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


