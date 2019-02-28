package JavaProperties;
//对于一组不同重量、不可分割的物品，我们需要选择一些装入背包，
//在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少
public class dp {
    //weight: 物品重量，n: 物品个数，w: 背包可承载重量
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w+1]; // 默认值 false
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        states[0][ weight[0] ] = true; //weight[0]为第一个物品的重量
        for (int i = 1; i < n; ++i) { // 动态规划状态转移
            for (int j = 0; j <= w; ++j) {// 不把第 i 个物品放入背包
                if (states[i-1][j] == true) states[i][j] = states[i-1][j];
            }
            for (int j = 0; j <= w-weight[i]; ++j) {// 把第 i 个物品放入背包
                if (states[i-1][j]==true) states[i][j+weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果，结果为最大重量
            if (states[n-1][i] == true) return i;
        }
        return 0;
    }

    //优化版 items: 物品重量，n: 物品个数，w: 背包可承载重量
    public static int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w+1]; // 默认值 false
        states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        states[items[0]] = true;
        for (int i = 1; i < n; ++i) { // 动态规划
            // 把第 i 个物品放入背包，j为背包剩余可装重量
            for (int j = w-items[i]; j >= 0; --j) {
                if (states[j]==true) states[j+items[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[i] == true) return i;
        }
        return 0;
    }

}
