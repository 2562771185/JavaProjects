package day3.EnumTest;

/**
 * @PACKAGE_NAME: day3.EnumTest
 * @author: yiyangqianxi
 * @date: 2021/10/15 19:22
 * @PROJECT_NAME: JavaProjects
 */
public class Enumtest {
    public static void main(String[] args) {
        En day = En.FRIDAY;
        System.out.println(day);
        switch (day) {
            case MONDAY:
                System.out.println("星期一");
                break;
            case TUESDAY:
                System.out.println("星期二");
                break;
            case WEDNESDAY:
                System.out.println("星期三");
                break;
            case THURSDAY:
                System.out.println("星期四");
                break;
            case FRIDAY:
                System.out.println("星期五");
                break;
            default: {
                System.out.println("Error");
            }
        }
        En[] v = En.values();
        for (En values : v) {
            System.out.println("values = " + values);
        }
        En day2 = En.valueOf("FRIDAY");
        System.out.println("day2 == day " + (day2 == day));
    }
}

enum En {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}
