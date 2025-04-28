class Solution {
    public int findJudge2(int n, int[][] trust) {
        int[] people = new int[1000];
        for(int i=0;i<trust.length;i++){
            int p = trust[i][0];
            int pTrust = trust[i][1];
            people[pTrust-1]++;
            if(people[pTrust-1] == n-1)
                return pTrust;
        }
        return -1;
    }

    public int findJudge(int n, int[][] trust) {
        int[] people = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
      if(trust.length==0 && n==1)
            return 1;

        for(int i=0;i<trust.length;i++){
            int p = trust[i][0];
            int pTrust = trust[i][1];
            map.computeIfAbsent(pTrust, k -> new HashSet<>()).add(p); 
            people[p-1] = 1;  
        }
        

        for( Map.Entry<Integer, Set<Integer>> entry: map.entrySet()){
            if(entry.getValue().size() == n-1 && people[entry.getKey()-1]==0)
                return entry.getKey();
        }

        return -1;
    }
}