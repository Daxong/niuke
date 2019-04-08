package niuke;

import java.util.Scanner;
public class CountBinarySamebit{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] nums = scan.nextLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);
        int a = n, b = m;
        int count = 0;
        while (a != 0 && a != 0) {
            a >>= 1;
            b >>= 1;
            count++;
        }
        int res = n ^ m;
        String resByte = Integer.toBinaryString(res);
        int countSame = 0;
        for (int i = count-1; i > -1; i-- ){
            if(resByte.charAt(i) == '1'){
                countSame++;
            }
        }
        System.out.println(countSame);
    }

}