class Solution {
    public String majorityFrequencyGroup(String s) {
        int [] freqs = new int[26];
        int maxFreq = 0;
        for(int i = 0;i<s.length();i++){
            freqs[s.charAt(i) - 'a']+=1;
            maxFreq = Math.max(maxFreq, freqs[s.charAt(i) - 'a']);
        }
        // for(int i = 0;i<freqs.length;i++){
        //     System.out.print(freqs[i] + " ");
        // }
        
        int res = 0;
        int searchP = 0;
        int [] buckets = new int[maxFreq + 1];
        for(int i = 0;i<freqs.length;i++){
            if(freqs[i]!=0){
                buckets[freqs[i]]+=1;
                if (buckets[freqs[i]] > res ||
                    (buckets[freqs[i]] == res && freqs[i] > searchP)) {
                        res = buckets[freqs[i]];
                        searchP = freqs[i];
                }
            }
        }
        // System.out.println();
        // for(int i = 0;i<buckets.length;i++){
        //     System.out.print(buckets[i] + " ");
        // }
        // System.out.println();
        // System.out.println(searchP);
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<freqs.length;i++){
            if(freqs[i] == searchP){
                str.append((char)('a' + i));
            }
        }

        return str.toString();
    }
}