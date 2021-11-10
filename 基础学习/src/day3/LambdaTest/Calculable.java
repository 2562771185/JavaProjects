package day3.LambdaTest;

@FunctionalInterface
public interface Calculable {
    int calculate(int a,int b);

    //静态方法
    static void f() {
        System.out.println("Calculable.f 静态方法");
    }
    //默认方法
    default void fun() {
        System.out.println("Calculable.fun 默认方法");
    }
}
