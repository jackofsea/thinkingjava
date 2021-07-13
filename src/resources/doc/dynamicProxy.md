# 动态代理

## 1.概述

Java动态代理的优势是实现无侵入式的代码扩展，也就是方法的增强；让你可以在不用修改源码的情况下，增强一些方法；在方法的前后你可以做你任何想做的事情（甚至不去执行这个方法就可以）。

 简而言之，动态代理通过修改字节码实现对类进行增强。



## 2.主流的动态代理方式

### 2.1. JDK的动态代理

JDK提供了java.lang.reflect.InvocationHandler接口和 java.lang.reflect.Proxy类，这两个类相互配合，入口是Proxy。

Proxy有个静态方法：getProxyClass(ClassLoader, interfaces)，只要你给它传入类加载器和一组接口，它就给你返回代理Class对象。

 JDK代理要求别代理的类必须实现接口。

 JDK创建代理的步骤如下：

  1.必须要有接口，业务类实现此接口；

  2.创建静态代理类实现InvocationHandler,并将业务类作为成员变量；

  3.调用Proxy.newProxyInstance()方法生成动态代理类。



**实现步骤：**

1.自定义类和接口：

```java
public interface People {
     void sayHello();
    void say();
}
/**
 * @version 1.0
 * @Description: TO DO
 * @Author: 覃波
 * @Date: 2019/10/10
 */
public class Chinese implements People {
    @Override
    public void sayHello() {
        System.out.println("你好");
    }

    @Override
    public void say() {
        System.out.println("你好111");
    }
}

```

2.代理实现InvocationHandler接口

```java
/**
 * @version 1.0
 * @Description: TO DO
 * @Author: 覃波
 * @Date: 2019/10/10
 */
public class PeopleInvocationHandler implements InvocationHandler {

    private Object people;

    PeopleInvocationHandler(Object people){
        this.people = people;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(people, args);
        System.out.println("-------- end ---------");
        return invoke;
    }
}
```

3.调用实例：

```java
 People chinese = new Chinese();
 PeopleInvocationHandler invocationHandler = new PeopleInvocationHandler(chinese);
 People proxy = (People) Proxy.newProxyInstance(chinese.getClass().getClassLoader(), chinese.getClass().getInterfaces(), invocationHandler);
 proxy.sayHello();
```

**细节分析：**

jdk代码开启参数可查看动态生成的类：

```java
System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
```

动态生成的类$Proxy0：

```java
public final class $Proxy0 extends Proxy implements People {    
    private static Method m1;    
    private static Method m3;    
    private static Method m2;    
    private static Method m0;    
    public $Proxy0(InvocationHandler var1) throws  {        
        super(var1);    
    }    
    public final boolean equals(Object var1) throws  {        
        try {            
            return (Boolean)super.h.invoke(this, m1, new Object[]{var1});       
        } catch (RuntimeException | Error var3) {            
            throw var3;        
        } catch (Throwable var4) {            
            throw new UndeclaredThrowableException(var4);        
        }    }
    
    public final void sayHello() throws  {        
        try {            
            super.h.invoke(this, m3, (Object[])null);        
        } catch (RuntimeException | Error var2) {            
            throw var2;        
        } catch (Throwable var3) {            
            throw new UndeclaredThrowableException(var3);        
        }    }
    
    public final String toString() throws  {       
        try {            
            return (String)super.h.invoke(this, m2, (Object[])null);        
        } catch (RuntimeException | Error var2) {            
            throw var2;        
        } catch (Throwable var3) {            
            throw new UndeclaredThrowableException(var3);        
        }    }    
    public final int hashCode() throws  {        
        try {            
            return (Integer)super.h.invoke(this, m0, (Object[])null);        
        } catch (RuntimeException | Error var2) {            
            throw var2;        
        } catch (Throwable var3) {            
            throw new UndeclaredThrowableException(var3);        
        }    } 
    
    static {        
        try {   m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));            
             m3 = Class.forName("com.huanhai.thinkjava.advance.designpattern.proxy.dynamic.People").getMethod("sayHello");            
             m2 = Class.forName("java.lang.Object").getMethod("toString");           
             m0 = Class.forName("java.lang.Object").getMethod("hashCode");        
            } catch (NoSuchMethodException var2) {            
            throw new NoSuchMethodError(var2.getMessage());        
        } catch (ClassNotFoundException var3) {            
            throw new NoClassDefFoundError(var3.getMessage());        
        }    }}
```

动态生成的类默认继承proxy类并实现传入的接口方法，重写接口方法使其回调我们的重新invoke()方法。，invoke()是我们实现的，这里就是灵活实现自身业务的关键点。

### 2.2. CGLIB的动态代理

 cglib生成动态代理类的机制是通过类继承（生成代理对象字节码的依据是继承、通过ASM实现）实现的，因此final修饰的类是无法使用cglib代理的。

cglib 创建某个类A的动态代理类的模式过程是：

1.查找类上的所有非final 的public类型的方法定义；
2.将这些方法的定义转换成字节码；
3.将组成的字节码转换成相应的代理的class对象；
4.实现 MethodInterceptor接口，用来处理对代理类上所有方法的请求（这个接口和JDK动态代理InvocationHandler的功能和角色是一样的）

cglib不是jdk自带的，需要导入第三方包

```java

/**
 * 程序猿类
 */
public class Programmer {
 
	public void code()
	{
		System.out.println("I'm a Programmer,Just Coding.....");
	}
}

```

```java

 
import java.lang.reflect.Method;
 
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/*
 * 实现了方法拦截器接口
 */
public class MyMethodInterceptor implements MethodInterceptor {
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("**** I am a hacker,Let's see what the poor programmer is doing Now...");
		proxy.invokeSuper(obj, args);
		System.out.println("****  Oh,what a poor programmer.....");
		return null;
	}
```

```java

import net.sf.cglib.proxy.Enhancer;
 
public class Test {
 
	public static void main(String[] args) {
		Programmer progammer = new Programmer();
		
		MyMethodInterceptor myMethodInterceptor= new MyMethodInterceptor ();
		//cglib 中加强器，用来创建动态代理
		Enhancer enhancer = new Enhancer();  
        //设置要创建动态代理的类
		enhancer.setSuperclass(progammer.getClass());  
 // 设置回调，这里相当于是对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实行intercept()方法进行拦截
        enhancer.setCallback(myMethodInterceptor);
        //创建动态代理类
        Programmer proxy =(Programmer)enhancer.create();
        proxy.code();
        
	}
```

**细节分析：**