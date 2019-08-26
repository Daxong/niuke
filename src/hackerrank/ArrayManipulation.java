package hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
//        solve();
//        getOneBits(161);

        List sen = Arrays.asList("jim likes mary","kate likes tom","tom does not like jim");
        List q = Arrays.asList("jim tom","likes");
        textQueries(sen,q);
    }

    public static List<Integer> getOneBits(int n) {
        // Write your code here
        String binStr = Integer.toBinaryString(n);
        int cnt = 0;
        List list = new ArrayList();
        for (int i = 0; i < binStr.length(); i++) {
            if ('1' == binStr.charAt(i)) {
                list.add(i);
            }
        }
        List res = new ArrayList<Integer>();
        res.add(cnt);
        res.addAll(list);
        return res;
    }

    public static void textQueries(List<String> sentences, List<String> queries) {
        // Write your code here
        boolean flag = false;
        for (int i = 0; i < sentences.size(); i++) {
            for (int j = 0; j < queries.size(); j++) {
                String str = queries.get(j);
                String[] strArr = str.split(" ");
                if (strArr.length > 0) {
                    int count = 0;
                    String string = sentences.get(i);
                    for (int n = 0; n < strArr.length; n++) {

                        if (sentences.get(i).contains(strArr[n])) {
                            count++;
                        }
                    }
                    if (count == strArr.length) {
                        System.out.println(string);
                        System.out.print(i + " ");
                        flag = true;
                    }
                }else {
                    if (sentences.get(i).contains(str)) {
                        System.out.print(i + " ");
                        flag = true;
                    }

                }
                if (flag) {
                    System.out.println();
                    flag = false;
                }
            };
        }
    }
}
