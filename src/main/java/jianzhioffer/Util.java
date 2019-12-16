package jianzhioffer;

import jianzhioffer.pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Description 创建测试数据工具包
 * @auther DuanXiaoping
 * @create 2019-12-15 10:48
 */
public class Util {
    public static Random random = new Random();

    public static int getRandomInt(int min, int max){
        int range = max - min+1;
        return random.nextInt(range) + min;
    }

    public static int[] createArray(int length, int min, int max) {
        int array[] = new int[length];
        int range = max - min+1;
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(range) + min;
        }
        return array;
    }

    public static TreeNode createTree(int[] vals) {
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < vals.length; i++) {
            if (vals[i] != 0) {
                TreeNode node = new TreeNode(vals[i]);
                map.put(i, node);
            }
        }
        for (int i = 0; i < vals.length; i++) {
            if (map.get(i) != null) {
                map.get(i).left = map.get(2 * (i + 1) - 1);
//                System.out.println(map.get(i).val + "的左边为");
                map.get(i).right = map.get(2 * (i + 1));
            }
        }

        return map.get(0);
    }
}
