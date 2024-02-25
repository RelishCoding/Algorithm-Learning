public class T283 {
    /**
     * 双指针，遇到非零元素直接交换
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    /**
     * 双指针，最后将数组末尾元素置为0
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 暴力解法
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                size--;
            }
        }
        for (int i = size; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
