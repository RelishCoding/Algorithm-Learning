import java.util.*;

/**
 * LeetCode 94 二叉树的中序遍历
 */
public class T94 {
    // 递归遍历
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }
    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    // 中序遍历非递归遍历
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        // 当指针和栈都为空时，才说明遍历和处理节点都已完成
        // 所以while循环的条件是or而不是and
        while (cur != null || !stack.isEmpty()) {
            // 指针先一路向左遍历，将遍历到的节点入栈。直到最下面最左边的节点入栈后，
            // 指针为空，此时开始弹出栈顶元素，将其添加到result数组。
            // 然后指针开始往回走，向右遍历
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    // 中序遍历统一迭代法之空指针标记法
    public List<Integer> inorderTraversal3(TreeNode root) {
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
                stack.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                if (node.right != null)
                    stack.push(node.right);// 添加右节点（空节点不入栈）

                stack.push(node); // 添加中节点
                stack.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记

                if (node.left != null)
                    stack.push(node.left); // 添加左节点（空节点不入栈）
            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                stack.pop(); // 将空节点弹出
                node = stack.pop(); // 重新取出栈中元素
                result.add(node.val); // 加入到结果集
            }
        }
        /*
         手动模拟一下整个过程便会发现，对于每棵树包括子树，都是根节点先入栈再出栈，
         然后按右子树根节点左子树的顺序入栈。因为中序遍历是左中右，入栈得反着来
         另外，左子树和根节点都是开始入栈时就添加了空节点，而右子树都是部分元素出栈后，
         它们才又出栈一次，再入栈并添加空节点。总之，每个节点后面都会有一个空节点
         */
        return result;
    }

    // 中序遍历统一迭代法之boolean标记法
    public List<Integer> inorderTraversal(TreeNode root) {
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

            // 中序遍历是'左中右'，右儿子最先入栈，最后出栈
            if (node.right != null) {
                stack.push(new AbstractMap.SimpleEntry<>(node.right, false));
            }

            // 把自己加回到栈中，位置居中
            // 同时设置visited为true，表示下次再访问本节点时，允许收割
            stack.push(new AbstractMap.SimpleEntry<>(node, true));

            // 左儿子最后入栈，最先出栈
            if (node.left != null) {
                stack.push(new AbstractMap.SimpleEntry<>(node.left, false));
            }
        }

        return result;
    }
}
