import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 117 填充每个节点的下一个右侧节点指针Ⅱ
 */
public class T117 {
    // 层序遍历，方法一
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        Node preNode = null;
        Node node;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (i != 0) {
                    preNode.next = node;
                }
                preNode = node;
                /*if (i == 0) {
                    preNode = node;
                } else {
                    preNode.next = node;
                    preNode = node;
                }*/
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    // 层序遍历，方法二
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        Node node, nextNode;
        while (!queue.isEmpty()) {
            int size = queue.size();
            node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

            for (int i = 1; i < size; i++) {
                nextNode = queue.poll();
                if (nextNode.left != null) {
                    queue.offer(nextNode.left);
                }
                if (nextNode.right != null) {
                    queue.offer(nextNode.right);
                }
                node.next = nextNode;
                node = nextNode;
            }
        }
        return root;
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
