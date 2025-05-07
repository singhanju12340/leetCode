class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites)  {
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        Stack<Integer> result = new Stack<>();

        for(int[] each: prerequisites){
            indegree[each[1]] = indegree[each[1]]+1;
        }

        // inset all zeoro indegree to queue
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)
                queue.add(i);
        }


        while(!queue.isEmpty()){
            Integer nodeToRemove = queue.poll();
            result.push(nodeToRemove);

            // check if any new indegree zero, add it to queue

            for(int[] link:prerequisites){
                if(link[0] == nodeToRemove){
                    indegree[link[1]]--;
                    if(indegree[link[1]] ==0)
                        queue.add(link[1]);
                }
            }

        }

        if(result.size()==numCourses){
            int[] newRes = new int[numCourses];
            int i=0;
            while(!result.isEmpty()){
                newRes[i++] = result.pop();
            }
            return newRes;
        }
        else{
            return new int[]{};
        }

    }

}