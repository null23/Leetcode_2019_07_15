package _极客时间.优先级队列_堆;

import java.util.PriorityQueue;

/**
 * leetcode 703
 */
public class 数据流中的TopK {

    /**
     * 这个题有两个注意的地方：
     * 1.用优先级队列维护
     *  Java中的优先级队列就是个小顶堆
     * 2.只有 新元素 > 小顶堆的堆顶，也就是新元素大于小顶堆的最小值的时候，才会加入小顶堆并重新堆化
     */
    public static class KthLargest{
        private PriorityQueue<Integer> queue;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.queue = new PriorityQueue<>(k);
            this.k = k;
            for(int num : nums){
                add(num);
            }
        }

        public int add(int val) {
            if(queue.size() < k){
                queue.offer(val);
            }else if(queue.peek() < val){
                queue.poll();
                queue.offer(val);
            }
            return queue.peek();
        }
    }

}
