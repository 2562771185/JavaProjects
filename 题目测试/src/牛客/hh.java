package 牛客;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @PACKAGE_NAME: 牛客
 * @author: JHZZ
 * @date: 2021/11/1 15:49
 * @PROJECT_NAME: JavaProjects
 */
public class hh {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //write your code here......
        double avg=0;
        int sum=0;
        int count=0;
        while(true){
            int num=scan.nextInt();
            if(num < 0){
                break;
            }
            sum+=num;
            count++;
        }
        avg=sum/count;

        System.out.println(String.format("%.2f",avg));

    }
    @Test
    public void test01(){

    }
    public Boolean palindromeNumber(int number) {

        List<Integer> list = new ArrayList<>();
        //write your code here......
        while(number > 0){
            list.add(number%10);
            number/=10;
        }
        int l=0;
        int r=list.size();
        while (l < r){
            if (list.get(l) != list.get(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
