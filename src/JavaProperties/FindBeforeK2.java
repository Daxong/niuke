package JavaProperties;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindBeforeK2 {
    public static void main(String[] args) {
        int[] integers = findBoforek(new int[]{2,12,5,7,9,10,15,24,16,23},6);
        System.out.print("[");
        for (int i = 0; i < integers.length; i++) {
            if (i == integers.length-1) {
                System.out.print(integers[i]+"]");
            }else {
                System.out.print(integers[i]+",");
            }

        }
    }
    public static int[] findBoforek(int[] nums, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
        }
        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            ints[i] = priorityQueue.poll();
        }
        return ints;
    }
}
