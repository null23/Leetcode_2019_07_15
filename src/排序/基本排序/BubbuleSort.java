package 排序.基本排序;

/**
 * Created by qianji.wang on 2019/6/24.
 * 冒泡排序
 * 1.每次比较相邻的两个元素，把更大的元素放到最后边
 * 2.这样每次都可以保证最后的元素是有序的，下次再排序的时候，从有序的尾部之前继续排序
 *
 * 优化点：
 * 只要有一次排序没有元素的交换，就不用排序了，因为这时候已经是有序的了，直接break即可
 */
public class BubbuleSort {

    public static int[] bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            boolean flag = false;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag = true;
                    System.out.println("swap");
                }
            }
            if(!flag){
                return arr;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        for(int i : bubbleSort(new int[]{3, 4, 1, 5, 2, 5, 4, 10, 9, 11})){
            System.out.println(i);
        }
    }
}
