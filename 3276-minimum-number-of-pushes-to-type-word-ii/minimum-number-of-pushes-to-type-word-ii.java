class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> freq = new HashMap<>();
        for(int i = 0;i<word.length();i++){
            if(freq.containsKey(word.charAt(i))){
                freq.put(word.charAt(i), freq.get(word.charAt(i))+1);
            }
            else{
                freq.put(word.charAt(i), 1);
            }
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a,b)->b.getValue() - a.getValue());
        int count = 0;
        int sum = 0;
        for(Map.Entry<Character, Integer> item : list){
            sum+=(item.getValue() * ((count/8)+1));
            count+=1;
        }
        return sum;
    }
}