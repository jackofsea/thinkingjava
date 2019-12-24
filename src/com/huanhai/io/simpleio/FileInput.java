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
            //字符缓冲流
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
     * 写入文本文件
     *
     * @param path 输出文件路径
     * @return 无
     * @throws NullPointerException
     * @author 覃波
     * @date 2019/10/14
     */
    public void writeFileByChar(InputStream in, String path) {
        if (in == null) {
            throw new NullPointerException();
        }
        InputStreamReader fr = null;
        BufferedReader bt = null;
        OutputStream outputStream =null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        try {
            //缓冲流
            fr = new InputStreamReader(in);
            bt = new BufferedReader(fr);
            outputStream = new FileOutputStream(path);
            osw = new OutputStreamWriter(outputStream);
            bw = new BufferedWriter(osw);
//            byte[] b = new byte[1024];
            String tmp;
            while ((tmp=bt.readLine()) != null){
                bw.write(tmp);
            }

        } catch (Exception e) {

        } finally {
            close(bt);
            close(fr);
            close(in);
            close(bw);
            close(osw);
            close(outputStream);
        }

    }
    private void close(InputStream in){
        try {
            in.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    private void close(Reader reader){
        try {
            reader.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    private void close(OutputStream out){
        try {
            out.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    private void close(Writer writer){
        try {
            writer.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
