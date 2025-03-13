import java.util.*;

/**
 * LeetCode 102 二叉树的层序遍历
 */
public class T102 {
    // 层序遍历，使用队列
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        // queue.add(root);
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> vec = new ArrayList<>();
            // 这里一定要使用固定大小size，不要使用que.size()，因为que.size是不断变化的
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                vec.add(node.val);
                if (node.left != null) {
                    // queue.add(node.left);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    // queue.add(node.right);
                    queue.offer(node.right);
                }
            }

            result.add(vec);
        }

        return result;
    }

    // 递归法
    // 先序遍历得到的序列依次填到对应层数的数组
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int depth = 0;
        order(root, result, depth);
        return result;
    }
    private void order(TreeNode root, List<List<Integer>> result, int depth) {
        if (root == null) {
            return;
        }
        // 若result.size()等于depth，说明该结点为depth层第一个结点
        if (result.size() == depth) {
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);
        order(root.left, result, depth + 1);
        order(root.right, result, depth + 1);
    }

    // 递归写法二
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, result, 0);
        return result;
    }
    private void dfs(TreeNode root, List<List<Integer>> result, int depth) {
        if (result.size() == depth) {
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);
        if (root.left != null) {
            dfs(root.left, result, depth + 1);
        }
        if (root.right != null) {
            dfs(root.right, result, depth + 1);
        }
    }
}
