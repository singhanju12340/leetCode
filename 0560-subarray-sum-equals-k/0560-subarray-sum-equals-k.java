class Solution {

    // n2 + extra space solution, too bad 1500ms 
    public int subarraySum2(int[] nums, int k) {
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



   public int subarraySum(int[] nums, int k) {
        // it will contain difference sum as key and its frequency as value
        // as we are calculating prefix sum, so we know all the existence of sum till current index.
        Map<Integer, Integer> map = new HashMap<>();
        int currentSum=0;
        int result =0;
        map.put(0,1); // if current num=k. it should be taken as a single subarray

        for(int i=0;i<nums.length;i++){
            currentSum+=nums[i];
           if(map.containsKey(currentSum-k)){
               result += map.get(currentSum-k);
           }
           map.put(currentSum, map.getOrDefault(currentSum,0)+1);
        }
        return result;
    }
}