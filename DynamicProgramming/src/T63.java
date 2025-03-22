import java.util.Arrays;

/**
 * LeetCode 63 不同路径Ⅱ
 */
public class T63 {
    // 二维dp数组
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // 如果在起点或终点出现了障碍，直接返回0
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1)
            return 0;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                else
                    dp[i][j] = 0; // 也可写continue，因为数组默认初始化为0
            }
        }
        return dp[m - 1][n - 1];
    }

    // 一维dp数组
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;

        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[j] = 1;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j != 0) {
                    dp[j] = dp[j -1] + dp[j];
                }
            }
        }
        return dp[n - 1];
    }
}
