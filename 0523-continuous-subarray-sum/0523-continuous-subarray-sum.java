class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int currentSum=0;
        map.put(0,-1); // for example:[23,2,4,6,6]


        for(int i=0;i<nums.length;i++){
            currentSum+=nums[i];

// if there is any remainder already present, means the values between these 2 indexes are multiple of k 
// ex: 23,2,4,6:  on 23th value remainder is 5. after adding 2+4= to 23, again remainder is 5( 29%6=5)
// it means added value from 23 to current is divisible of k

            if(map.containsKey(currentSum%k) && map.get(currentSum%k)<=i-2){
                return true;
            }
            
            else if(map.containsKey(currentSum%k)){
                continue;
            }else{
                map.put(currentSum%k,i);
            }
        }

        return false;
    }
}