package niuke;

import java.util.Scanner;
public class CountBinarySamebit{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] nums = scan.nextLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);
        int res = n ^ m;
        String resByte = Integer.toBinaryString(res);
        int countSame = 0;
        for (int i = 0; i < resByte.length(); i++ ){
            if(resByte.charAt(i) == '1'){
                countSame++;
            }
        }
        System.out.println(countSame);
    }

}