class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] arr = new int[nums.length];

        int positive = 0;
        int negative = 1;

        for(int i : nums){

            if(i > 0){
                arr[positive] = i;
                positive += 2;
            }
            else{
                arr[negative] = i;
                negative += 2;
            }
        }
        return arr;

    }
}