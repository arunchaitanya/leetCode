package com.arung.leetCode.medium;



public class SelfProductSansDiv {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0)
            return nums;
        int length = nums.length;
        int[] left = new int[nums.length];
        int[] result = new int[nums.length];
        left[0] = 1;
        for(int i = 1; i < nums.length; i++){
            left[i] = left[i-1] * nums[i-1]; 
        }
        int r = 1;
        //result[length-1] = left[length -1]; //1, 1, 2, 6 [1*  3*  2*4  6
        for(int i =length -1; i >=0; i--){
            result[i] = left[i] * r; // 
            r *= nums[i];
        }
        
        return result;
    }

    public static void main(String[] args) {
        SelfProductSansDiv s = new SelfProductSansDiv();
        int[] nums = new int[]{1, 2, 4, 6};
        int[] result = s.productExceptSelf(nums);
        for (int product : result) {
            System.out.print(product+" ");
            
        }
    }
}