class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-1;
if(nums.length == 1)
    return;

        while(i>=1 && nums[i-1]>nums[i]){
            i--;
        }
        int left = i-1;

        if(i==0 && nums[i] > nums[i+1]){
            swap(nums,0,nums.length-1);
            return;
        }

        int j=left+1;
        while(j<nums.length-1 && nums[left]<nums[j]){
            j++;
        }
        swap(nums, left, j);

        int x=left+1;
        int y=nums.length-1;

        while(x<y){
            swap(nums, x, y);
        }

    }

    public void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}