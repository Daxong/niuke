package leetcode;

import java.util.Scanner;

/**
 * @author yfy
 * @version : ArrangeVM.java,v 0.1 2019年08月31日 9:17 PM
 */
public class ArrangeVM {

    public static void main(String[] args) {
        // n个订单
        int n;

        // cpu数量
        int x;

        // 内存大小
        int y;

        // 每个订单GPU数
        int[] a;

        // 每个订单内存数
        int[] b;

        // 每个订单的价值
        int[] w;

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        x = scan.nextInt();
        y = scan.nextInt();
        a = new int[n + 1];
        b = new int[n + 1];
        w = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
            b[i] = scan.nextInt();
            w[i] = scan.nextInt();
        }
        scan.close();
        int solve = solve(n,x,y,a,b,w);
        System.out.println(solve);
    }

    public static int solve(int n, int x, int y, int[] a, int[] b, int[] w) {
        int[][] dp = new int[x+1][y+1];
        for(int i = 1; i <= n; i++){
            for(int j = x; j >= 1; j--){
                for(int k = y; k>= 1; k--){
                    if(j < a[i] || k < b[i]){
                        //超过条件限制 不选
                        dp[j][k] = dp[j][k];
                    }else {
                        dp[j][k] = Math.max(dp[j][k], dp[j-a[i]][k-b[i]] + w[i]);
                    }
                }
            }
        }
        return dp[x][y];
    }

}
