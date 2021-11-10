package day3.LambdaTest;

public class MyLambad {
    public static void main(String[] args) {
        int a=100;
        int b=89;
        Calculable f1 = calculate('+');
        System.out.println("f1 = " + f1.calculate(a,b));
        Calculable f2 = calculate('-');
        System.out.println("f2 = " + f2.calculate(a,b));
        Calculable.f();
        f1.fun();

    }


    public static Calculable calculate(char oper){
        Calculable result;
        //lambda表达式
        if (oper == '+'){
            result = Integer::sum;
        }else{
            result = (int a,int b) -> a - b;
        }
        //普通方式
//        if (oper == '+'){
//            result = (int a,int b) -> {
//                return a + b;
//            };
//        }else{
//            result = (int a,int b) -> {
//                return a - b;
//            };
//        }
        return result;
    }
}
