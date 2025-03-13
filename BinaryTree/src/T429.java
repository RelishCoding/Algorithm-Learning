import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 429 N叉树的层序遍历
 */
public class T429 {
    // 层序遍历
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> vec = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                vec.add(node.val);
                for (Node child : node.children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }
            result.add(vec);
        }

        return result;
    }

    // 递归法
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        int depth = 0;
        dfs(root, result, depth);
        return result;
    }

    private void dfs(Node root, List<List<Integer>> result, int depth) {
        if (root == null) {
            return;
        }
        if (result.size() == depth) {
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);
        for (Node child : root.children) {
            dfs(child, result, depth + 1);
        }
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
