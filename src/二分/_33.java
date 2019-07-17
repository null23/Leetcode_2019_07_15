package 二分;

/**
 * Created by qianji.wang on 2019/7/15.
 * 搜索旋转排序数组
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 思路：
 * 1.二分查找，找到旋转的分界节点
 * 2.在旋转的分界做二分查找
 */
public class _33 {

    //4 5 6 7 0 1 2
    public static int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            if(nums[0] == target){
                return 0;
            }else{
                return -1;
            }
        }
        //有序数组的分界线
        int rotatedIndex = findRotatedIndex(nums);
        if(nums[rotatedIndex] == target){
           return rotatedIndex;
        }

        //说明在分界线右边
        if(nums[0] > target){
            int lo = rotatedIndex+1;
            int hi = nums.length-1;
            return binarySearch(nums, target, hi, lo);
        //在分界线左边
        }else{
            int lo = 0;
            int hi = rotatedIndex - 1;
            return binarySearch(nums, target, hi, lo);
        }
    }

    //二分查找
    public static int binarySearch(int nums[], int target, int hi, int lo){
        while(lo <= hi){
            int mid = hi-((hi-lo)>>1);
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return -1;
    }

    //寻找旋转节点
    public static int findRotatedIndex(int[] nums){
        int lo = 0;
        int hi = nums.length-1;

        while(lo <= hi){
            int mid = hi-((hi-lo)>>1);
            if(mid == 0 || mid == nums.length-1){
                return mid;
            }

            //寻找旋转的节点
            //这里不能是mid-1，因为mid有可能为0。但是mid肯定比hi小，mid+1一定是存在的，所以和mid+1比较。
            if(nums[mid] > nums[mid+1]){
                return mid;

                //mid不是旋转节点，继续查找旋转节点
            }else{
                //说明旋转节点在右边
                if(nums[mid] > nums[0]){
                    lo = mid + 1;
                //说明旋转节点在左边
                }else{
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {1,0};
        System.out.println(search(nums, 1));

//        System.out.println(findRotatedIndex(nums));
    }
}
