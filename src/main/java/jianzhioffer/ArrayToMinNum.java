package jianzhioffer;

/**
 * @Description 整数数组转换成最小的数
 * @auther DuanXiaoping
 * @create 2019-12-08 12:52
 */
public class ArrayToMinNum {
    public String PrintMinNumber(int[] numbers) {
        StringBuffer minNum = new StringBuffer();
        String strArray[] = new String[numbers.length];
        for (int i=0;i<numbers.length;i++){
            strArray[i] = Integer.toString(numbers[i]);
        }
////       冒泡排序对字符串排序
        for (int i=0;i<strArray.length;i++){
            for (int j=0;j<strArray.length-i-1;j++){
                if ((strArray[j+1]+strArray[j]).compareTo(
                        strArray[j] + strArray[j+1]) < 0){
                    String str = strArray[j];
                    strArray[j] = strArray[j+1];
                    strArray[j+1] = str;
                }
            }
        }

        for (int i=0;i<strArray.length;i++){
            minNum.append(" ");
            minNum.append(strArray[i]);
        }
        System.out.println(minNum);
        return minNum.toString();
    }

    public static void main(String[] args) {
        ArrayToMinNum test = new ArrayToMinNum();
        int testArray[] = {486,3333,28,230,222,976,1110,351,355};
        test.PrintMinNumber(testArray);
        int testArray1[] = {222,486,1110,976,351,3333,28,355,230};
        test.PrintMinNumber(testArray1);
        int testArray2[] = {3333,28,976,486,355,1110,222,351,230};
        test.PrintMinNumber(testArray2);
        int testArray3[] = {1110,28,3333,486,976,351,222,355,230};
        test.PrintMinNumber(testArray3);
        int testArray4[] = {321,32,3};
        test.PrintMinNumber(testArray4);

//        System.out.println("1110".compareTo("222"));
    }
}
