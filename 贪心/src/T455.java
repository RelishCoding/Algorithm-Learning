import java.util.Arrays;

public class T455 {
    // 思路1：优先考虑饼干，小饼干先喂饱小胃口
    /*public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int index=0;
        for (int i=0;i<s.length;i++){
            //先判断index是否越界，再判断饼干和胃口的大小关系
            if (index<g.length && s[i]>=g[index]){
                count++;
                index++;
            }
        }
        return count;
    }*/

    // 思路2：优先考虑胃口，先喂饱大胃口
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int index=s.length-1;
        for (int i=g.length-1;i>=0;i--){
            //先判断index是否越界，再判断饼干和胃口的大小关系
            if (index>=0 && s[index]>=g[i]){
                count++;
                index--;
            }
        }
        return count;
    }
}
