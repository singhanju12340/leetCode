class Solution {

    //time complexity = O(Nlog(k)), gave timeout need solution in O(n)
     public int[] maxSlidingWindow2(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int[] result = new int[nums.length-k+1];
        int j=0;
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
            if(queue.size()==k){
                result[j++] = queue.peek();
                queue.remove(nums[i-(k-1)]);
            }
        }
        return result;
    }


        public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new java.util.ArrayDeque<>();
        int[] result = new int[nums.length-k+1];

        for(int i=0;i<nums.length;i++){
            if(!deque.isEmpty() && deque.peekFirst()<= i-k){
                deque.removeFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()]< nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            if(i>=(k-1))
                result[i-(k-1)] =  nums[deque.peekFirst()];
            }
        return result;
    }
}