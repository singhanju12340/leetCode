class Solution {
    public int pivotIndex(int[] nums) {
        int j=nums.length;
        if(nums.length ==0)
            return -1;

        int leftSum=0;
        int rightSum = 0;
        for(int num : nums) 
          rightSum += num;

        for(int i=0;i<j;i++){
            rightSum -= nums[i];
            if(leftSum == rightSum)
                return i;
            leftSum +=nums[i];
        }
        
        return -1;
    }
}