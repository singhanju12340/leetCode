class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int num=plants.length;
        int a=0;
        int b=num-1;
        int refil_count=0;
        int a_can=capacityA;
        int b_can=capacityB;

        while(a<=b){
            if(a == b){
                if(a_can<b_can){
                    if(b_can<plants[a])refil_count++;
                }else{
                    if(a_can<plants[a])refil_count++;
                }
                break;
            }
            if(plants[a]>a_can){
                refil_count++;
                a_can=capacityA;
            }
            if(plants[b]>b_can){
                refil_count++;
                b_can=capacityB;
            }
            a_can-=plants[a];
            b_can-=plants[b];
            a++;
            b--;
        }
        return refil_count;
    }
    
}