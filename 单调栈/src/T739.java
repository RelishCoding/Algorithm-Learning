import java.util.Stack;

public class T739 {
    //非精简版本
    public int[] dailyTemperatures(int[] temperatures) {
        //递增栈
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i]<temperatures[stack.peek()]){//情况一
                stack.push(i);
            }else if (temperatures[i]<temperatures[stack.peek()]){//情况二
                stack.push(i);
            }else {//情况三
                while (!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                    result[stack.peek()] = i- stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return result;
    }

    //精简版本
    /*public int[] dailyTemperatures(int[] temperatures) {
        //递增栈
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            // 注意栈不能为空
            while (!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                result[stack.peek()] = i- stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }*/
}
