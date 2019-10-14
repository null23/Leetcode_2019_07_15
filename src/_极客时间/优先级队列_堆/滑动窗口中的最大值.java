package _极客时间.优先级队列_堆;

import java.util.ArrayDeque;

/**
 * leetcode 239
 */
public class 滑动窗口中的最大值 {

    //ps：大顶堆是暴力解法的升级版，双端队列是大顶堆的升级版

    /**
     * 使用大顶堆
     * 时间复杂度：O(logK * n)
     * 每次维护大顶堆的时间复杂度为logK，一共有n个元素，因此时间复杂度为O(logK * n)
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        return nums;
    }

    /**
     * 使用双端队列
     * 由于只需要滑动窗口的最大值，因此我们无需维护第二大，第三大的值
     * 时间复杂度：O(n)
     */
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int [] nums;

    /**
     * 清除所有窗口之外的，或者小于窗口最大值的右边的值
     * 也就是，双端队列的最左侧，永远都是窗口最大的值
     */
    public void clean_deque(int i, int k) {
        if (!deq.isEmpty() && deq.getFirst() == i - k)
            deq.removeFirst();

        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])
            deq.removeLast();
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        // init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx]) max_idx = i;
        }
        int [] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        // build output
        for (int i  = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }

}
