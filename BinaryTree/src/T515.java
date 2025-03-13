import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 515 在每个树行中找最大值
 */
public class T515 {
    // 层序遍历
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val > max) {
                    max = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(max);
        }

        return result;
    }

    // 递归法
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result, int depth) {
        if (result.size() == depth) {
            result.add(root.val);
        }
        if (root.val > result.get(depth)) {
            result.set(depth, root.val);
        }
        if (root.left != null) {
            dfs(root.left, result, depth + 1);
        }
        if (root.right != null) {
            dfs(root.right, result, depth + 1);
        }
    }
}
