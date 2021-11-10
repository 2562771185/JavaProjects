package day3;


import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(date);
        String format = sdf.format(date);
        System.out.println("format = " + format);
        System.out.println("**************");
        Calendar cal = Calendar.getInstance();
        int i = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println("现在是这个月的第 : " + i+"天");
    }
    @Test
    public void test1(){
        Integer a=123;
        Double b=123.213;
        String s1 = b.toString();
        System.out.println("s1 = " + s1);
        String s = a.toString();
        System.out.println("s = " + s);
    }
    @Test
    public void test2(){
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);
        LocalDate date = LocalDate.of(2021, 4, 12);
        System.out.println("date = " + date);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);
        LocalTime localTime = LocalTime.of(12, 12, 12);
        System.out.println("localTime = " + localTime);

    }
    @Test
    public void test3() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf.parse("2020-11-23");
        System.out.println("date = " + date);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }
}
