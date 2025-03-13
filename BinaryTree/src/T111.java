import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 111 二叉树的最小深度
 */
public class T111 {
    // 层序遍历
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return depth;
    }

    // 递归法
    private int result = Integer.MAX_VALUE;
    private int depth = 0;
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return result;
    }
    private void dfs(TreeNode node) {
        depth++;
        if (node.left == null && node.right == null) {
            result = Math.min(result, depth);
            return;
        }
        if (node.left != null) {
            dfs(node.left);
            depth--;
        }
        if (node.right != null) {
            dfs(node.right);
            depth--;
        }
    }
}
