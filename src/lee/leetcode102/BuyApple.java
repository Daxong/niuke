package lee.leetcode102;

/**
 * 三七互娱笔试算法题
 * 买苹果，要么6个装要么8个装，要买n个苹果，试问怎么买袋数最少，返回袋数，如不能刚好买到所需苹果，则不买 返回-1；
 */
public class BuyApple {
    public static void main(String[] args) {
        System.out.println(sumPacket(20));
    }

    public static int sumPacket(int n){
        int sum = 0;
        if (n == 6 || n == 8){
            sum = 1;
            return sum;
        }
        if (n > 8 ) {
            int sum1 = sumPacket(n-6);
            int sum2 = sumPacket(n-8);
            if (sum1 == -1 && sum2 != -1){
                return sum2+1;
            }
            if (sum2 == -1 && sum1 != -1){
                return sum1+1;
            }
            if (sum2 != -1 && sum1 != -1) {
                return Math.min(sum2,sum1)+1;
            }
        }

        sum = -1;
        return sum;

    }
}
