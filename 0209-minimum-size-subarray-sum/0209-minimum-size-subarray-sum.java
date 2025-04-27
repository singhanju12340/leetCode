class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int min = Integer.MAX_VALUE;
        int currSum=0;
        while(i<nums.length){
            currSum+=nums[i++];
            if(currSum>=target){
                while(currSum>=target){
                    currSum-=nums[j++];
                }
                min = Math.min(min, i-(j-1));
            }
        }
        return min==Integer.MAX_VALUE ? 0 : min;
    }
}