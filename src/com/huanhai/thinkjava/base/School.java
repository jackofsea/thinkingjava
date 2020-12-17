package com.huanhai.thinkjava.base;

/**
 * 枚举可以拥有抽象方法和成员变量
 */
public enum School {
    LIBERAL{
        public String covert(){return "文科";}
        void teach(){
            System.out.println("文科老师教学");
        }
    },
    SCIENCE{
        public String covert(){return "理科";}
        void teach(){
            System.out.println("理科老师教学");
        }
    };
    private String name="老师";
    private int age=18;
    public String covert(){
        return name+age;
    }

    abstract  void teach();

    public void action(){
        System.out.println(covert());
        teach();
    }

    public static void main(String[] args) {
        School.LIBERAL.action();
    }
}
