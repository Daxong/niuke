package niuke;

import java.util.Scanner;

public class CalcMin {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        String str = scan.nextLine();
        String[] strs = scan.nextLine().split(" ");
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        min(nums);
    }
    public static void min(int[] nums){
        int len = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<len; i++) {
            if(sum > 0){
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            if(sum <= min){
                min = sum;
            }
        }
        System.out.println(min);
    }
}
//8
//-2 6 -1 -5 4 -7 -2 3