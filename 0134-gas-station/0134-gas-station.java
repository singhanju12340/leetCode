class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalGas < totalCost) {
            return -1;
        }

        // there is a soultion present find starting point 
            int currentFuel = 0;
            int start = 0;

        for(int i=0;i<gas.length;i++){
            currentFuel = currentFuel+ gas[i]-cost[i];
            if(currentFuel<0){
                currentFuel=0;
                start = i+1;
            }
        }
        return start;
    }
}