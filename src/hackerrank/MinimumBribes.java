package hackerrank;

import java.util.Scanner;

/**
 * @author yfy
 * @version : MinimumBribes.java,v 0.1 2019年08月22日 20:36
 */
public class MinimumBribes {
    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int n = q.length;
        int cnt = 0;
        for(int i = n - 1; i >= 0; i--)
        {
            if(q[i] != (i + 1))
            {
                if(((i - 1) >= 0) && q[i - 1] == (i + 1))
                {
                    cnt++;
                    swap(q,i,i-1);
                }
                else if(((i - 2) >= 0) && q[i - 2] == (i + 1))
                {
                    cnt += 2;
                    q[i - 2] = q[i - 1];
                    q[i - 1] = q[i];
                    q[i] = i + 1;
                }
                else
                {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(cnt);

    }

    private static int[] swap(int[] q, int a, int b) {
        int vala = q[a];
        int valb = q[b];
        q[b] = vala;
        q[a] = valb;
        return q;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
