package com.huanhai.thread.nopool.t001;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入目录");
        String directory = in.nextLine();
        System.out.println("输入关键字");
        String keyWord = in.nextLine();
        final int FILE_QUEUE_SIZE = 10;
        final int SEARCH_THREAD = 100;
        BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);
        FileEnumretionTask enumretionTask = new FileEnumretionTask(queue, new File(directory));
        new Thread(enumretionTask).start();
        for (int i = 1; i <= SEARCH_THREAD; i++) {
            new Thread(new SearchTask(queue, keyWord)).start();
        }


    }
}

class FileEnumretionTask implements Runnable {
    public static File DUMMY = new File("");
    private BlockingQueue<File> queue;
    private File startingDirectory;

    public FileEnumretionTask(BlockingQueue<File> queue, File startingDirectory) {
        this.queue = queue;
        this.startingDirectory = startingDirectory;
    }

    @Override
    public void run() {
        try {
            enumrate(startingDirectory);
            queue.put(DUMMY);
        } catch (InterruptedException e) {

        }
    }

    public void enumrate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                enumrate(file);
            } else {
                queue.put(file);
            }
        }
    }
}

class SearchTask implements Runnable {
    private BlockingQueue<File> queue;
    private String keyword;

    public SearchTask(BlockingQueue<File> queue, String keyword) {
        this.queue = queue;
        this.keyword = keyword;
    }

    @Override
    public void run() {
        try {
            boolean done = false;
            while (!done) {
                File file = queue.take();
                if (file == FileEnumretionTask.DUMMY) {
                    queue.put(file);
                    done = true;
                } else {
                    search(file);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {

        }
    }

    public void search(File file) throws IOException {
        Scanner in = new Scanner(new FileInputStream(file));
        int lineNumber = 0;
        while (in.hasNextLine()) {
            lineNumber++;
            String line = in.nextLine();
            if (line.contains(keyword)) {
                System.out.printf("%s:%d:%s%n", file.getPath(),lineNumber,line);
            }

        }
        in.close();
    }
}