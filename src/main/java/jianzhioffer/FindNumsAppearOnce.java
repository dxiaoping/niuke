package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
 * @auther DuanXiaoping
 * @create 2019-12-15 19:01
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int result = 0;
        for (Integer i : array) {
            result ^= i;
        }
        int flag = 1;
        while ((result & flag) == 0) {
            flag = flag << 1;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (Integer i : array) {
            if ((i&flag) == flag)list1.add(i);
            else list2.add(i);
        }
        for (Integer i:list1) {
            System.out.print(i);
            num1[0] ^=i;
        }
        System.out.println();
        for (Integer i:list2) {
            System.out.print(i);
            num2[0] ^=i;
        }
        System.out.println();
        System.out.println("数字1："+num1[0]);
        System.out.println("数字2："+num2[0]);
    }

    public static void main(String[] args) {
        FindNumsAppearOnce test = new FindNumsAppearOnce();
        int arrar[] = {1, 2, 3, 6, 5, 4, 7, 8, 9, 10, 15, 9, 8, 7, 4, 5, 6, 3, 2, 1};
        int num1[] = new int[1];
        int num2[] = new int[1];
        test.FindNumsAppearOnce(arrar, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}

