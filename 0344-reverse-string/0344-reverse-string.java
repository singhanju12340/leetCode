class Solution {
    public void reverseString(char[] s) {
        int low = 0;
        int heigh = s.length-1;
        while(low<heigh){
            char temp = s[low];
            s[low]=s[heigh];
            s[heigh] = temp;
            low++;
            heigh--;
        }
    }
}