import java.util.ArrayList;
import java.util.List;

public class T145 {
    public List<Integer> postorderTraversal(TreeNode root) {
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
    }
}
