public class T416 {
    //一维滚动数组
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;

        int target = sum / 2;
        int[] dp = new int[target+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Integer.max(dp[j],dp[j-nums[i]]+nums[i]);
            }

            //剪枝一下，每一次完成内层的for-loop，立即检查是否dp[target] == target
            if(dp[target] == target)
                return true;
        }
        /*if (dp[target] == target) {
            return true;
        }else {
            return false;
        }*/
        return dp[target] == target;
    }

    //二维dp数组
    /*public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if(sum % 2 == 1){
            return false;
        }

        int target = sum / 2;
        int[][] dp = new int[len][target + 1];
        for(int j = nums[0]; j <= target; j++){
            dp[0][j] = nums[0];
        }

        for(int i = 1; i < len; i++){
            for(int j = 1; j <= target; j++){
                if (j < nums[i])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
            }
        }

        return dp[len - 1][target] == target;
    }*/
}
