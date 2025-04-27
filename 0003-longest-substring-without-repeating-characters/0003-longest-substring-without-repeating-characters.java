class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] input = s.toCharArray();
        Map<Character, Integer> cMap = new HashMap<>();
        int max = 0;
        int left=0;
        for(int i=0;i<s.length();i++){
            char currentC = input[i];
            if(cMap.containsKey(currentC) && cMap.get(currentC)>=left){
                left = cMap.get(currentC)+1;
            }
           cMap.put(currentC, i);
            max= Math.max(max, i-left+1);
        }

        return max;
    }

}