import java.util.LinkedList;
import java.util.List;

public class T77 {
    //本题中主要涉及到集合的增删而不是查询，所以使用LinkedList而不是ArrayList
    List<List<Integer>> result=new LinkedList<>();
    LinkedList<Integer> path=new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }

    private void backtracking(int n, int k, int startindex) {
        if (path.size()==k){
            result.add(new LinkedList<>(path));
            /*  由于 path 是一个引用类型，所以在将其添加到 result 时，
            实际上将其引用添加到了 result 中，而不是将其内容复制到一个新的列表中。
            *   所以修改path后再将其添加到result时，result原来的元素也会发生变化
            *   为了保留 result 中原有的元素，我们需要在将 path 添加到 result 中时，
            创建一个新的链表对象而不是使用 path 的引用。可以使用 new LinkedList<>(path)
            来直接将 path 中的内容复制到一个新的链表对象中
            * */
            return;
        }

        //未进行剪枝的for循环
        //for (int i=startindex;i<=n;i++){
        //剪枝优化后的for循环
        for (int i=startindex;i<=n-k+1+path.size();i++){
            path.addLast(i);
            backtracking(n,k,i+1);
            path.removeLast();
        }
    }
}

class Main{
    public static void main(String[] args) {
        T77 t77 = new T77();
        List<List<Integer>> list = t77.combine(4, 2);
        System.out.println(list);
    }
}
