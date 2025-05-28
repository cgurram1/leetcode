class Solution {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left <= right && s.charAt(left) == s.charAt(right)){
            // System.out.println(s.substring(left,right+1));
            // System.out.println(left + " " + right);
            if(left + 1 == right && s.charAt(left) == s.charAt(right)){
                return 0;
            }
            if(left == right){
                return 1;
            }
            while(left + 1 <= right && s.charAt(left) == s.charAt(left+1)){
                left+=1;
            }
            if(left + 1 > right){
                return 0;
            }
            left+=1;
            // System.out.println(left + " " + right);
            while(right >= left && s.charAt(right) == s.charAt(right-1)){
                right-=1;
            }
            right-=1;
            // System.out.println(left + " " + right);
        }
        return right - left + 1;
    }
}