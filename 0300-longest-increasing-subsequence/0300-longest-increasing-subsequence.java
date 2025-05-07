class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1); // every element is 1 size long sequence

        for(int i=1; i<nums.length;i++){
                for(int j=0;j<i;j++){
                    if(nums[j] < nums[i]){ // smaller previous element is the candidate
                        dp[i] = Math.max(dp[i], dp[j]+1);
                         max = Math.max(max, dp[i]);
                    }
                }
        }
        return max;
    }
}