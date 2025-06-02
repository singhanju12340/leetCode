class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        boolean survived = true;
        for(int i=1;i<asteroids.length;i++){
            int current = asteroids[i];
            survived = true;
            
            while(!stack.isEmpty() && stack.peek()>0 && current< 0){
                if(Math.abs(stack.peek())< Math.abs(current)){
                    stack.pop();
                }else if(Math.abs(stack.peek()) ==  Math.abs(current)){
                    stack.pop();
                    survived = false;
                    break;
                }else{
                    survived = false;
                    break;
                }
            }
            if( survived){
                stack.push(current);
            }
        }

        int[] result = new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            result[i] = stack.pop();
        }

        return result;
    }
}