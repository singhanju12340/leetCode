class Solution {

    // storing leftmaxprefix and rightmaxsuffix in array
    // complexity: O(N) + space= )(2N)
    public int trapDp(int[] height) {
        Stack<Integer> st = new Stack<Integer>();
        // find left max
        // find right max
        // find  water by store at i =  max(0, 1 * (min(lMax[i], Rmax[i]) - heigth[i])). ignore -ve vol calculation by taking max from calculation and 0.
        // cal to find width = min(lMax[i], Rmax[i]) - heigth[i]
        // 

        int totalWater = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        // calculate left max 
        for(int i=1;i<height.length;i++){
            leftMax[i] = Math.max( leftMax[i-1],height[i]);
        }


        rightMax[height.length-1] = height[height.length-1];
        // calculate right max 
        for(int i=height.length-2;i>=0;i--){
            rightMax[i] = Math.max( rightMax[i+1],height[i]);
        }


        for(int i=0;i<height.length;i++){
            totalWater = totalWater + Math.max(0, Math.min(leftMax[i], rightMax[i])-height[i] );
        }

        return totalWater;
    }

    public  int trap(int[] height) {
        int leftMax=0;
        int rightMax=0;
        int max=0;
        int left =0;
        int right = height.length-1;
        while(left<=right){
            if(height[left] <= height[right]){
                if(height[left] >= leftMax)
                    leftMax = height[left];
                else
                    max += leftMax-height[left];
                
                left++;
            }else{
                if(height[right] >= rightMax)
                    rightMax = height[right];
                else
                    max += rightMax-height[right];
                right--;    
            }
            
        }
        return max;
    }

}