class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int [] freq = new int[26];
        for(String word : strs){
            for(int i = 0;i<word.length();i++){
                freq[word.charAt(i) - 'a']+=1;
            }
            String key = Arrays.toString(freq);
            List<String> temp = map.containsKey(key) ? map.get(key) : new ArrayList<>();
            temp.add(word);
            map.put(key,temp);
            Arrays.fill(freq,0);
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}