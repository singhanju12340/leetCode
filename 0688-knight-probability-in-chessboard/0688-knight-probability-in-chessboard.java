class Solution {

    private static final int[][] MOVES = {
        {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
        {1, -2}, {1, 2}, {2, -1}, {2, 1}
    };

    public double knightProbability(int n, int k, int row, int column) {
        // Start the recursive calculation from the initial state
        double[][][] dp = new double[k+1][n][n];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1.0);
            }
        }

        return solveDp(n, k, row, column, dp);
    }


    private double solveDp(int n, int k, int r, int c, double[][][] dp) {
        // Base Case 1: If the knight is off the board
        if (r < 0 || r >= n || c < 0 || c >= n) {
            return 0.0; // 0 probability of staying on board if already off
        }

        if(dp[k][r][c] != -1)
            return dp[k][r][c];

        // Base Case 2: If no moves are remaining
        if (k == 0) {
            return 1.0; // 100% probability of staying on board if 0 moves left and currently on board
        }

        // Recursive Step: Calculate probability for 8 possible next moves
        double totalProbabilityFromHere = 0.0;

        for (int[] move : MOVES) {
            int nextR = r + move[0];
            int nextC = c + move[1];

            // For each move, add 1/8th of the probability from the next state
            totalProbabilityFromHere += solveDp(n, k - 1, nextR, nextC, dp) / 8.0;
        }

        dp[k][r][c] = totalProbabilityFromHere;

        return dp[k][r][c];
    }

    private double solve(int n, int k, int r, int c) {
        // Base Case 1: If the knight is off the board
        if (r < 0 || r >= n || c < 0 || c >= n) {
            return 0.0; // 0 probability of staying on board if already off
        }

        

        // Base Case 2: If no moves are remaining
        if (k == 0) {
            return 1.0; // 100% probability of staying on board if 0 moves left and currently on board
        }

        // Recursive Step: Calculate probability for 8 possible next moves
        double totalProbabilityFromHere = 0.0;

        for (int[] move : MOVES) {
            int nextR = r + move[0];
            int nextC = c + move[1];

            // For each move, add 1/8th of the probability from the next state
            totalProbabilityFromHere += solve(n, k - 1, nextR, nextC) / 8.0;
        }

        return totalProbabilityFromHere;
    }


}