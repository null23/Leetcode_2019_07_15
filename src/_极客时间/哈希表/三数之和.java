//package _极客时间.哈希表;
//
//import java.util.*;
//
///**
// * leetcode 15
// */
//public class 三数之和 {
//
//    /**
//     * 两次循环，使用哈希表
//     */
//    public static List<List<Integer>> threeSum1(int[] nums) {
//        if(nums == null){
//            return null;
//        }
//        List<List<Integer>> res = new ArrayList<>();
//        for(int i = 0; i < nums.length; i++){
//            Map<Integer, Integer> map = new HashMap<>();
//            map.put(nums[i], i);
//            for(int j = i + 1; j < nums.length; j++){
//                if(map.containsKey(-(i + j))){
//                    res.add(Arrays.asList(nums[i], nums[j], -(i + j)));
//                }else{
//                    if(map.containsKey()){
//
//                    }
//                    map.put();
//                }
//            }
//        }
//
//        System.out.println(res);
//
//        return res;
//    }
//
//    public static void main(String[] args) {
//        threeSum1(new int[]{-1, 0, 1, 2, -1, -4});
//    }
//}
