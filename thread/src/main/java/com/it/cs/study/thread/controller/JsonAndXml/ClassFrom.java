package com.it.cs.study.thread.controller.JsonAndXml;

/**
 * @Description 反射
 * @Author cuishuai
 * @Date 2019/12/18 9:57
 */

import com.it.cs.study.thread.entity.User;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;


/**
 * 1.json 和 jsonp有什么区别 ： jsonp（只能是get请求） 跨域 json 做数据传输
 * 2.什么是反射：就是正在运行，动态获取这个类的所有信息
 * 3.反射的作用 ： 1 反编译  class-java  2.通过反射机制访问java对象的属性  方法 构造方法等
 * 3.反射应用场景 ： jdbc加载驱动  springIoc实现 框架
 */

public class ClassFrom {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        /*//1.除了new创建对象 还可以通过反射机制创建对象
        //User userEntity = new User();
        //2.forName 必须传入class类的完整路径
        Class<?> forName = Class.forName("com.it.cs.study.thread.entity.User");
        //3.newInstance使用无参构造函数 构造实体类对象
        Object newInstance = forName.newInstance();
        User user = (User)newInstance;
        System.out.println("user:" + user);
        user.setUserId("123");
        System.out.println(user.getUserId());
        //使用反射技术 创建对象 和new  哪个效率高?   new效率高*/




        //有参构造函数
       /* Class<?> forName = Class.forName("com.it.cs.study.thread.entity.User");
        Constructor<?> constructor = forName.getConstructor(String.class);
        Object newInstance = constructor.newInstance("1");//有参构造函数
        User user = (User) newInstance;*/

        //获取类的属性   方法
        Class<?> forName = Class.forName("com.it.cs.study.thread.entity.User");
        //获取该类的所有方法
        /*Method[]  declaredMethods = forName.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            System.out.println(declaredMethods[i].getName() + "---------------------" + declaredMethods[i].getReturnType());
        }*/
        //获取所有的成员属性
        /*Field[] declaredFields = forName.getDeclaredFields();
        for(Field field : declaredFields){
            System.out.println(field.getName());
        }*/
        //为什么继承里面没有拿到  只能拿到当前类的 不会拿父类的  以Decl开头的


        //可以使用 java的 反射技术 可以访问到私有属性
        Field de = forName.getDeclaredField("userId");
        Object object = forName.newInstance();
        //允许访问私有成员属性
        de.setAccessible(true);
        de.set(object,"123");
        User user = (User)object;
        System.out.println(user.getUserId());
    }
}
