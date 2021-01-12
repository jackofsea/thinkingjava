package com.huanhai.thinkjava.base;

/**
 * 枚举可以拥有抽象方法和成员变量
 * 因为语法糖的原因，拥有抽象方法和成员变量的枚举成员会自动编译成内部类
 */
public enum School {
    LIBERAL {
        public String covert() {
            return "文科";
        }

        void teach() {
            System.out.println("文科老师教学");
        }
    },
    SCIENCE {
        public String covert() {
            return "理科";
        }

        void teach() {
            System.out.println("理科老师教学");
        }
    };
    private String name = "老师";
    private int age = 18;

    public String covert() {
        return name + age;
    }

    abstract void teach();

    public void action() {
        System.out.println(covert());
        teach();
    }

    public static void main(String[] args) {
        //测试枚举抽象方法
        School.LIBERAL.action();
        //测试获取枚举成员定义的字段属性
        System.out.println(Time.MILLISECONDS.getVal());
    }
}

/**
 * 定义含有参数的枚举
 * 可以自由获取每个枚举成员的参数
 */
enum Time {
    HOUR("小时", 60),
    MINUTES("分钟", 60),
    SECOND("秒", 60),
    MILLISECONDS("毫秒", 1000);
    private String val;
    private int up;

    Time(String val, int up) {
        this.val = val;
        this.up = up;
    }

    public String getVal() {
        return val;
    }

    public int getUp() {
        return up;
    }
}