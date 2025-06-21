class Solution {
    public int minimumDeletions(String word, int k) {
        int [] freq = new int[26];
        for(int i = 0;i<word.length();i++){
            freq[word.charAt(i) - 'a']++;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<26;i++){
            if(freq[i] > 0){
                list.add(freq[i]);
            }
        }
        int res = word.length();
        for(int i = 0;i<list.size();i++){
            int curr = 0;
            for(int j = 0;j<list.size();j++){
                if(list.get(j) < list.get(i)){
                    curr+=list.get(j);
                }
                else{
                    curr+=Math.max(0,list.get(j) - (list.get(i) + k));
                }
            }
            res = Math.min(res,curr);
        }
        return res;
    }
}