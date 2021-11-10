package day7;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @PACKAGE_NAME: day7
 * @author: JHZZ
 * @date: 2021/10/27 12:53
 * @PROJECT_NAME: JavaProjects
 */
public class BufferdTest {
    public static void main(String[] args) {

        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(new File("WechatIMG14347.jpeg")));
            out = new BufferedOutputStream(new FileOutputStream(new File("2.jpeg")));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param src
     * @param res
     */
    public static void wordCount(String src, String res) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            fr = new FileReader(src);
            fw = new FileWriter(res);

            int c;
            while ((c = fr.read()) != -1) {
                char ch = (char) c;
                // 第一次出现
                if (map.get(ch) == null) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            }
            //写入数据
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entrySet) {
                switch (entry.getKey()) {
                    case ' ':
                        fw.write("空格 : " + entry.getValue());
                        break;
                    case '\n':
                        fw.write("回车 : " + entry.getValue());
                        break;
                    case '\t':
                        fw.write("tab : " + entry.getValue());
                        break;
                    default:
                        fw.write(entry.getKey() + " : " + entry.getValue());
                        break;
                }
                fw.write("\n");
            }
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
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    @Test
    public void test(){
        wordCount("/Users/yiyangqianxi/IdeaProjects/JavaProjects/src/day7/MyStack.java","res.txt");
    }

    @Test
    public void test1() throws IOException {
        FileInputStream inputStream = new FileInputStream("/Users/yiyangqianxi/IdeaProjects/JavaProjects/src/day7/MyStack.java");
        InputStreamReader reader = new InputStreamReader(inputStream);

        char[] data = new char[10];
        int len;

        while ((len = reader.read(data)) != -1){
            String s = new String(data, 0, len);
            System.out.print(s);
        }
        reader.close();
    }
    @Test
    public void test2() throws Exception {
        InputStreamReader streamReader = new InputStreamReader(new FileInputStream("a.txt"), "utf-8");
        OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream("ee.txt"), "gbk");

        char[] s = new char[10];
        int len;
        while ((len = streamReader.read(s)) != -1){
            streamWriter.write(s, 0, len);
        }
        streamReader.close();
        streamWriter.close();


    }
}
