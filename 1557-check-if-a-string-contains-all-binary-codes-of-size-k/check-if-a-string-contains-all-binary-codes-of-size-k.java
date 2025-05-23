class Solution {
    // BruteForce
    //Generate all k length binary strings anc check if it exists in the set
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        for(int i = 0;i<=s.length()-k;i++){
            set.add(s.substring(i,i+k));
        }
        return set.size() == Math.pow(2,k);
    }
}