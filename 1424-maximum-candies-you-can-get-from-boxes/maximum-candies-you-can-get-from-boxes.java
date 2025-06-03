class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> availableBoxes = new LinkedList<>();
        Set<Integer> availableKeys = new HashSet<>();
        int result = 0;
        for(int i = 0;i<initialBoxes.length;i++){
            availableBoxes.add(initialBoxes[i]);
        }
        while(!availableBoxes.isEmpty() && atLeastOneBoxToOpen(availableBoxes,availableKeys,status)){
            if(status[availableBoxes.peek()] == 1 || availableKeys.contains(availableBoxes.peek())){
                int currentBox = availableBoxes.poll();
                result+=candies[currentBox];
                for(int i = 0;i<keys[currentBox].length;i++){
                    availableKeys.add(keys[currentBox][i]);
                }
                for(int i = 0;i<containedBoxes[currentBox].length;i++){
                    availableBoxes.add(containedBoxes[currentBox][i]);
                }
            }
            else{
                availableBoxes.add(availableBoxes.poll());
            }
        }
        return result;
    }
    public boolean atLeastOneBoxToOpen(Queue<Integer> availableBoxes, Set<Integer> availableKeys, int[] status){
        for (int box : availableBoxes) {
            if(status[box] == 1){
                return true;
            }
            if(availableKeys.contains(box)){
                return true;
            }
        }
        return false;
    }
}