package jianzhioffer;

import java.util.Stack;

/**
 * @Description 获取栈中的最小值
 * @auther DuanXiaoping
 * @create 2019-10-14 10:50
 */
public class StackMin {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        stack1.push(node);
        if (stack2.empty()){
            stack2.push(node);
        }else if (stack2.peek() < node){
            stack2.push(node);
        }else {
            stack2.push(stack2.peek());
        }

    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return this.stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

    public static void main(String[] args) {

    }
}
