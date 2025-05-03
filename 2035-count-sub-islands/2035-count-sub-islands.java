class GNode{
    int x;
    int y;
    GNode(int x, int y){
        this.x=x;
        this.y = y;
    }
}
class Solution {
    public boolean isValid=true;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for(int i=0;i<grid2.length;i++){

            for(int j=0;j<grid2[0].length;j++){

                if(grid2[i][j] == 1){
                    dfs(grid1, grid2, i, j);
                    if(isValid) // if its a subarray
                        count++;
                    isValid = true;    
                }
            }
        }
        return count;
        
    }


    public void dfs(int[][] grid1,int[][] grid2, int x, int y){
        
        if(x>=0 && y>=0 && x<grid2.length && y<grid2[0].length 
        && grid2[x][y] == 1)
        {
            if(grid1[x][y] == 0)
                isValid=false;
            grid2[x][y] = 0;
            dfs(grid1, grid2, x, y+1);
            dfs(grid1, grid2, x+1, y);
            dfs(grid1, grid2, x, y-1);
            dfs(grid1, grid2, x-1, y);
        }
    }
}