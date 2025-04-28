class Solution {
    public int subarraySum(int[] nums, int k) {
        int result=0;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            prefixSum[i] = prefixSum[i-1]+nums[i];
        }

         for(int i=0; i<nums.length; i++){
            if(prefixSum[i]==k)
                result++;
            for(int j=i+1; j<nums.length; j++){
                if( prefixSum[j]-prefixSum[i] == k)
                result++;
            }
        }
        return result;
    }
}