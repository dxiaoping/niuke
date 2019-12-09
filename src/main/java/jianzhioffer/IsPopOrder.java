package jianzhioffer;

import java.util.Stack;

/**
 * @Description 判断一个序列是否为一个入栈序列的出栈序列
 * @auther DuanXiaoping
 * @create 2019-10-14 14:07
 */
public class IsPopOrder {
    /**
     * 将入栈数全部压入栈内，遇到需要出栈的数即时取出
     * 最后循环出栈判断出栈和出栈序列是否相同
     * 若相同则队列最后为空
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean isPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack1 = new Stack<Integer>();
        boolean result = false;;
        int j=0;
        for(int i = 0; i < popA.length; i++){
            if(j == pushA.length){
                if(popA[i] == stack1.peek()){
                    stack1.pop();
                }
            }else{
                while (j < pushA.length){
                    stack1.push(pushA[j]);
                    j++;
                    if(popA[i] == stack1.peek()){
                        stack1.pop();
                        break;
                    }
                }
            }
        }
        if (stack1.size()==0)result = true;
        return result;
    }

    public static void main(String[] args) {
//        int[] a={1,2,3,4,5};
//        int[] b={4,5,3,2,1};
        int[] a={1};
        int[] b={4};
        System.out.println(IsPopOrder.isPopOrder(a,b));
    }
}
