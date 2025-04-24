/**
 * LeetCode 96 不同的二叉搜索树
 */
public class T96 {
    public int numTrees(int n) {
        // 初始化 dp 数组
        int[] dp = new int[n + 1];
        // 初始化0个节点、1个节点和2个结点的情况
        dp[0] = 1;
        // 此处也可以不初始化dp[1]和dp[2]，因为从dp[1]开始就可以通过递推公式计算得出
        dp[1] = 1;
        // 之所以加if判断，是因为测试用例有输入n=1的情况，此时会产生数组索引越界异常
        if (n >= 2)
            dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加
                // 一共i个节点，对于根节点j时,左子树的节点个数为j-1，右子树的节点个数为i-j
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
