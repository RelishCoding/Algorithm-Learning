import java.util.*;

/**
 * LeetCode 145 二叉树的后序遍历
 */
public class T145 {
    // 递归遍历
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }

    // 后序遍历非递归遍历
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }

    // 后序遍历统一迭代法之空指针标记法
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // 如果此处用pop而不是peek，则if和else里的pop语句都应该去掉，防止多弹出元素
            // TreeNode node = stack.pop();
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop();
                stack.push(node);
                stack.push(null);

                if (node.right != null)
                    stack.push(node.right);

                if (node.left != null)
                    stack.push(node.left);
            } else {
                stack.pop();
                node = stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }

    // 后序遍历统一迭代法之boolean标记法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<AbstractMap.SimpleEntry<TreeNode, Boolean>> stack = new Stack<>();
        stack.push(new AbstractMap.SimpleEntry<>(root, false));

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek().getKey();
            // 多加一个visited参数，使“迭代统一写法”成为一件简单的事
            boolean visited = stack.peek().getValue();
            stack.pop();

            // visited为True，表示该节点和两个儿子位次之前已经安排过了，现在可以收割节点了
            if (visited) {
                result.add(node.val);
                continue;
            }

            // visited当前为false, 表示初次访问本节点，此次访问的目的是“把自己和两个儿子在栈中安排好位次”

            // 后序遍历是'左右中'，节点自己最先入栈，最后出栈
            // 同时设置visited为true，表示下次再访问本节点时，允许收割
            stack.push(new AbstractMap.SimpleEntry<>(node, true));

            // 右儿子位置居中
            if (node.right != null) {
                stack.push(new AbstractMap.SimpleEntry<>(node.right, false));
            }

            // 左儿子最后入栈，最先出栈
            if (node.left != null) {
                stack.push(new AbstractMap.SimpleEntry<>(node.left, false));
            }
        }

        return result;
    }
}
