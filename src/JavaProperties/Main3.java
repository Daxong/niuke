package JavaProperties;

import java.util.Scanner;

/**
 * 快手2019春招 工程A卷
 * 统计可访问节点个数，具体题目略
 */
public class Main3 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] nums = scan.nextLine().split(" ");
        int n = Integer.valueOf(nums[0]);
        int m = Integer.valueOf(nums[1]);
        int k = Integer.valueOf(nums[2]);
        int[][] dp = new int[n+1][m+1];
        way(0,0,n,m,k,dp);
        System.out.println(count);
        // 1 代表已访问
        // 2 代表碰壁
    }
    public static void way(int x,int y ,int n, int m, int k , int[][] dp){
        if (x >= n || y >= m || x < 0 || y < 0) return;
        if (dp[x][y] == 1 || dp[x][y] == 2) return;
        int sum = calc(x)+calc(y);
        if (sum > k) {
            dp[x][y] = 2;
            return;
        }
        dp[x][y] = 1;
        count++;
        way(x+1,y,n,m,k,dp);
        way(x-1,y,n,m,k,dp);
        way(x,y+1,n,m,k,dp);
        way(x,y-1,n,m,k,dp);
    }

    private static int calc(int nums){
        char[] charsX = String.valueOf(nums).toCharArray();
        Integer sum = 0;
        for (int i = 0; i < charsX.length; i++) {
            sum += Integer.parseInt(charsX[i]+"");
        }
        return sum;
    }
}
