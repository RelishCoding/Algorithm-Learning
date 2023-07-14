import java.util.Stack;

public class T232 {
    private static class MyQueue {
        Stack<Integer> stackIn;//负责进栈
        Stack<Integer> stackOut;//负责出栈

        public MyQueue() {
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }

        public void push(int x) {
            stackIn.push(x);
        }

        public int pop() {
            int result = peek();//直接使用已有的peek函数
            stackOut.pop();
            return result;
        }

        public int peek() {
            //只有当stackOut为空的时候，再从stackIn里导入数据（导入stackIn全部数据）
            if (stackOut.isEmpty()){
                //从stackIn导入数据直到stackIn为空
                while (!stackIn.isEmpty()){
                    stackOut.push(stackIn.pop());
                }
            }
            return stackOut.peek();
        }

        public boolean empty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.peek();
        System.out.println(param_2);
        int param_3 = obj.pop();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }
}
