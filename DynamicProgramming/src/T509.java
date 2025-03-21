/**
 * LeetCode 509 斐波那契数
 */
public class T509 {
    // 压缩版本
    public int fib(int n) {
        if (n <= 1)
            return n;
        int first = 0, second = 1, third = 0;
        for (int i = 2; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    // 非压缩版本
    public int fib2(int n) {
        if (n <= 1)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 递归版本
    public int fib3(int n) {
        if (n <= 1)
            return n;
        return fib3(n - 1) + fib3(n - 2);
    }
}
