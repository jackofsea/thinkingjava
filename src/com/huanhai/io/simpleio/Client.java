package com.huanhai.io.simpleio;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Client {
    public static void main(String[] args) throws IOException {
        InputStream fs = null;

        try {
             fs=new FileInputStream("D:\\a.txt");
            new FileInput().writeFileByChar(fs,"E:\\b.txt");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            fs.close();
        }


    }
}
