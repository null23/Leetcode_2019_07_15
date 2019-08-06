package 排序.基本排序;

import java.util.Arrays;

/**
 * Created by qianji.wang on 2019/7/8.
 * 快速排序
 * 几个概念：
 *      1.partitionIndex：分割数组的节点，左边都小于，右边都大于
 *
 *      2.递归树：递归拆解后的分支组成的树
 *      在快排中，递归树其实就是partitionIndex分割出的左右子树，左边都小于partitionIndex(根节点)，右边都大于partitionIndex
 *
 *      3.两个指针：i和j，i用来标记遍历的位置，j用来标记比v大的位置，当找到一个小于v的i的位置，和j交换即可
 *      arr[left + 1, j - 1] < partitionIndex < arr[j + 1, i]
 */
public class QuickSort1 {
    // 4  0  7  1  5  6  3  2
    //v/j i
    //arr[v, j] 小于 v，arr[j+1, i) 大于 v
    public static void quickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        int partitionIndex = partition(arr, left, right);
        quickSort(arr, left, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, right);
    }

    public static int partition(int[] arr, int left, int right){
        //小于v的边界值
        int j = left;

        /**
         * todo 优化
         * 把v的值随机在数组中随机取一个，然后再交换left和随机位置的元素即可，这样原来的代码逻辑是不用改变的
         * 这里优化了递归树的平衡度，避免了有序数组的递归树的高度是n
         */
        //哨兵，区间的最左边第一个起始值
        int v = arr[left];

        for(int i=left+1; i< right; i++){
            if(arr[i] <= v){
                //swap
                if(i != j){
                    int temp = arr[j+1];
                    arr[j+1] = arr[i];
                    arr[i] = temp;
                }
                j++;
            }
        }

        int temp = arr[left];
        arr[left] = arr[j];
        arr[j] = temp;

        return j+1;
    }

//    public static int partition2(int[] arr, int left, int right){
//        int v = arr[left];
//        int i = right;
//        int j = left+1;
//
//        while (j != i && j < right && i > left+1) {
//            if (arr[j] >= v && arr[i] <= v) {
//                int temp = arr[j];
//                arr[j] = arr[i];
//                arr[i] = temp;
//            }
//            if (arr[j] < v) {
//                j++;
//            }
//            if (arr[i] >= v) {
//                i--;
//            }
//        }
//
//        int temp = arr[left];
//        arr[left] = arr[j-1];
//        arr[j-1] = temp;
//
//        return j-1;
//    }

    public static int partition2(int[] arr, int left, int right){
        int v = arr[left];
        int i = left + 1;
        int j = right;

        //5,7,8,9,6,3,1,4,5,10
        while (true) {
            while(i <= right && arr[i] < v){
                i++;
            }
            while(j >= left+1 && arr[j] > v){
                j--;
            }
            if(i > j){
                break;
            }
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            j--;
        }

        int temp = arr[left];
        arr[left] = arr[j];
        arr[j] = temp;

        return j;
    }



    public static void main(String[] args) {
//        int[] arr = {5,7,8,9,6,3,1,4,5,10};
//        int[] arr = {8,5,2,5,7,8,7,10,5,7};
        int[] arr = new int[10000000];
        for(int i=0;i<10000000;i++){
            arr[i] = (int)(1+Math.random()*(10-1+1));
        }


        System.out.println("quick sort start...");

        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length-1);
        System.out.println("cost : " + (System.currentTimeMillis() - start));

    }

}
