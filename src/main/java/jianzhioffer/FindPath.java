package jianzhioffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * @auther DuanXiaoping
 * @create 2019-12-12 20:49
 */
public class FindPath {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        this.inErgodic(root, 0, list, target,lists);
        for (int i = 0; i < lists.size()-1; i++) {
            for (int j = 0; j < lists.size()-1; j++) {
                if (lists.get(j).size() < lists.get(j+1).size()){
                    lists.add(j,lists.get(j+1));
                    lists.remove(j+2);
                }
            }
        }
        return lists;
    }

    public void inErgodic(TreeNode root, int num, ArrayList<Integer> list, int target,ArrayList<ArrayList<Integer>> lists) {

        ArrayList<Integer> listcp = (ArrayList<Integer>) list.clone();
        if (num > target) {
            return;
        }

        if (root != null) {
            num += root.val;
//            stack.push(root);
            listcp.add(root.val);
            if (root.left == null && root.right == null && num == target) {
                lists.add(listcp);
            }
            inErgodic(root.left, num, listcp, target,lists);
            inErgodic(root.right, num, listcp, target,lists);
        }
    }

    public TreeNode createTree(int[] vals) {
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

    public static void main(String[] args) {
//        FindPath test = new FindPath();
//        int vals[] = {5, 7, 3, 9, 2, 9, 5, 4, 5, 10, 0, 8, 0, 0, 1,0,0,0,0,1};
//        TreeNode node = test.createTree(vals);
//
//        ArrayList<ArrayList<Integer>> lists = test.FindPath(node, 25);
//        for (ArrayList<Integer> list2 : lists) {
//            for (Integer i : list2) {
//                System.out.print(i);
//            }
//            System.out.println();
//        }
    }
}
