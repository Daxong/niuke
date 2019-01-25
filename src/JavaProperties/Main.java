package JavaProperties;


class A {
    static {
        System.out.println("Static init A.");
    }

    {
        System.out.println("Instance init A.");
    }

    A() {
        System.out.println("Constructor A.");
    }
}

class B extends A {
    static {
        System.out.println("Static init B.");
    }

    {
        System.out.println("Instance init B.");
    }

    B() {
        System.out.println("Constructor B.");
    }
}

class C extends B {

    static {
        System.out.println("Static init C.");
    }

    {
        System.out.println("Instance init C.");
    }

    C() {
        System.out.println("Constructor C.");
    }
}

public class Main {

    static {
        System.out.println("Static init Main.");
    }

    {
        System.out.println("Instance init Main.");
    }

    public Main() {
        System.out.println("Constructor Main.");
    }

    public static void main(String[] args) {
        C c = new C();
        //B b = new B();
    }
}

/*
父类的静态初始化块
子类的静态初始化块
父类的初始化块
父类的构造函数
子类的初始化块
子类的构造函数
 */