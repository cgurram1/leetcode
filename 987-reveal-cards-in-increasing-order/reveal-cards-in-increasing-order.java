class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int [] res = new int[deck.length];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<deck.length;i++){
            queue.add(i);
        }
        int i = 0;
        int nextAvail;
        int canFill = 1;
        while(!queue.isEmpty()){
            nextAvail = queue.poll();
            if(canFill == 1){
                res[nextAvail] = deck[i];
                i++;
                canFill = 0;
            }
            else{
                queue.add(nextAvail);
                canFill = 1;
            }
        }
        return res;
    }
}