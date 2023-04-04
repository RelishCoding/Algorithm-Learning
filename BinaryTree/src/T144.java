import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class T144 {
    //递归遍历
    /*public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        preorder(root,result);
        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {
        if(root==null){
            return;
        }
        result.add(root.val);
        preorder(root.left,result);
        preorder(root.right,result);
    }*/

    //前序遍历非递归遍历
    /*public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if (root==null){
            return result;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            result.add(node.val);
            //注意空节点不入栈
            if (node.right!=null)
                stack.push(node.right);
            if (node.left!=null)
                stack.push(node.left);
        }
        return result;
    }*/

    //前序遍历统一迭代法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if (root==null)
            return result;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();//不能用pop
            if (node!=null){
                stack.pop();
                if (node.right!=null)
                    stack.push(node.right);

                if (node.left!=null)
                    stack.push(node.left);

                stack.push(node);
                stack.push(null);
            }else{
                stack.pop();
                node = stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
