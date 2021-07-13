package com.huanhai.thread.pool.test1;
//业务类
public class PrintArg {

    private char[] chars;

    private volatile boolean flag=false;
    private volatile int pos =0;

    public PrintArg(char[] chars) {
        this.chars = chars;
    }

    public void prinf(int pos){
        System.out.println(Thread.currentThread().getName()+"  "+chars[pos]);
    }


    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public char[] getChars() {
        return chars;
    }

    public void setChars(char[] chars) {
        this.chars = chars;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


}
