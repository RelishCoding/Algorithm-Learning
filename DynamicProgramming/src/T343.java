/**
 * LeetCode 343 整数拆分
 */
public class T343 {
    // 动态规划
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            //for (int j = 1; j < i; j++) {
            // for (int j = 1; j <= i / 2; j++) {
            for (int j = 1; j <= i - j; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    // 贪心方法/数学方法，写法一
    public int integerBreak2(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        result *= n;
        return result;
    }

    // 数学方法，写法二
    public int integerBreak3(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return pow(3, a);
        } else if (b == 1) {
            return pow(3, a - 1) * 4;
        } else {
            return pow(3, a) * 2;
        }
    }

    private int pow(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}
