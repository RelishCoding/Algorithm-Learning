public class T736 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length<=1){
            return nums.length;
        }
        int curDiff = 0;//当前元素与其后面元素的差值
        int preDiff = 0;//当前元素与其前面元素的差值,初始化为0是为了默认第一个元素前面会延长一段
        int result = 1;// 记录峰值个数，序列默认序列最右边有一个峰值

        //最右边元素默认有一个波动，所以遍历到倒数第二个元素就行
        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i+1]-nums[i];
            //出现峰值
            if ((preDiff<=0 && curDiff>0) || (preDiff>=0 && curDiff<0)){
                result++;
                preDiff=curDiff;//只在摆动变化的时候更新preDiff
            }
        }
        return result;
    }
}
