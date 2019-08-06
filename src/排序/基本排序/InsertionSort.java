package 排序.基本排序;

/**
 * Created by qianji.wang on 2019/6/25.
 * 插入排序
 * 看图说话:https://visualgo.net/en/sorting
 * 从有序区的尾部，依此往左移动判断大小，如果不用移动，跳过本次循环
 */
public class InsertionSort {
    public static int[] insertionSort(int[] arr){
        if(arr.length==1){
            return arr;
        }
        for(int i=1;i<arr.length;i++){
            int j=i-1;
            int value=arr[i];
//            // 3 5 4
            for(;j>=0;j--){
                if(value < arr[j]){
                    arr[j+1]=arr[j];
                }else{
                    break;
                }
            }
            //j+1是必须的，因为此时j的位置，是比插入元素小的位置，要往后再挪一个，才是有序区的边界点
            arr[j+1]=value;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4,1,4,5,6,0,-1,-10,-5,20,7, 1, 5, 2, 5, 4, 10, 9, 11};
//        int[] arr = new int[]{3, 5,4};
        for(int i : insertionSort(arr)){
            System.out.println(i);
        }
    }
}
