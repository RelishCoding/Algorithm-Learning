import java.util.ArrayList;
import java.util.List;

public class T637 {
    //迭代法，使用队列
    /*public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root==null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;//统计每一层的和
            //这里一定要使用固定大小size，不要使用que.size()，因为que.size是不断变化的
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            result.add(sum/size);//将每一层均值放进结果集
        }

        return result;
    }*/

    //递归法
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        List<Double> sums = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        dfs(root,0,counts,sums);
        for (int i = 0; i < sums.size(); i++) {
            result.add(sums.get(i) / counts.get(i));
        }
        return result;
    }

    private void dfs(TreeNode root, int depth, List<Integer> counts, List<Double> sums) {
        if (root == null) {
            return;
        }
        if (depth == sums.size()) {
            sums.add(1.0 * root.val);
            counts.add(1);
        } else {
            sums.set(depth, sums.get(depth) + root.val);
            counts.set(depth, counts.get(depth) + 1);
        }
        dfs(root.left, depth + 1, counts, sums);
        dfs(root.right, depth + 1, counts, sums);
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
