class Solution {
    public long validSubstringCount(String word1, String word2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<word2.length();i++){
            map.put(word2.charAt(i), map.getOrDefault(word2.charAt(i),0)+1);
        }
        int left = 0;
        long count = 0;
        int charsRemaining = word2.length();
        for(int right = 0;right < word1.length();right++){
            map.put(word1.charAt(right), map.getOrDefault(word1.charAt(right),0) - 1);
            if(map.get(word1.charAt(right)) >= 0){
                charsRemaining-=1;
            }
            while(left <= right && charsRemaining == 0){
                count+=(word1.length() - right);
                map.put(word1.charAt(left), map.get(word1.charAt(left)) + 1);
                if(map.get(word1.charAt(left)) > 0){
                    charsRemaining+=1;
                }
                left+=1;
            }
        }
        return count;

    }
}