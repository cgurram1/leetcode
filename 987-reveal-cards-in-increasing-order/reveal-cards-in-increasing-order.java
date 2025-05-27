class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int [] res = new int[deck.length];
        Arrays.fill(res,-1);
        int i = 0;
        int j = 0;
        int canFill = 1;
        while(i < deck.length){
            if(res[j] == -1){
                if(canFill == 1){
                    res[j] = deck[i];
                    i++;
                    j++;
                    canFill = 0;
                }
                else{
                    canFill = 1;
                    j++;
                }
            }
            else{
                j++;
            }
            if(j == deck.length){
                j = 0;
            }
        }
        return res;
    }
}