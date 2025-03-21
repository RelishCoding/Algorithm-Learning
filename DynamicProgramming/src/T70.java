/**
 * LeetCode 70 爬楼梯
 */
public class T70 {
    // 非压缩版本
    public int climbStairs2(int n) {
        //当 n=1 或者 n=2时，直接返回n即可，没必要再开数组
        //同时这也是为了防止后面数组索引越界异常
        if (n <= 2)
            return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 压缩版本
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int first = 1, second = 2, third = 0;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}
