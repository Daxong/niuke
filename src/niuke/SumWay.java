package niuke;

import java.util.Scanner;

/**
 * 有一个X*Y的网格，小团要在此网格上从左上角到右下角，只能走格点且只能向右或向下走。
 * 请设计一个算法，计算小团有多少种走法。给定两个正整数int x,int y，请返回小团的走法数目。
 */
public class SumWay{
    public static int sumWay(int x, int y){
        int[][] dp = new int[x][y];
        for (int i = 0; i < x; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < y; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1 ; j < y; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1]+2;
            }
        }
        return dp[x-1][y-1]+2;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        System.out.println(sumWay(x,y));
    }
}