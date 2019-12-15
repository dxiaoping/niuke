package jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * @auther DuanXiaoping
 * @create 2019-12-15 10:46
 */
public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (Integer i : array) {
            map.put(i, (count = map.get(i) == null ? 1 : map.get(i) + 1));
        }
        for (Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() > array.length / 2) {
                return (int) entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MoreThanHalfNum_Solution test = new MoreThanHalfNum_Solution();
//        int array[] = Util.createArray(30, 1, 3);
//        for (Integer i : array) {
//            System.out.print(i + ",");
//        }
        int array[] = {3,3,3,3,3,5,4,6,2};
        System.out.println();
        System.out.println(test.MoreThanHalfNum_Solution(array));

    }
}
