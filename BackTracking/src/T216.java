import java.util.ArrayList;
import java.util.List;

public class T216 {
    List<List<Integer>> result = new ArrayList<>();//存放结果集
    List<Integer> path = new ArrayList<>();//符合条件的结果
    int targetSum;//目标和，也就是题目中的n
    int depth;//递归深度，也就是题目中的k

    public List<List<Integer>> combinationSum3(int k, int n) {
        targetSum=n;
        depth=k;
        backtracking(0,1);

        return result;
    }

    //sum：已经收集的元素的总和，也就是path里元素的总和
    //startIndex：下一层for循环搜索的起始位置
    private void backtracking(int sum,int startIndex){
        if (sum > targetSum) { //剪枝操作
            return;
        }

        if (path.size()==depth){
            if (sum==targetSum){
                result.add(new ArrayList<>(path));
            }
            return;//如果path.size()==k但sum!=targetSum直接返回
        }

        //for (int i = startIndex; i <= 9; i++) {
        //剪枝操作
        for (int i = startIndex; i <= 10 - depth + path.size(); i++) {
            sum+=i;//处理
            path.add(i);//处理
            backtracking(sum,i+1);//注意i+1调整startIndex
            sum-=i;//回溯
            path.remove(path.size()-1);//回溯
        }
    }
}
