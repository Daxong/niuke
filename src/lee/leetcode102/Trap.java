package lee.leetcode102;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */

public class Trap {
    public static void main(String[] args) {
       int sum =  new Trap().trap(
//                new int[]{0,1,2,2,1,0,1,3,2,1,2,1}
                new int[]{4,2,3}
                );
        System.out.println(sum);
    }


    public int trap(int[] height) {
        int len = height.length;
        int[]  left = new int[len];
        int[] right = new int[len];
        //左右两边是不能盛水的
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i-1],height[i-1]);
        }
        for (int i = len-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1],height[i+1]);
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int level = Math.min(left[i],right[i]);
            sum += Math.max(0, level-height[i]);
        }
        return sum;
    }
}


