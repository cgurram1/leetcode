/**

                      l
                      r
aeiaaioaaaaeiiiiouuuooaauuaeiu

 */
class Solution {
    public int longestBeautifulSubstring(String word) {
        int left = 0;
        int right = 0;
        int result = 0;
        Character prevAdded = null;
        // System.out.println(word.length());
        while(right < word.length()){
            if(prevAdded == null && word.charAt(right) == 'a'){
                prevAdded = 'a';
                left = right;
            }
            else if(prevAdded == null){
                right+=1;
                continue;
            }
            else if(prevAdded == 'a' && word.charAt(right) == 'a'){
                if(left == -1){
                    left = right;
                }
            }
            else{
                if((word.charAt(right) == 'e' && (prevAdded == 'a' || prevAdded == 'e')) || (word.charAt(right) == 'i' && (prevAdded == 'e' || prevAdded == 'i')) || (word.charAt(right) == 'o' && (prevAdded == 'i' || prevAdded == 'o'))){
                    prevAdded = word.charAt(right);
                }
                else if(word.charAt(right) == 'u' && (prevAdded == 'o' || prevAdded == 'u')){
                    prevAdded = word.charAt(right);
                    result = Math.max(result, right - left + 1);
                }
                else{
                    prevAdded = null;
                    left = -1;
                    if (word.charAt(right) == 'a') {
                        prevAdded = 'a';
                        left = right;
                    }
                }
            }
            right+=1;
        }
        return result;
    }
}

/**
012345678 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29
aeiaaioaa a  a  e  i  i  i  i  o  u  u  u  o  o  a  a  u  u  a  e  i  u
       l.                               r
 */