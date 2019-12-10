package jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
 * @auther DuanXiaoping
 * @create 2019-12-08 21:04
 *
 * @Answer 9，99，999，9999.。。。。存在“1”的个数分别为
 *           1，20，300，4000.。。。a[i]=a[i - 1] * 10 + Math.pow(10, i - 1)
 *           即 将2759486可拆分为6，80，400，9000，50000，700000，2000000 求包含1的和
 *            未考虑到最高位为1时的情况
 */
public class NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int baseNum[] = new int[10];
        baseNum[0] = 0;//个位数存在的1数量
        for (int i = 1; i < 10; i++) {
            baseNum[i] = (int) (baseNum[i - 1] * 10 + Math.pow(10, i - 1));
        }
//        for (int i = 0;i < 10; i++){
//            System.out.println(baseNum[i]);
//        }
        List<Integer> list = new ArrayList<Integer>();
        while (n != 0) {
            list.add(n % 10);
            n = n / 10;
        }
        int count1 = 0;

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (num == 0) {
                continue;
            }
            if (num == 1) {
                count1 += num * baseNum[i] + n + 1;
            } else {
                count1 += num * baseNum[i] + Math.pow(10, i);
            }
            n += num * Math.pow(10, i);
        }
        return count1;
    }

    public static void main(String[] args) {
        NumberOf1Between1AndN test = new NumberOf1Between1AndN();

//        System.out.println(test.NumberOf1Between1AndN_Solution(32305075));
//        System.out.println(test.NumberOf1Between1AndN_Solution2(32305075));
        for (int i = 0; i < 100; i++) {
            System.out.println(test.NumberOf1Between1AndN_Solution(i));
            System.out.println(test.NumberOf1Between1AndN_Solution2(i));
            System.out.println();
        }

    }

    public int NumberOf1Between1AndN_Solution2(int n) {
        int count1 = 0;
        StringBuffer str = new StringBuffer();
        for (int i = 0; i <= n; i++) {
            str.append(Integer.toString(i));
        }
        String str1 = str.toString();
        char[] chars = str1.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                count1++;
            }
        }
        return count1;
    }
}
