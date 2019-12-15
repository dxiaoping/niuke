package jianzhioffer;

/**
 * @Description 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 *              给一个数组，返回它的最大连续子序列的和，
 * @auther DuanXiaoping
 * @create 2019-12-15 10:11
 */
public class FindGreatestSumOfSubArray {

   /**数组遍历解题*/
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = 0;
        int max = -Integer.MAX_VALUE;
        for (Integer i : array) {
            sum = sum < 0 ? i : sum + i;
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FindGreatestSumOfSubArray test = new FindGreatestSumOfSubArray();
        int array[] = {1, 8, -10, 9, 47, -32, 11, 20, 2, -5, 3};
        System.out.println(test.FindGreatestSumOfSubArray(array));
    }
}
