package JavaProperties;
import java.util.*;

/**
 * 求最长公共递增子序列
 */
public class Maxlis {
    private int[] nums;
    public Maxlis(int[] nums){
        this.nums = nums;
    }

    public int lengthOfLIS() {
        if (nums.length == 0) return 0;
        int[] numsB = this.nums.clone();
//        System.out.println(numsB.toString());
        Arrays.sort(numsB);
        System.out.println("B:"+numsB.toString());
        System.out.println("A:"+this.nums);


        int length = nums.length;
        int[][] lis = new int[length][length];
        //初始化第0行最长公共子串
        for (int i = 0; i < length; i++) {
            if (nums[0] == numsB[i]) {
                lis[0][i] = 1;
            }else if(i != 0 ) {
                lis[0][i] = lis[0][i-1];
            }else{
                lis[0][i] = 0;
            }
        }

        //初始化第0列最长公共子串
        for (int j = 0; j < length; j++) {
            if (nums[j] == numsB[0]) {
                lis[j][0] = 1;
            }else if(j != 0) {
                lis[j][0] = lis[j-1][0];
            }else{
                lis[j][0] = 0;
            }
        }

        for (int n = 1; n < length; n++) {
            for (int m = 1; m < length; m++) {
                if (nums[n] == numsB[m]) {
                    lis[n][m] = max(lis[n-1][m],
                            lis[n][m-1],
                            lis[n-1][m-1]+1);
                }else {
                    lis[n][m] = max(lis[n-1][m],
                            lis[n][m-1],
                            lis[n-1][m-1]);
                }
            }
        }
        return lis[length-1][length-1];
    }
    private int max(int x, int y, int z) {
        int max = Integer.MIN_VALUE;
        if (x > max) max = x;
        if (y > max) max = y;
        if (z > max) max = z;
        return max;
    }

//    private int[] cloneArray() {
//        int[] numsB = new int[this.nums.length];
//        for (int i = 0; i < this.nums.length; i++) {
//            numsB[i] = this.nums[i];
//        }
//
//        return numsB;
//    }
    public static void main(String[] args) {
//        Maxlis maxlis = new Maxlis(new int[]{1,3,2,4,5});
//        int max = maxlis.lengthOfLIS();
//        System.out.println(max);

        int[] nums = new int[]{3,4,1,3,2,4,5};
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i <nums.length; i++) {

            if (map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        int count = 0;
        Collection collection = map.keySet();
        for (Object i : collection) {
            int ii = (Integer)i;
            if (ii > 1) {
                count += (ii-1);
            }
        }
        System.out.println(count);
    }
}
