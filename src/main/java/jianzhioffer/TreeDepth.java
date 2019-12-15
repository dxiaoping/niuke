package jianzhioffer;

import jianzhioffer.pojo.TreeNode;

import java.lang.reflect.Field;

/**
 * @Description 求数的深度
 *              判断是否为平衡树
 * @auther DuanXiaoping
 * @create 2019-12-15 11:41
 */
public class TreeDepth {

    /***/
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depthL = TreeDepth(root.left);
        int depthR = TreeDepth(root.right);
        return depthL > depthR ? depthL + 1 : depthR + 1;
    }

    /**方法一：从数的顶端开始进行判断是否平衡，存在重复遍历问题*/
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int depthL = TreeDepth(root.left);
        int depthR = TreeDepth(root.right);
        if (depthL - depthR > 1 || depthL - depthR < -1) {
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }




    public static void main(String[] args) {
        TreeDepth test = new TreeDepth();
        int vals[] = {5, 7, 3, 9, 2, 9, 5, 4, 5, 10, 0, 8, 0, 0, 1, 0, 0, 0, 0};
//        int vals[] = {5, 4, 0, 9, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        TreeNode root = Util.createTree(vals);
//        System.out.println(test.TreeDepth(root));
//        System.out.println(test.IsBalanced_Solution(root));
        System.out.println(test.IsBalanced_Solution2(root));
    }


    /**方法二：从数的底端开始进行判断是否平衡避免重复遍历*/
    public boolean IsBalanced_Solution2(TreeNode root) {
        int depth = 0;
        return IsBalanced2(root, depth);

    }

    public boolean IsBalanced2(TreeNode root, Integer depth) {
        if (root == null) {
            depth = 0;
            return true;
        }
        Integer depthL = new Integer(0);
        Integer depthR = new Integer(0);
        if (IsBalanced2(root.left, depthL)
                && IsBalanced2(root.right, depthR)
        ) {
            int diff = depthL - depthR;
            if (diff <= 1 && diff >= -1) {
                modifyInteger(depth,1 + (depthL > depthR ? depthL : depthR));
                return true;
            }
        }
        return false;
    }

    public void modifyInteger(Integer a1,int num){
        Field field = null;
        try {
            field = a1.getClass().getDeclaredField("value");
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        field.setAccessible(true);

        try {
            field.set(a1, num);
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
