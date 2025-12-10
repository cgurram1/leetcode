class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap();
        for(int i = 0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        int left = 0;
        while(left < s.length()){
            int i = left;
            int right = map.get(s.charAt(left));
            while(i < right){
                if(map.get(s.charAt(i)) > right){
                    right = map.get(s.charAt(i));
                }
                i+=1;
            }
            list.add(right-left + 1);
            left = right+1;
        }
        return list;
    }
}