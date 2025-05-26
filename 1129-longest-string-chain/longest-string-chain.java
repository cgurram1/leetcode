class Solution {
    public int longestStrChain(String[] words) {
        MyObject [] newList = new MyObject[words.length];
        for(int i = 0;i<words.length;i++){
            newList[i] = new MyObject(words[i]);
        }
        Arrays.sort(newList);
        int max = 0;
        Integer[] memo = new Integer[words.length];
        for (int i = 0; i < newList.length; i++) {
            max = Math.max(max, fun(i, newList,memo));
        }
        return max;
                
    }
    public int fun(int index, MyObject[] newList, Integer[] memo) {
        if (memo[index] != null) return memo[index];

        int max = 1;
        for (int i = index + 1; i < newList.length; i++) {
            if (isValid(newList[i].word, newList[index].word)) {
                max = Math.max(max, 1 + fun(i, newList, memo));
            }
        }
        memo[index] = max;
        return max;
    }
    public boolean isValid(String two, String one) {
        if (two.length() - one.length() != 1) return false;
        int up = 0;
        int down = 0;
        int count = 0;
        while (down < two.length()) {
            if (up < one.length() && one.charAt(up) == two.charAt(down)) {
                up++;
                down++;
            } else {
                if (count == 1) return false; // already skipped one mismatch
                count = 1;
                down++; // skip this extra char in `two`
            }
        }
        return true;
    }
}

class MyObject implements Comparable<MyObject>{
    String word;
    public MyObject(String word){
        this.word = word;
    }
    public int compareTo(MyObject other){
        return this.word.length() - other.word.length();
    }
}