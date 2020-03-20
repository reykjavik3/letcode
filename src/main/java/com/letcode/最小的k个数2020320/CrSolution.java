package com.letcode.最小的k个数2020320;

/**
 * @author licongrong
 * @create 2020-03-20 21:12
 *
 *
 * 今天没用编译器，在页面上硬写的，没提示寸步难行
 */
public class CrSolution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length==0||arr==null||k==0){
            return new int[0];
        }
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int tmp = arr[j];
                    arr[j]=arr[i];
                    arr[i]=tmp;
                }
            }
        }
        int[] re = new int[k];
        for(int i=0;i<k;i++){
            re[i]=arr[i];
        }
        return re;
    }
}
