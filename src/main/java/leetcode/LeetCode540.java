package leetcode;

public class LeetCode540 {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        for (int i=0;i<nums.length;i+=2){
            if ((i+1<nums.length)&&nums[i]==nums[i+1]){
                continue;
            }
            return nums[i];
        }
        return nums[nums.length-1];
    }
    public int findIt(int num,int[] nums){
        int left=0,right=nums.length;
        while (left<right){
            int mid=(left+right)>>1;
            if(nums[mid]>num){
                right=mid-1;
            }else if (nums[mid]<num){
                left=mid+1;
            }else {
                return mid;
            }
        }
        return left;
    }
}
