class Trie {
    Trie [] arr;
    boolean flag;

    public Trie() {
        this.arr = new Trie[26];
        Arrays.fill(this.arr,null);
        this.flag = false;
    }
    
    public void insert(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.arr[idx] == null) {
                curr.arr[idx] = new Trie();
            }
            curr = curr.arr[idx];
        }
        curr.flag = true;
    }

    public boolean search(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.arr[idx] == null) {
                return false;
            }
            curr = curr.arr[idx];
        }
        return curr.flag;
    }

    
    public boolean startsWith(String prefix) {
        Trie curr = this;
        for(int i = 0; i<prefix.length();i++){
            if(curr.arr[(int)prefix.charAt(i) - (int)'a'] == null){
                return false;
            }
            curr = curr.arr[(int)prefix.charAt(i) - (int)'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */