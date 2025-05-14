class Solution {
    // BruteForce
    //Generate all k length binary strings anc check if it exists in the set


    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        // StringBuilder st = new StringBuilder();
        // for(int i = 0;i<k;i++){
        //     st.append("0");
        // }
        for(int i = 0;i<=s.length()-k;i++){
            set.add(s.substring(i,i+k));
        }
        return set.size() == Math.pow(2,k);
    }
    public boolean fun(int index,StringBuilder st,Set<String> set){
        if(index == st.length()){
            if(set.contains(st.toString())){
                return true;
            }
            return false;
        }
        // keep it 0
        boolean zero = fun(index + 1, st,set);
        // change to 1
        st.setCharAt(index,'1');
        boolean one = fun(index + 1,st,set);
        st.setCharAt(index,'0');
        return zero && one;
    }
}