package 牛客;

public class Main {
    public static void main(String[] args) {
        System.out.println(Math.floor(-8.5));
    }

}


class Shape {

    private double s; // 周长

    public Shape(double s) {
        this.s = s;
    }

    public double getS() {
        return s;
    }

}

interface Area {
    double getArea(); // 面积
}

// 圆形
class Circle extends Shape implements Area {

    //write your code here......
    Circle(double s){
        super(s);
    }
    public double getArea(){
        //先求半径
        double r=getS()/(2*Math.PI);

        return r*r*Math.PI;
    }

}

// 方形
class Square extends Shape implements Area {

    //write your code here......
    Square(double s){
        super(s);
    }
    public double getArea(){
        double r=getS()/4;

        return r*r;
    }

}