class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int [] one = new int[26];
        int [] two = new int[26];
        for(int i = 0;i<s1.length();i++){
            one[s1.charAt(i) - 'a']+=1;
        }
        int windowLength = s1.length();
        int left = 0;
        int right = windowLength-1;
        for(int i = 0;i<=right;i++){
            two[s2.charAt(i)-'a']+=1;
        }
        while(right < s2.length()-1){
            if(Arrays.equals(one,two)){
                return true;
            }
            two[s2.charAt(left) - 'a']-=1;
            left++;
            right++;
            two[s2.charAt(right) - 'a']+=1;
        }
        if(Arrays.equals(one,two)){
                return true;
        }
        return false;
    }
}