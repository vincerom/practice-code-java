package top.licz.synax;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型&通配符
 * 泛型类、泛型方法、泛型静态方法、泛型属性
 * Producer extends, Consumer super (PECS原则)
 */
public class Genericity {


    /**
     * 生产者的说明
     *
     * @param humans
     */
    public static void growup(List<? extends Human> humans) {
        // 由于extends的只读不写特性，作为提供数据的生产者
        // 读取：可以调用顶层父类的方法
        humans.forEach(Human::breath);
        // 写入：不可加入非null元素
        // humans.add(new Human());
    }

    /**
     * 消费者的说明
     *
     * @param fathers
     */
    public static void born(List<? super Father> fathers) {
        // 由于super的可读可写特性，作为接收数据的消费者
        // 读取：只能调用Object类的方法，一般无意义
        fathers.forEach(e -> System.out.println(e.hashCode()));
        // 写入：可以加入子类对象
        fathers.add(new Son());
    }


    /**
     * 泛型无层级的说明
     *
     * @param objects
     */
    public static void sumHashCode(List<Object> objects) {
        System.out.println("Sum Hash Code: " + objects.stream().mapToLong(Object::hashCode).sum());
    }


    public static void main(String[] args) {

        // 泛型 -> 泛型一致性 -> 泛型无层级 -> 泛型的局限 -> 通配符
        List<Father> fathers = new ArrayList<>();
        fathers.add(new Father());
        List<Son> sons = new ArrayList<>();
        sons.add(new Son());
        growup(fathers);
        growup(sons);
        List<Human> humans = new ArrayList<>();
        born(humans);

        // 泛型无层级的说明 Object <|===== String , List<Object> <|==X== List<String>
        List<Object> objects = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");

        // compile error
        // sumHashCode(strings);


        {
            // ## 1 ##
            // 无界通配符'?'，该List不能接收任何参数，除了null
            // '?'表示不确定，因此不能是任何一种具体类型，null可以是任何类型，因此可以输入
            List<?> list = new ArrayList<>();
            // 以下一行将产生编译错误
            // list.add("abc");
            list.add(null);
            System.out.println(list);
            // '?'输出永远是Object类型，需要进行显式类型转换
            Object o = list.get(0);
        }

        {
            // ## 2 ## 上界通配符'extends'
            // ，同样不能接收任何参数，除了null
            // List中的元素限定为Father子类，Father可能会有多种不同类型的子类，不是任何一种具体类型
            List<? extends Father> list = new ArrayList<>();
            list = new ArrayList<Son>();
//            list = new ArrayList<Human>();
            // 以下一行将产生编译错误
            // list.add(new Son());
            list.add(null);
            System.out.println(list);
            // 输出参数：自动向上转型到指定的父类，'extends'输出的对象为父类类型
            Father o1 = list.get(0);
        }

        {
            // ## 3 ## 下界通配符'super'
            // 输入参数：指定类型或其子类
            List<? super Father> list;
            list = new ArrayList<Human>();
//            list.add(new Human());
            list.add(new Father());
            list.add(new Son());
            System.out.println(list);
            // 输出参数：自动向上转型，直到最顶层的Object类型，因此需要进行显式类型转换
            Object o2 = list.get(0);
        }

    }


}


class Human {

    public void breath() {
        System.out.print("breath ");
    }

    public void die() {
        System.out.println("awsl");
    }

}

class Father extends Human {

    public void walk() {
        System.out.println("walk");
    }

}

class Son extends Father {

    public void cry() {
        System.out.println("cry");
    }

}

class Daughter extends Father {

}