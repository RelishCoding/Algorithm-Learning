import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 104 二叉树的最大深度
 */
public class T104 {
    // 层序遍历
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            depth++;
        }
        return depth;
    }

    // 递归法
    private int result = Integer.MIN_VALUE;
    private int depth = 0;
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return depth;
    }
    private void dfs(TreeNode node) {
        depth++;
        if (node.left == null && node.right == null) {
            result = Math.max(result, depth);
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
