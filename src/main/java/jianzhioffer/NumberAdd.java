package jianzhioffer;

/**
 * @Description 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @auther DuanXiaoping
 * @create 2019-12-16 20:32
 */
public class NumberAdd {
    public int Add(int num1, int num2) {
        int flag = 1;
        ;
        int sum = 0;
//        int tempNum1 = num1 & flag;
        int tempNum2 = 1;
        /**
         * 相同时（值为0）需判断是否要进位
         */
        while (num2 >= flag) {
            tempNum2 = num2 & flag;
            while (((num1 ^ tempNum2) & tempNum2) == 0) {
                if ((num1 & tempNum2) == flag) {
                    num1 = num1 ^ tempNum2;
                    tempNum2 = tempNum2 << 1;
                } else break;
            }
            num1 = num1 ^ tempNum2;
            flag = flag << 1;
        }
        return num1;
    }

    public static void main(String[] args) {
        NumberAdd test = new NumberAdd();
        for (int i = 0; i < 20; i++) {
            int a = Util.getRandomInt(0, 70);
            int b = Util.getRandomInt(0, 70);
            System.out.println(a + "+" + b + "=" + test.Add(a, b));
        }
//            System.out.println(test.Add(-11, 16));

    }
}
