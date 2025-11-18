class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for(Integer num: nums){
            set.add(num);
        }
        int resCount = 0;

// as its already counted in other sequence.
// ex: 3 is already present, then 4 will come in the sequence.
        for(Integer eset: set){
            if(!set.contains(eset-1)){ // if current is start of sequence
                int count=1;
                int current = eset;
                while(set.contains(current+1)){
                    current++;
                    count++;
                }
                resCount = Math.max(resCount, count);
            }
                
        }
        
        return resCount;
    }
}