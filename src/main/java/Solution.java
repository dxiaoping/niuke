import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution {
    public String leftRotateString(String str,int n) {
        if(str.length() == 0 || str == null){
            return "";
        }
         else if (n < 0){
            n = -n;
            return str.substring(str.length() - n%str.length()) + str.substring(0,str.length() - n%str.length());
        }else {
            return str.substring(n%str.length()) + str.substring(0,n%str.length());
        }
    }

    public String reverseSentence(String str) {
        String returnStr="";
        if (str.length() > 0 ){
            String[] splitStr = str.split(" ");
            System.out.println(splitStr.length);
            if (splitStr.length == 0)return str;
            for (int i = splitStr.length - 1; i >= 0; i--){
                if (i == 0){
                    returnStr = returnStr + splitStr[i];
                }else {
                    returnStr = returnStr + splitStr[i] + " ";
                }
            }
        }
        return returnStr;
    }

    public boolean isContinuous(int [] numbers) {

        return false;
    }

    public int lastRemaining_Solution(int n, int m) {
        ArrayList<Integer> persons = new ArrayList<Integer>();
        for (int i = 0; i < n; i++ ){
            persons.add(i);
        }
        int flag = 0,i=0;
        while (persons.size() > 1){
            flag++;
            if (flag++ ==7 && (i+=flag) < persons.size()){
                System.out.println(persons.remove(i));
                flag=0;
                i--;
            }
        }
        return persons.get(0);
    }


    public int roadQuery(){
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();

        x = x + 1;
        y = y + 1;
        int nodeCount = x * y;
        for (int i = 0; i < nodeCount; i++){

        }
        System.out.printf("%d %d",x,y);
        return 0;
    }


    // 剑指offer 剪绳子
//    public int cutRope(int target) {
//
//    }

    // 剑指offer 跳台阶
    public int JumpFloor(int target) {

        if (target < 3){
            return target;
        }else {
            return JumpFloor(target-1) + JumpFloor(target-2);
        }

    }

//    凑齐n分钱
    public int countWays(int[] coins,int n) {

        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 0;i < coins.length;++i){
            for(int j = coins[i];j <= n;++j){
                dp[j] += dp[j-coins[i]];
                System.out.format("dp[%d] += dp[%d-%d] -- %d\n",j,j,coins[i],dp[j]);
//                System.out.format("dp[%d] = %d\n",j,dp[j]);
            }
        }
        return dp[n];
    }

    //镜像二叉树
    public void Mirror(TreeNode root) {

    }


    public static void main(String[] args) {
        Solution obj = new Solution();
//        System.out.println(obj.leftRotateString("abcdefg",3));
//        System.out.println(obj.reverseSentence("student. a an I"));
//        int a[] = {1,2,8,7,0};
//        System.out.println(obj.isContinuous(a));
//        System.out.println(obj.lastRemaining_Solution(50,7));
//        obj.roadQuery();
//        int a[] = {1,2,5};
//        System.out.println(obj.countWays(a,6));

//        System.out.println(obj.JumpFloor(5));


//        Object[] objs = {0,1,2,3,4,5,6,null,7};
//        BinTree binTree = new BinTree();
//        binTree.createTree(objs);
//
//        binTree = binTree.mirror(binTree.getRoot());
//        binTree.preorder(binTree);
//        System.out.println("前序遍历");
//
//        binTree.inorder(binTree);//7 3 1 4 0 5 2 6
//        System.out.println("中序遍历");
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}


//构建二叉树
class BinTree {
    private BinTree lChild;//左孩子
    private BinTree rChild;//右孩子
    private BinTree root;//根节点
    private Object data;//数据域
    public BinTree(){}
    public BinTree(BinTree lChrild,BinTree rChild,Object data){
        this.lChild = lChrild;
        this.rChild = rChild;
        this.data = data;
    }
    public BinTree(Object data){
        this(null, null, data);
    }

    public void createTree(Object[] objects){
        List<BinTree> datas = new ArrayList<>();//存储所有节点
        for(Object obj:objects){
            datas.add(new BinTree(obj));
        }
        root = datas.get(0);//将一个作为根节点
        for(int i = 0;i < objects.length/2;i++){
            datas.get(i).lChild = datas.get(2*i+1);
            if(2*i+2 < objects.length){//避免偶数的时候，下标越界
                datas.get(i).rChild = datas.get(2*i+2);
            }
        }
    }

    //先序遍历
    public void preorder(BinTree root){
        if(root != null){
            visit(root.getData());
            preorder(root.lChild);
            preorder(root.rChild);
        }
    }
    //中序遍历
    public void inorder(BinTree root){
        if(root != null){
            inorder(root.lChild);
            visit(root.getData());
            inorder(root.rChild);
        }
    }

    public void afterorder(BinTree root){
        if(root != null){
            afterorder(root.lChild);
            afterorder(root.rChild);
            visit(root.getData());
        }
    }

    //镜像二叉树
    public BinTree mirror(BinTree root){
        if(root != null){
            BinTree p = root.lChild;
            root.lChild = root.rChild;
            root.rChild = p;
            mirror(root.lChild);
            mirror(root.rChild);
//            visit(root.getData());
        }
        return root;
    }

    //输出二叉树

    public void visit(Object obj) {
        System.out.print(obj+" ");
    }
    public Object getData() {
        return data;
    }
    public BinTree getRoot() {
        return root;
    }

//    public static void main(String[] args) {
//        Object[] objs = {0,1,2,3,4,5,6,7};
//        BinTree binTree = new BinTree();
//        binTree.createTree(objs);
//
//        binTree.inorder(binTree.getRoot());//7 3 1 4 0 5 2 6
//        System.out.println();
//        binTree.preorder(binTree.getRoot());//0 1 3 7 4 2 5 6
//        System.out.println();
//        binTree.afterorder(binTree.getRoot());//7 3 4 1 5 6 2 0
//    }
}