package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @auther DuanXiaoping
 * @create 2019-12-10 21:53
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int left = 0;
        int right = matrix[0].length;
        int up = 0;
        int down = matrix.length;
        int row = 0;
        int column = 0;
        while (true) {
            /** 右移 */
            while (column < right)
                list.add(matrix[row][column++]);
            /** 右移后 up+1 */
            up++;
            if (up == down) break;
            else {
                row++;
                column--;
            }
//          下移后 right-1
            while (row < down)
                list.add(matrix[row++][column]);
            right--;
            if (right == left)
                break;
            else {
                column--;
                row--;
            }
//          左移后 down -1
            while (column >= left)
                list.add(matrix[row][column--]);
            down--;
            if (down == up)
                break;
            else {
                row--;
                column++;
            }
//          上移后 left+1
            while (row >= up)
                list.add(matrix[row--][column]);
            left++;
            if (left == right)
                break;
            else {
                column++;
                row++;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        PrintMatrix test = new PrintMatrix();
        int[][] array = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
        };
        List<Integer> list = test.printMatrix(array);
        for (Integer i:list) {
            System.out.println(i);
        }
    }
}
