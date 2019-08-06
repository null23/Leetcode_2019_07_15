package 排序.基本排序;

/**
 * Created by qianji.wang on 2019/6/28.
 * 归并排序：分治
 * 将数组拆成两半，分别对左右两边进行排序
 * 递归拆分之后，就是两个单个元素的比较，单个元素肯定是有序的
 */
public class MergeSort {
    public static int[] sort(int[] arr){
        sort(arr, 0, arr.length-1);
        return arr;
    }

    public static void sort(int[] arr, int left, int right){
        if(left>=right){
            return;
        }
        int mid = (left+right) >> 1;
        //分治 分别对左边 右边 两个进行排序，然后进行merge
        sort(arr, left, mid);
        sort(arr, mid+1, right);
        //merge 左右两个排序好的数组
        merge(arr, left, right, mid);
    }

    public static void merge(int[] arr, int left, int right, int mid){
        //申请一个临时数组
        int[] temp = new int[right-left+1];

        int i=left;
        int j=mid+1;
        int index = 0;
        //类似于插入排序的思想，可以使用插入排序来优化空间复杂度
        while(i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[index++]=arr[i++];
            }
            if(arr[j]<=arr[i]){
                temp[index++]=arr[j++];
            }
        }

        //把左边数组剩下的都填充
        while(i<=mid){
            temp[index++]=arr[i++];
        }
        //把右边数组剩下的都填充
        while(j<=right){
            temp[index++]=arr[j++];
        }

        //遍历填充
        for(i=0;i<temp.length;i++){
            arr[left+i]=temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,0,1,4,5};
        sort(arr);
        for(int num:arr){
            System.out.println(num);
        }
    }
}
