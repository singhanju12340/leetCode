class Solution {
    public int maxArea(int[] height) {
        int left =0;
        int right = height.length-1;
        int max = 0;
        while(left < right){
            int minHeight = Math.min(height[right], height[left]);
            max = Math.max(max, (minHeight* (right-left)));
            
            while(left<right && height[left] <= minHeight){
                left++;
            }
            
            while(left<right && height[right] <= minHeight){
                right--;
            }
        }
        return max;
    }
}