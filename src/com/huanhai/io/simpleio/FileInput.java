package com.huanhai.io.simpleio;

import java.io.*;

/**
 * 文件处理类
 *
 * @author 覃波
 * @version 1.0
 * @date 2019/9/16
 */
public class FileInput {
    /**
     * 读取文件
     *
     * @param path 文件路径
     * @return 无
     * @author 覃波
     * @date 2019/10/14
     */
    public void readFileByChar(String path) {
        InputStream in = null;
        InputStreamReader fr = null;
        BufferedReader bt = null;
        try {
            //获取文件输入流
            in = new FileInputStream(path);
            //缓冲流
            fr = new InputStreamReader(in);
            bt = new BufferedReader(fr);
            String ctx = null;
            while ((ctx = bt.readLine()) != null) {
                System.out.println(ctx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bt.close();
                fr.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * 写入文件
     *
     * @param path 输出文件路径
     * @return 无
     * @author 覃波
     * @date 2019/10/14
     */
    public void writeFileByChar(String path) {
        OutputStream outputStream = null;

    }
}
