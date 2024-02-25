import java.util.Arrays;

public class T977 {
    /**
     * 双指针法
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int[] result = new int[nums.length];
        int index = result.length - 1;

        while (left <= right) {
            //if (nums[left] * nums[left] < nums[right] * nums[right]) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                result[index--] = nums[right] * nums[right--];
            } else {
                result[index--] = nums[left] * nums[left++];
            }
        }
        return result;
    }

    /**
     * 暴力解法
     * @param nums
     * @return
     */
    public int[] sortedSquares2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
