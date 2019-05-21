package leetcode;

public class ClimbStair {

    public static void main(String[] args) {

        System.out.println(stair(3));
    }

    public static int stair(int n) {
        int sum = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n > 2) {
            return stair(n - 2) + stair(n - 1);
        }

        return sum;
    }
}

