public class T26 {
    /**
     * 双指针版本二
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int dest = 1;
        for (int src = 1; src < nums.length; src++) {
            if (nums[src] != nums[src - 1]) {
                nums[dest++] = nums[src];
            }
        }
        return dest;
    }

    /**
     * 双指针版本一
     * @param nums
     * @return
     */
    public int removeDuplicates3(int[] nums) {
        int dest = 0;
        int src = 0;
        for (; src < nums.length -1; src++) {
            if (nums[src] != nums[src + 1]) {
                nums[dest++] = nums[src];
            }
        }
        nums[dest++] = nums[src];
        return dest;
    }

    /**
     * 暴力解法
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i + 1; j < size - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                size--;
                i--;
            }
        }
        return size;
    }
}
