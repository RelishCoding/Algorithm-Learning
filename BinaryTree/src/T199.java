import java.util.*;

/**
 * LeetCode 199 二叉树的右视图
 */
public class T199 {
    // 层序遍历，使用队列
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 这里一定要使用固定大小size，不要使用que.size()，因为que.size是不断变化的
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 将每一层的最后元素放入result数组中
                if (i == (size - 1)) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }

    // 递归法
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        int depth = 0;
        order(root, result, depth);
        return result;
    }

    private void order(TreeNode root, List<Integer> result, int depth) {
        if (root == null) {
            return;
        }
        // 使用if...else优化对每层第一个节点的重复操作
        if (result.size() == depth) {
            result.add(root.val);
        } else {
            result.set(depth, root.val);
        }
        order(root.left, result, depth + 1);
        order(root.right, result, depth + 1);
    }
}
