package com.example.demo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Properties;

public class App {

    static class Parent {
        public static int i = 1;
        public static final int j=2;
        static {
            i = 2;
            System.out.println(Parent.class.getSimpleName() + " is referred!");
        }
    }

    static class Sub extends Parent {
        public static int i1 = i;
        static {
            System.out.println(Sub.class.getSimpleName() + " is referred!");
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, CloneNotSupportedException, IOException {
        //System.out.println(Sub.i1);//2
        //Class.forName("com.example.demo.App");
        //System.out.println(Sub.i);
        //[] users=new Parent[2];
        //System.out.println(Parent.j);
        //Class.forName("com.example.demo.User").newInstance();
        //User.class.newInstance();
        //Constructor<User> userConstructor=User.class.getConstructor();
        //userConstructor.newInstance();
        //User user1=new User("zrs","123");
        //user1.clone();
        //System.out.println(user1.clone().toString());
        //
        //ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        //ObjectOutputStream objectOutputStream=new ObjectOutputStream(byteArrayOutputStream);
        //objectOutputStream.writeObject(user1);
        //
        //ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        //ObjectInputStream objectInputStream=new ObjectInputStream(byteArrayInputStream);
        //User user2= (User) objectInputStream.readObject();
        //System.out.println(user2.toString());
        //Test test=new TestSub("123444");
        //Class userClass=User.class;
        //Class userClass=Class.forName("com.example.demo.User");
        //User user=new User();
        //Class userClass2=user.getClass();
        //ClassLoader classLoader=ClassLoader.getSystemClassLoader();
        //classLoader.loadClass("com.example.demo.User");
        //Objenesis objenesis = new ObjenesisStd(true);
        //User user3 = objenesis.newInstance(User.class);
        Class userClass=Class.forName("com.example.demo.User");
        ////??????????????????????????????
        //Constructor[] constructors=userClass.getConstructors();
        //for(Constructor constructor:constructors){
        //
        //    System.out.println(constructor);
        //}
        //// ???????????????????????????(?????????????????????????????????????????????)
        //Constructor[] constructors1=userClass.getDeclaredConstructors();
        //for(Constructor constructor:constructors1){
        //
        //    System.out.println(constructor);
        //}
        ////????????????????????????????????????
        //Constructor constructor=userClass.getConstructor(null);
        //User user1=(User)constructor.newInstance();
        //user1.print();
        ////????????????????????????????????????
        Constructor constructor3=userClass.getConstructor(String.class,String.class);
        User user3=(User)constructor3.newInstance("zrs","11111");
        //user3.print();
        //// ????????????????????????
        //Constructor constructor1=userClass.getDeclaredConstructor(Integer.class);
        //// ???????????? private ??????/??? ??????????????????????????????
        //constructor1.setAccessible(true);
        //User user2=(User)constructor1.newInstance(1);
        //user2.print();
        //???????????????????????????
        Method method=userClass.getMethod("print",null);
        Object object=method.invoke(user3);
        System.out.println(object);
        //???????????????????????????
        Method method1=userClass.getDeclaredMethod("print",String.class);
        //??????????????????
        method1.setAccessible(true);
        Object object1=method1.invoke(user3,"zzz");
        System.out.println(object1);
        //??????????????????Class??????
        Class clazz=Class.forName(getName("className"));
        //??????print??????
        Method method2=clazz.getMethod(getName("methodName"));
        //??????print??????
        method2.invoke(user3);

    }
    public static String getName(String key) throws IOException {
        Properties properties=new Properties();
        InputStreamReader inputStreamReader=new InputStreamReader(Objects.requireNonNull(App.class.getClassLoader().getResourceAsStream("application.properties")));
        properties.load(inputStreamReader);
        inputStreamReader.close();
       return (String) properties.get(key);
    }
}
