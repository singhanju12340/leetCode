class Solution {

// best solution
// O(N) N space 
     public int findJudge(int n, int[][] trust) {
        int[] pairArray = new int[n+1];
        

           for(int t[] : trust){
            pairArray[t[0]]--;     // outdegree
            pairArray[t[1]]++;   // indegree
        }
        
        for(int i=1;i<=n;i++){
            if(pairArray[i]==n-1) return i;
        }
        
        return -1;
    }


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

// hashmap based solution, O(N) + space O(2N)
    public int findJudge3(int n, int[][] trust) {
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