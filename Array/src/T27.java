public class T27 {
    /**
     * 相向双指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 找左边等于val的元素
            while (left <= right && nums[left] != val) {
                left++;
            }
            // 找右边不等于val的元素
            while (left <= right && nums[right] == val) {
                right--;
            }
            // 将右边不等于val的元素覆盖左边等于val的元素
            if (left <= right) {
                nums[left++] = nums[right--];
            }
        }
        // leftIndex一定指向了最终数组末尾的下一个元素
        return left;
    }

    /**
     * 双指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElement3(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    /**
     * 暴力解法
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            // 发现需要移除的元素，就将数组集体向前移动一位
            if (nums[i] == val) {
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                // 因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
                i--;
                // 此时数组的大小-1
                size--;
            }
        }
        return size;
    }
}
