package niuke;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author yfy
 * @version : FindMaxProductWithThreeNums.java,v 0.1 2019年08月26日 19:53
 */

/**
 * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
 * 解题思路：
 * 找出最大的三个数及最小的两个数 比较最大三个数乘积与最小两个数及最大数之乘积大小
 */
public class MaxMulitplyResWithThreeNums {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            scan.nextLine();
            String[] numsStr = scan.nextLine().split(" ");
            int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE, secondMin = Integer.MAX_VALUE, min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int num = Integer.valueOf(numsStr[i]);
                int cnt = n - 3;

                    if (num >= max) {
                        third = second;
                        second = max;
                        max = num;
                    }else if(num >= second){
                        third = second;
                        second = num;
                    }else if(num >= third) {
                        third = num;
                    }

                    if (num <= min) {
                        secondMin = min;
                        min = num;
                    }else if(num <= secondMin) {
                        secondMin = num;
                    }

            }
            BigInteger maxBig = new BigInteger(String.valueOf(max));
            BigInteger secondBig = new BigInteger(String.valueOf(second));
            BigInteger thirdBig = new BigInteger(String.valueOf(third));
            BigInteger res1 = secondBig.multiply(thirdBig);
            BigInteger secondMinBig = new BigInteger(String.valueOf(secondMin));
            BigInteger minBig = new BigInteger(String.valueOf(min));
            BigInteger res2 = secondMinBig.multiply(minBig);
            int compareRes = res1.compareTo(res2);
            if(compareRes == 0 || compareRes == 1) {
                System.out.println(maxBig.multiply(res1));
            }else {
                System.out.println(maxBig.multiply(res2));
            }

        }

}
