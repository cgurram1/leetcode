class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character,Integer>,ArrayList<String>> outerMap = new HashMap<>();
        for(int i = 0;i<strs.length;i++){
            Map<Character,Integer> innerMap = new HashMap<>();
            for(int j = 0;j<strs[i].length();j++){
                innerMap.put(strs[i].charAt(j), innerMap.getOrDefault(strs[i].charAt(j),0)+1);
            }

            ArrayList<String> anagramList = outerMap.getOrDefault(innerMap, new ArrayList<String>());
            anagramList.add(strs[i]);
            outerMap.put(innerMap, anagramList);
        }
        System.out.println(outerMap);
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Map<Character,Integer>,ArrayList<String>> item : outerMap.entrySet()){
            res.add(item.getValue());
        }
        
        return res;
    }
}