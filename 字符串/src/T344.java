import java.util.Arrays;
import java.util.Collections;

public class T344 {
    public static void reverseString(char[] s) {
        //使用临时变量交换
        /*for (int left=0,right=s.length-1;left<right;left++,right--) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }*/

        //通过位运算交换
        for (int left=0,right=s.length-1;left<right;left++,right--) {
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
        }
    }
}
