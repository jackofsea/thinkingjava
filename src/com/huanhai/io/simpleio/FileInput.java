package com.huanhai.io.simpleio;

import java.io.*;

/**
 * @version 1.0
 * @Description: 读取
 * @Author: 覃波
 * @Date: 2019/9/16
 */
public class FileInput {
  public static void readFile(String path) {
      InputStream in=null;
      InputStreamReader fr=null;
      BufferedReader bt=null;
      try{
          //获取文件输入流
           in =new FileInputStream(path);
          //缓冲流
           fr =new InputStreamReader(in);
           bt=new BufferedReader(fr);
          String ctx=null;
          while ((ctx =bt.readLine())!= null){
              System.out.println(ctx);
          }
      }catch (Exception e){
          e.printStackTrace();
      }finally {
          try {
              bt.close();
              fr.close();
              in.close();
          } catch (IOException e) {
              e.printStackTrace();
          }

      }

  }
}
