public class T1049 {
    //滚动数组
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int target = sum / 2;

        int[] dp = new int[target+1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }

        return sum - dp[target] - dp[target];
    }

    //二维数组
    /*public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;

        int[][] dp = new int[stones.length][target+1];
        for (int j = stones[0];j <= target;j++) {
            dp[0][j] = stones[0];
        }

        for (int i = 1; i < stones.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= stones[i]) {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-stones[i]]+stones[i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return sum - 2 * dp[stones.length-1][target];
    }*/
}
