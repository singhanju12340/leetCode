class Solution {
    
     public boolean isBipartite2(int[][] graph,  int[] color, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(color, -1);

        queue.add(start);
        while(!queue.isEmpty()){
            int current = queue.poll();
            int[] child = graph[current];

            if(color[current] == -1){
                color[current] = 0;
            }

            int parentColor = color[current];
            // check if child is in green
            for(int i=0;i<child.length;i++){
                int currentChild = child[i];
                if(color[currentChild]== (parentColor)){ // of same color as parent
                    return false;
                }else if(color[currentChild]==-1){ // no color filled till now
                    color[currentChild]=(parentColor^1);
                    queue.add(currentChild);
                }
                // opposite color processed child is ignored
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        int[] color = new int[graph.length]; // 0-red, 1-green, -1 not filled
        Arrays.fill(color, -1);

        for(int i=0;i<graph.length;i++){
            if(color[i]==-1)
               if(isBipartite2(graph, color, i) == false)
                return false;
        }
        return true;
    }




}