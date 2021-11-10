package day7;

import org.junit.Test;

import java.io.*;

/**
 * @PACKAGE_NAME: day7
 * @author: JHZZ
 * @date: 2021/10/26 15:30
 * @PROJECT_NAME: JavaProjects
 */
public class FileWriterTest {
//    public static void main(String[] args) {
//        // String s = "123";
//        StringBuffer sf = new StringBuffer("");
//
//        FileReader fr = null;
//        try {
//            File file = new File("a.txt");
//
//            fr = new FileReader("a.txt");
////        FileReader fileReader = new FileReader();
//            char[] chars = new char[10];
//            //int data = fr.read();
//            int len;
//            while ((len = fr.read(chars)) != -1) {
////                for (int i = 0; i < len; i++) {
////                    System.out.print(chars[i]);
////                }
//                sf.append(chars, 0, len);
//            }
//            System.out.println("sf = " + sf);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fr != null) {
//                try {
//                    fr.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }
public static void main(String[] args) {
    copyFile("a.txt","d.txt");

}

    public static void copyFile(String src, String dest) {
        long start = System.currentTimeMillis();
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(new File(src));
            os = new FileOutputStream(new File(dest));

            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            System.out.println("复制完成！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            long end = System.currentTimeMillis();
            System.out.println("消耗时间：" + (end - start));
        }

    }

    @Test
    public void test() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("a.txt");

            fw.write("12341312356");
            fw.write("78eqwff910");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1() {
        FileWriter writer = null;
        FileReader reader = null;
        try {
            writer = new FileWriter(new File("c.txt"));
            reader = new FileReader(new File("b.txt"));

            char[] data = new char[3];
            int len;

            while ((len = reader.read(data)) != -1) {
                writer.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3() {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(new File("1.jpeg"));
            os = new FileOutputStream(new File("2.jpeg"));

            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
