class Solution {
    //time limit exceeded for input [1,2,3,10,2147483647,9]

    public int firstMissingPositive2(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                if(nums[i]< min)
                    min = nums[i];
                if(nums[i]>max)
                    max = nums[i];    
            }
        }

        if(min>1)
            return 1;

        boolean[] arr = new boolean[max-min+1];

        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                arr[nums[i]-min] = true;
            }
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i] == false)
                return i+min;
        }

        return max+1;

    }

    public int firstMissingPositive(int[] nums) {
    

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                  while(nums[i]>0 && nums[i]<=nums.length && nums[nums[i]-1] != nums[i]){
                    int curr = nums[i]-1;
                    int temp = nums[i];
                    nums[i] = nums[curr];
                    nums[curr] = temp;
                }

            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }

        return nums.length+1;
    }
}