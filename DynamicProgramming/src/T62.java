import java.util.Arrays;

/**
 * LeetCode 62 不同路径
 */
public class T62 {
    // 二维dp数组版本
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 一开始我觉得dp[0][0]初始化为0就行
        // 后面力扣一提交后发现官方的测试用例是dp[0][0]=1
        // dp[0][0]=0;
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    // 一维dp数组版本
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        /*for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }*/
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    // 数论方法错误写法
    public int uniquePaths3(int m, int n) {
        int numerator = 1, denominator = 1;
        int count = m - 1;
        int t = m + n - 2;
        while (count != 0) {
            numerator *= t; // 计算分子，此时分子就会溢出
            t--;
            count--;
        }
        for (int i = 1; i <= m - 1; i++) denominator *= i; // 计算分母
        return numerator / denominator;
    }

    // 数论方法正确写法
    public int uniquePaths4(int m, int n) {
        long numerator = 1; // 分子
        int denominator = m - 1; // 分母
        int t = m + n - 2;

        // 优化写法一，可去掉
        if (t - denominator < denominator) denominator = t - denominator;

        for (int count = denominator; count != 0; count--) {
            numerator *= (t--);
            while (denominator != 0 && numerator % denominator == 0) {
                numerator /= denominator;
                denominator--;
            }
        }
        return (int) numerator;
    }

    // 数论方法，优化写法二
    public int uniquePaths5(int m, int n) {
        long numerator = 1; // 分子
        int t = m + n - 2;

        int denominator;
        if (n < m) {
            denominator = n - 1;
        } else {
            denominator = m - 1; // 分母
        }

        for (int count = denominator; count != 0; count--) {
            numerator *= (t--);
            while (denominator != 0 && numerator % denominator == 0) {
                numerator /= denominator;
                denominator--;
            }
        }
        return (int) numerator;
    }
}
