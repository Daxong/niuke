package JavaProperties;

public class maxValue {
    int[] prev = new int[8];
    //arrange存储任务时间区间，values一一对应arrange中每个任务的报酬
    public  int maxValue(int[][] arrange, int[] values, int index)throws Exception{
        int countTask = values.length;//任务个数
        if (index > countTask) throw new Exception("任务规划错误");

        prev[0] = 0;
        //初始化递推关系
        for (int i = 1; i < prev.length; i++) {
            for (int n = i; n > 0; n--) {
                if (arrange[i][0] >= arrange[n-1][1]) {
                    prev[i] = n;
                    break;
                }else {
                    prev[i] = 0;
                }
            }
        }

        //动态规划
        int max = 0;
        int[] dp = new int[index];
        return opt(values,index,dp);
    }

    public int opt(int[] values, int index,int[] dp){
        if (prev[index] == 0) {
            int val = values[index];
            return val;
        }
        int val1,val2;
        //不做
        if (dp[index-1] == 0) {
            val2 = opt(values,index-1,dp);
            dp[index-1] = val2;
        }else {
            val2 = dp[index-1];
        }
        //做
        if (dp[prev[index]] == 0) {
            val1 = values[index]+opt(values,prev[index],dp);
            dp[prev[index]] = val1;
        }else {
            val1 = dp[prev[index]];
        }


//        return (val1 > val2 ? val1 : val2);
        if (val1 > val2) {
            return val1;
        }else {
            return val2;
        }

    }
    public static void main(String[] args) {
        int[][] arrange = new int[][]{ {1,4},{3,5},{0,6},{4,7},{3,8},{5,9},{6,10},{8,11} };
        int[] values = new int[]{5,1,8,4,6,3,2,4};
        maxValue maxV = new maxValue();
        try {
            int value = maxV.maxValue(arrange,values,7);
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
