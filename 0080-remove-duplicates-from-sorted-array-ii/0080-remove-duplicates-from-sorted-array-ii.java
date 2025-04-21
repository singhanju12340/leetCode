class Solution {
    public int removeDuplicates(int[] nums) {
                int i=0;
        int j=0;
        int count;
        while(j<nums.length-1){
            count=1;
            while(j<nums.length-1 && nums[j] == nums[j+1]){
                count++;
                j++;
            }
            j++;
            nums[i++] = nums[j-1];
            if(count>1){
                nums[i++] = nums[j-1]; // add twice
            }
        }
        if(j==nums.length-1)
            nums[i++] = nums[j];
        return i;
    }   

    
}