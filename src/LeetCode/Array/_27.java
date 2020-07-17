package LeetCode.Array;

import java.util.Arrays;

/**
 * 双指针
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
