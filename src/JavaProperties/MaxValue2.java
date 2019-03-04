package JavaProperties;

public class MaxValue2 {
    private int[][] taskTime;   //工作时间安排
    private int[]   prev ;      //上一个可做工作
    private int[]   salary;     //工资

    //初始化变量
    public MaxValue2(int[][] taskTime, int[] salary){
        this.taskTime   = taskTime;
        this.salary     = salary;
        this.prev       = new int[salary.length];
        prev[0] = -1;
        for (int i = 0; i < prev.length; i++) {
            for (int n = i; n > 0; n--) {
                if (taskTime[i][0] >= taskTime[n-1][1]) {
                    prev[i] = n-1;
                    break;
                }else {
                    prev[i] = -1;
                }
            }
        }

    }

    public int opt(int index, int[] dp){

        if (index > -1) {
            if (dp[index] != 0) return dp[index];
            //走法1 选择当前工作
            int way1 = opt(prev[index],dp) + salary[index];
            //走法2 拒绝当前工作
            int way2 = opt(index-1,dp);
            //比较两种选择的结果
            int max = way1 > way2 ? way1 : way2 ;
            dp[index] = max;
            return max;
        }
        return 0;
    }


    public static void main(String[] args) {
        int[][] taskTime = new int[][]{ {1,4},{3,5},{0,6},{4,7},{3,8},{5,9},{6,10},{8,11} };
        int[] salary = new int[]{5,1,8,4,6,3,2,4};
        MaxValue2 maxV = new MaxValue2(taskTime,salary);
        int[] dp = new int[salary.length];
        int max = maxV.opt(7,dp);
        System.out.println(max);
    }
}
