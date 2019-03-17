package JavaProperties;

import java.util.Arrays;

/**
 * 寻找数组中前k大的数，分治实现 O（n）T（nlogn）
 */
public class FindBeforeK {
    public static void main(String[] args) {
        findBeforeK(new int[]{2,12,5,7,9,10,15,24,16,23},0,9,3);
    }

    public static void findBeforeK(int[] nums, int left, int right, int k) {
        if (nums == null || left >= right || nums.length <= 1)
            return;
        int mid = partition(nums,left,right,0);
        while(mid < k) {
            mid = partition(nums, mid+1,right,0);
        }
        while(mid > k) {
            mid = partition(nums,left,mid,k);
        }
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < k; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static int partition(int[] nums,int left, int right, int k){
        int piovt = 0;
        if(k != 0) {
            piovt = nums[k];
        }else {
            piovt = nums[right];
        }

        int i = left;
        int j = right;
        while (i != j) {
            while (nums[i] > piovt && i < j) {
                i++;
            }
            while (nums[j] <= piovt && i < j) {
                j--;
            }
            if (i < j) {
                swap(nums,i,j);
            }

        }
        nums[right] = nums[i];
        nums[i] = piovt;
        return i;
    }

    public static void swap(int[] nums, int left, int right) {
        nums[left]  = nums[left] ^ nums[right];
        nums[right] = nums[left] ^ nums[right];
        nums[left]  = nums[left] ^ nums[right];
//        int carry = nums[left];
//        nums[left] = nums[right];
//        nums[right] = carry;
    }
}
