class Solution {
    private long count;
    private long[][][] memo; 
    public long numberOfWays(String s) {
        // numberOfWaysRecc(s, 0, 0, -1);
        // return count;

        // DP top down solution 

        memo = new long[s.length()][4][3];     // Dimensions: index (up to n), selectedCount (0 to 3), lastSelectedType (-1, 0, 1 -> mapped to 0, 1, 2)

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 4; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return findCombinationsDp(s, 0, 0,-1);
    }

    public void numberOfWaysRecc(String s, int index, int currCount, int lastSelected) {
        if(currCount == 3){
                count++;
                return;
        }

        if(index == s.length()){
            return;
        }
        numberOfWaysRecc(s, index+1, currCount, lastSelected);

        int currentVal = s.charAt(index)-'0';

        if(lastSelected ==-1 || lastSelected != currentVal){
             numberOfWaysRecc(s, index+1, currCount+1, currentVal);
        }

    }


    private long findCombinationsDp(String s, int index, int selectedCount, int lastSelectedType) {
        if (selectedCount == 3) {
            return 1;
        }

        if (index == s.length()) {
            return 0;
        }

        int lastTypeIdx = lastSelectedType + 1; 
        if (memo[index][selectedCount][lastTypeIdx] != -1) {
            return memo[index][selectedCount][lastTypeIdx];
        }

        long ways = 0;
        ways += findCombinationsDp(s, index + 1, selectedCount, lastSelectedType);
        int currentType = s.charAt(index) - '0'; // Convert '0' to 0, '1' to 1
        if (lastSelectedType == -1 || currentType != lastSelectedType) {
            ways += findCombinationsDp(s, index + 1, selectedCount + 1, currentType);
        }
        memo[index][selectedCount][lastTypeIdx] = ways;
        return ways;
    }

 
}