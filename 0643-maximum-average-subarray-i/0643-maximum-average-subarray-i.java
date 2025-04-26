class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length<k)
            return 0.0;

        double currentSum=0.0;

        for(int j=0;j<k;j++){
            currentSum+=nums[j];
        }
        double max = currentSum/k;

        for(int i=k;i<nums.length;i++){
            currentSum -= nums[i-k];
            currentSum = currentSum+nums[i];
            max = Math.max(max, currentSum/k);
        }
        return max;
    }
}