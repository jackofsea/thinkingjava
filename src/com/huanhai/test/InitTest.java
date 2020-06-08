package com.huanhai.test;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * @Description 初始化顺序测试
 * @Author 覃波
 * @Date 2020/4/21 8:42
 * @Version 1.0
 **/
public class InitTest {
    public static void main(String[] args) {
       int j=0;
       while (j<100){
           String s=getRandomJianHan(3);
           System.out.println("重庆"+s+"科技有限公司");
           j++;
       }




    }

    public static String getRandomJianHan(int len)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<len;i++){
            String str = null;
            int hightPos, lowPos;
            Random random = new Random();
            hightPos = (176 + Math.abs(random.nextInt(39)));
            lowPos = (161 + Math.abs(random.nextInt(93)));
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try
            {
                str = new String(b, "GBk");
            }
            catch (UnsupportedEncodingException ex)
            {
                ex.printStackTrace();
            }
            sb.append(str);
        }
        return sb.toString();
    }

}
