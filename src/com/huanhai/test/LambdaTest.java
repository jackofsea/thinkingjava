package com.huanhai.test;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author luofeng
 * @version 1.0
 * @date 2021-03-23 10:55
 **/
public class LambdaTest {

    static {
      i=3;
    }
    private static int i=2;
    private static List<String> stringList=new ArrayList<>(50);

    private static List<Integer> intList=new ArrayList<>(50);

    private static List<Animal> animalList=new ArrayList<>(50);


    static {

        stringList.addAll(Arrays.asList("李四","张三","王麻子","王五","小刘","小六","小英","周斌","恭城","刘倩","史国茜","张三","小三"));
        intList.addAll(Arrays.asList(1,23,4,2,45,56,676,76,8,7,87,6,56,5,4,9,34,4,3,422,34,54,55,65,1,7,7,3,23,4));
    }

    public static void main(String[] args)  {

        System.out.println("i =" +i);
        List<String> stringList2 = new ArrayList<>(stringList);
        //去重输出
        stringList2.stream().distinct().forEach(System.out::print);
        System.out.println("\n-------------------过滤出符合条件数据");
        //过滤出符合条件数据
        List<String>  filterStringList=stringList2.stream().filter(s -> !"王麻子".equals(s)).collect(Collectors.toList());
        filterStringList.add("测试");
        filterStringList.stream().forEach(System.out::print);
        System.out.println("\n-------------------条件筛选");
        //条件筛选
        Predicate<String> p1=o-> o.startsWith("小");
        Predicate<String> p2=o-> o.endsWith("三");
        stringList2.stream().filter(p1).forEach(System.out::print);
        System.out.println();
        //单个条件
        stringList2.stream().filter(p2).forEach(System.out::print);
        System.out.println();
        stringList2.stream().filter(p2.negate()).forEach(num-> System.out.print(num + " "));
        System.out.println();
        //组合条件，取或
        stringList2.stream().filter(p2.or(p1)).forEach(System.out::print);
        System.out.println();
        //组合条件取与
        stringList2.stream().filter(p2.and(p1)).forEach(System.out::print);
        System.out.println("\n-------------------Map");
        intList.stream().map(num->num+1).forEach(num-> System.out.print(num + " "));
        System.out.println();
        //计算结果
        int c=intList.stream().map(num->num+1).reduce(Integer::sum).get();
        System.out.println(c);
        System.out.println(intList.stream().mapToInt(Integer::intValue).sum());
        System.out.println("最大值" +intList.stream().max(Comparator.comparingInt(Integer::intValue)).get());
        System.out.println("最小值" +intList.stream().min(Comparator.comparingLong(i->i)).get());


    }




    public static <T> T test(Class<T> tClass) {
        T a=null;
        try {
            Constructor<?>[]  con=tClass.getDeclaredConstructors();
            for(int i =0 ;i<con.length;i++){
                Constructor<?> cons=con[i];
                if(cons.getParameterCount() == 1){
                    cons.setAccessible(true);
                    a=(T) cons.newInstance(1);
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

       return a;
    }
}
