package _极客时间.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1za
 */
public class 两数之和 {

    public int[] twoSum(int[] nums, int target) {
        if(nums == null){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[] {map.get(target - nums[i]), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
