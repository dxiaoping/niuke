import java.util.Scanner;
public class Bishi {
    public static int ways(int x, int y){
        if(x==1 || y==1){
             return x*y+1;
        }
        return ways(x-1,y)+ways(x,y-1);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println(ways(x,y));
        }

    }
}