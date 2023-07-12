import java.util.*;

public class T199 {
    //迭代法，使用队列
    /*public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root==null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            //这里一定要使用固定大小size，不要使用que.size()，因为que.size是不断变化的
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 将每一层的最后元素放入result数组中
                if (i==(size-1)){
                    result.add(node.val);
                }
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }*/

    //递归法
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        int depth = 0;
        order(root,result,depth);
        return result;
    }
    private void order(TreeNode root, List<Integer> result, int depth) {
        if (root==null){
            return;
        }
        if (result.size()==depth){
            result.add(root.val);
        }
        result.set(depth, root.val);
        order(root.left,result,depth+1);
        order(root.right,result,depth+1);
    }

    private class TreeNode { 
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
