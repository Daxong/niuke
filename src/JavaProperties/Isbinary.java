package JavaProperties;

import java.util.Scanner;

public class Isbinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] nums = scan.nextLine().split(",");
        String[] nums2 = new String[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            nums2[i+1] = nums[i];
        }

    }

    public static void isBinarySearchTree (String[] nums){
        for (int i = 1; i < nums.length/2; i++) {
            if (nums[i].equals("None") ) {
                continue;
            }
            if (!nums[i*2].equals("None")) {
                int in = Integer.valueOf(nums[i]);
                if (!nums[i*2].equals("None")) {
                    if (in < Integer.valueOf(nums[i*2])){
                        System.out.println("False");
                        return;
                    }
                }

                if (!nums[i*2+1].equals("None")) {
                    if (in > Integer.valueOf(nums[i*2])){
                        System.out.println("False");
                        return;
                    }
                }

            }
        }
        System.out.println("true");
    }
}
