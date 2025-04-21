class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        int j=0;
        if(nums.length==1){
            return;
        }
        while(j<nums.length){
            if(nums[j]!=0){
                nums[i++] = nums[j];
            }
            j++;
        }

        while(i<nums.length){
            nums[i++] = 0;
        }
    }
}