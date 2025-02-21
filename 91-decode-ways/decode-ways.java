class Solution {
    public int numDecodings(String s) {
        Map<String,Character> myMap = new HashMap<>();
        Map<String,Integer> dp = new HashMap<>();
        // Set<String> mySet = new HashSet<>();
        for(int i = 1;i<27;i++){
            myMap.put(i+"",(char)(65 + i-1));
        }
        return rec("",s,0,myMap,dp);
    }
    public static int rec(String decoded,String next,int index,Map<String,Character> myMap, Map<String,Integer> dp){
        if(next == ""){
            return 1;
        }
        if(dp.containsKey(next)){
            return dp.get(next);
        }
        int one = 0;
        int two = 0;
        if(myMap.containsKey("" + next.charAt(0))){
            one = rec(decoded + myMap.get("" + next.charAt(0)),next.substring(1,next.length()),index+1,myMap,dp);
        }
        if(next.length() > 1){
            if(myMap.containsKey(next.charAt(0) + "" + next.charAt(1))){
                two = rec(decoded + myMap.get(next.charAt(0) + "" + next.charAt(1)),next.substring(2,next.length()),index+2,myMap,dp);
            }
        }
        dp.put(next,one + two);
        return(one + two);
    }
}