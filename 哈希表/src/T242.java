import java.util.Arrays;

public class T242 {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            //并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
            record[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (record[i]!=0){
                // record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符
                return false;
            }
        }
        //record数组所有元素都为零0，说明字符串s和t是字母异位词
        return true;

        /*if (s.length()!=t.length()){
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i]!=chars2[i]){
                return false;
            }
        }
        return true;*/
    }
}
