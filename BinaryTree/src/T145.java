import java.util.*;

public class T145 {
    //递归遍历
    /*public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        postorder(root,result);
        return result;
    }

    private void postorder(TreeNode root, List<Integer> result) {
        if(root==null){
            return;
        }
        postorder(root.left,result);
        postorder(root.right,result);
        result.add(root.val);
    }*/

    //后序遍历非递归遍历
    /*public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if (root==null){
            return result;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            result.add(node.val);
            if (node.left!=null)
                stack.push(node.left);
            if (node.right!=null)
                stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }*/

    //后序遍历统一迭代法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if (root==null)
            return result;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();//不能用pop
            if (node!=null){
                stack.pop();
                stack.push(node);
                stack.push(null);

                if (node.right!=null)
                    stack.push(node.right);

                if (node.left!=null)
                    stack.push(node.left);
            }else{
                stack.pop();
                node = stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
