package jianzhioffer;


import java.util.HashMap;
import java.util.Map;

/**
 * @Description 在一个字符串(0<=字符串长度<=10000，全部由字母组成)
 *              中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1
 * @auther DuanXiaoping
 * @create 2019-12-09 21:28
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {

        char chars[] = str.toCharArray();
        int index = -1;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < chars.length; i++) {
            String char2str = String.valueOf(chars[i]);
            if (map.get(char2str) != null) {
                map.put(char2str, map.get(char2str) + 1);
            } else {
                map.put(char2str, 1);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(String.valueOf(chars[i])) == 1) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar test = new FirstNotRepeatingChar();
        String str = "ubgvoeNuirsgvauoebweuipfjiwoavpnirufdviHWJFIOVN";
        System.out.println(test.FirstNotRepeatingChar(str));
    }
}
