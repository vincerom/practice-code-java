package top.licz.synax;

/**
 * Java继承
 * 1. 单继承，只能继承某一个父类
 * 2. private方法不能被继承，其他访问权限被继承时，访问权限不能缩小
 *
 * @author vince
 */
public class Extends {
    public static void main(String[] args) {

        // 父类型实现子类
        A b = new B();

//        // 只能调用类A中的方法
//        b.method5();



    }
}

class B extends A {
    // order 6
    public B() {
        System.out.println("子类构造方法");
    }

    // order 5
    {
        System.out.println("子类构造语句块");
    }

    // order 2
    static {
        System.out.println("子类静态语句块");
    }

    /**
     * 与父类中的method1完全是不同的方法，无继承关系
     */
    public int method1(int a, int b) {
        return 0;
    }

    /**
     * 属于重载
     */
    public int method2(int a) {
        return 0;
    }

//    /**
//     * syntax error
//     * 权限不能缩小
//     */
//    private int method3(int a, int b) {
//        return 0;
//    }

//    /**
//     * 重载时返回值类型必须要同父类的方法
//     */
//    public void method4(int a, int b) {
//    }

    /**
     * 继承父类的method4方法
     */
    @Override
    public int method4(int a, int b) {
        return 1;
    }

    /**
     * 属于class B的方法
     */
    public int method5(int a) {
        return a;
    }
}


/**
 * Base父类
 */
class A {
    // order 4
    public A() {
        System.out.println("父类构造方法");
    }

    // order 3
    {
        System.out.println("父类构造语句块");
    }

    // order 1
    static {
        System.out.println("父类静态语句块");
    }

    /**
     * 对子类不可见，子类中同名方法相当与不同的方法
     */
    private int method1(int a, int b) {
        return 0;
    }

    /**
     * 继承时，访问权限只能为default, protected或者public
     */
    int method2(int a, int b) {
        return 0;
    }

    /**
     * 继承时，访问权限只能为protected或者public
     */
    protected int method3(int a, int b) {
        return 0;
    }

    /**
     * 继承时，访问权限只能为public
     */
    public int method4(int a, int b) {
        return 0;
    }
}
