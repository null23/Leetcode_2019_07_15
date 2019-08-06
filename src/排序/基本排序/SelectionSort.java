package 排序.基本排序;

/**
 * Created by qianji.wang on 2019/6/24.
 * 选择排序
 * 分为有序区和无序区
 * 有序区，是每次循环把最小的一个数值放到有序区区间的最右边，也就是有序区和无序区的交界处
 * 其实就是每次遍历找出最小的值，放到左边
 */
public class SelectionSort {
    public static int[] selectionSort(int[] arr){
        for(int i=0; i< arr.length; i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        for(int i : selectionSort(new int[]{3, 4,1,4,5,6,0,-1,-10,-5,20,7, 1, 5, 2, 5, 4, 10, 9, 11})){
            System.out.println(i);
        }
    }
}
