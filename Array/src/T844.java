import java.util.Stack;

public class T844 {
    /**
     * 双指针从后遍历
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

    /**
     * 双指针从前遍历
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare5(String s, String t) {
        s = range(s);
        t = range(t);
        return s.equals(t);
    }
    public String range(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        int slow = 0;
        for (int fast = 0; fast < stringBuilder.length(); fast++) {
            if (stringBuilder.charAt(fast) != '#') {
                stringBuilder.setCharAt(slow, stringBuilder.charAt(fast));
                slow++;
            } else {
                if (slow > 0) {
                    slow--;
                }
            }
        }
        return stringBuilder.substring(0, slow);
    }

    /**
     * 使用StringBuilder的append方法和deleteCharAt()方法
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare4(String s, String t) {
        s = appendCharacter(s);
        t = appendCharacter(t);
        return s.equals(t);
    }
    public String appendCharacter(String str) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '#') {
                stringBuilder.append(str.charAt(i));
            } else {
                if (!stringBuilder.toString().equals("")) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 用StringBuilder的deleteCharAt方法进行退格操作
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare3(String s, String t) {
        StringBuilder stringBuilder_s = new StringBuilder(s);
        StringBuilder stringBuilder_t = new StringBuilder(t);

        s = deleteCharacter(stringBuilder_s);
        t = deleteCharacter(stringBuilder_t);
        return s.equals(t);
    }
    public String deleteCharacter(StringBuilder stringBuilder) {
        int length = stringBuilder.length();
        for (int i = 0; i < length; i++) {
            if (stringBuilder.charAt(i) == '#') {
                stringBuilder.deleteCharAt(i);
                i--;
                length--;
                if (i >= 0) {
                    stringBuilder.deleteCharAt(i);
                    i--;
                    length--;
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 使用栈模拟退格操作
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare2(String s, String t) {
        Stack<Character> stack_s = new Stack<>();
        Stack<Character> stack_t = new Stack<>();

        stringToStack(s, stack_s);
        stringToStack(t, stack_t);

        while (!stack_s.isEmpty() && !stack_t.isEmpty()) {
            if (stack_s.pop() != stack_t.pop()) {
                return false;
            }
        }
        if (stack_s.isEmpty() && stack_t.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public void stringToStack(String str, Stack<Character> stack) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '#') {
                stack.push(str.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
    }
}
