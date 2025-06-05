class Solution {
    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) parent[i] = i; 
        for (int i = 0; i < s1.length(); i++) {
            int a = find(parent, s1.charAt(i) - 'a');
            int b = find(parent, s2.charAt(i) - 'a');
            if (a == b) continue;
            if (a < b) parent[b] = a;
            else        parent[a] = b;
        }
        StringBuilder sb = new StringBuilder(baseStr.length());
        for (int i = 0; i < baseStr.length(); i++) {
            sb.append((char) (find(parent, baseStr.charAt(i) - 'a') + 'a'));
        }
        return sb.toString();
    }
}
