/**
catsandog
cat[sand[og]],
cats[and[og]] 

wordDict = ["catsandog"]
 */
class Solution {
    public String str;
    public Set<String> words;
    public int [][] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        str = s;
        dp = new int[s.length()+1][s.length()+1];
        for(int [] arr : dp){
            Arrays.fill(arr,-1);
        }
        words = new HashSet<>();
        for(String word : wordDict){
            words.add(word);
        }
        return isValid(0,0);
    }
    public boolean isValid(int start, int end){
        if(start >= str.length()){
            return true;
        }
        if(end >= str.length()){
            return false;
        }
        if(dp[start][end] == 1){
            return true;
        }
        else if(dp[start][end] == 0){
            return false;
        }
        boolean no = false;
        if(words.contains(str.substring(start,end+1))){
            no = isValid(end + 1,end + 1);
        }
        boolean yes = isValid(start, end + 1);
        dp[start][end] = (yes || no) == true ? 1 : 0;
        return (yes || no);
    }
}