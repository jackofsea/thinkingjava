package com.huanhai.thinkjava.base;

/**
 * double包装类API熟悉
 *
 * @author 覃波
 * @version 1.0
 * @date 2020/7/21 9:33
 **/
public class DoubleTest {

    public static void main(String[] args) {
        //Double对象的创建
        valueOf();
        //输出字符串
        toRadixString();
        //运算
        operation();
        //位操作
        bitOperation();

        System.out.println(Double.toString(3.33112111111232323));


    }

    //Double的创建
    private static void valueOf() {
        //自动装箱,下面两句代码等同
        Double d = 34D;
        Double d2 = Double.valueOf(34);
        System.out.println("d=" + d + " " + "d2=" + d2);
        //字符串转Double,.valueOf("34.2")底层调用parseDouble方法
        Double pd = Double.valueOf("34.2");
        Double pd2 = Double.parseDouble("55.454551234567891");
        System.out.println("pd=" + pd + " " + "pd2=" + pd2);
    }

    //Double转换字符串
    private static void toRadixString() {
        Double d2 = 3.44545;
        System.out.println(d2.toString());
        //Double转16进制
        System.out.println(Double.toHexString(3.4545));

    }

    //比较运算,不推荐
    private static void operation() {

        System.out.println(Double.max(2.334, 45554));

        System.out.println(Double.min(2.334, 45554));
        //是否有限数
        System.out.println(Double.isFinite(3.455));
        //是否无限数
        System.out.println(Double.isInfinite(3.455));
        //是否为非数
        System.out.println(Double.isNaN(4.777));
    }
    //将Double数据转换为Long类型，可以借此比较大小
    private  static void bitOperation(){
        System.out.println(Double.doubleToLongBits(44454.34343));
        System.out.println(Double.doubleToRawLongBits(44454.34343));
    }

}
