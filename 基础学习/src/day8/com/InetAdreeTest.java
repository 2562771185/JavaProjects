package day8.com;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @PACKAGE_NAME: day8
 * @author: JHZZ
 * @date: 2021/10/27 19:27
 * @PROJECT_NAME: JavaProjects
 */
public class InetAdreeTest {
    public static void main(String[] args) {
        try {
            InetAddress all = InetAddress.getByName("www.vip.top");
            System.out.println("all = " + all);

            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("localHost = " + localHost);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}

