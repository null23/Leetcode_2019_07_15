package LeetCode.Array;

import java.util.Arrays;

/**
 * 双指针
 *  解题思路：
 *   题目没有要求顺序，因此从数组最开始维护一个索引i，然后通过索引j遍历数组，只要发现j符合条件就交换两个索引位置的数据
 *
 *   时间复杂度：O(n)
 *   空间复杂度：O(1)
 */
public class _27 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }

//    public static void main(String[] args) {
//        int[] array = {3, 2, 2, 3};
//        System.out.println(removeElement(array, 3));
//    }
}
