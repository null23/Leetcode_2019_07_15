package LeetCode.Array;


/**
 * 双指针
 *  解题思路
 *   维护两个快慢指针，快指针的作用是跳过重复项，慢指针的作用是维护不同的元素的个数
 *
 */
public class _26 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(removeDuplicates(array));
    }
}
