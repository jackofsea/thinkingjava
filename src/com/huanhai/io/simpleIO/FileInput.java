package com.huanhai.io.simpleIO;

import java.io.*;

/**
 * @version 1.0
 * @Description: 读取
 * @Author: 覃波
 * @Date: 2019/9/16
 */
public class FileInput {
  public static void readFile(String path) {
      try{
          //获取文件输入流
          InputStream in =new FileInputStream(path);
          //缓冲流
          InputStreamReader fr =new InputStreamReader(in);
          BufferedReader bt=new BufferedReader(fr);
          String ctx=null;
          while ((ctx =bt.readLine())!= null){
              System.out.println(ctx);
          }
      }catch (Exception e){
          e.printStackTrace();
      }finally {

      }

  }
}
