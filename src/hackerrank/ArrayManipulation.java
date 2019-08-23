package hackerrank;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author yfy
 * @version : Solution.java,v 0.1 2019年08月23日 10:27
 * 解析：https://stackoverflow.com/questions/48162233/logic-used-behind-array-manipulation-of-hackerrank/48331165#48331165
 */
public class ArrayManipulation {
    public static void solve() throws IOException
    {
        Scanner scan = new Scanner(System.in);
        String[] nums = scan.nextLine().split(" ");
        int N = Integer.parseInt(nums[0]), M = Integer.parseInt(nums[1]);
        long[] plus = new long[N + 1], minus = new long[N + 1];

        for (int i = 0; i < N + 1; i++)
            plus[i] = minus[i] = 0;

        for (int i = 0; i < M; i++)
        {
            nums = scan.nextLine().split(" ");
            int a = Integer.parseInt(nums[0]), b = Integer.parseInt(nums[1]);
            int k = Integer.parseInt(nums[2]);

            plus[a - 1] += k;
            minus[b] += k;
        }

        long ans = 0, sum = 0;
        for (int i = 0; i < N; i++)
        {
            sum += plus[i];
            sum -= minus[i];

            ans = Math.max(ans, sum);
        }

        System.out.println(ans);

        scan.close();
    }
    public static void main(String[] args) throws IOException
    {
        solve();
    }
}
