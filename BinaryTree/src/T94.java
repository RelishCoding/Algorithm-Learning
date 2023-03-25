import java.util.ArrayList;
import java.util.List;

public class T94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        inorder(root,result);
        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if(root==null){
            return;
        }
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }
}
