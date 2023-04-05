public class T746 {
    //非压缩版本
    /*public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length+1];
        dp[0]=0;
        dp[1]=0;
        for (int i=2;i<=cost.length;i++){
            //dp[i]=Integer.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }*/

    //压缩版本
    public int minCostClimbingStairs(int[] cost) {
        int dp0=0;
        int dp1=0;
        int dpi;
        for (int i=2;i<=cost.length;i++){
            dpi=Math.min(dp1+cost[i-1],dp0+cost[i-2]);
            dp0=dp1;
            dp1=dpi;
        }
        return dp1;
    }
}
