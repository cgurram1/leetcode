class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map1 = new HashMap<>();
        int count = 0;
        int added = 0;

        // Step 1: Count frequency of each word
        for (int i = 0; i < words.length; i++) {
            map1.put(words[i], map1.getOrDefault(words[i], 0) + 1);
        }

        // Step 2: Process each word
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String curr = word.charAt(1) + "" + word.charAt(0);

            // Skip if this word is already used up
            if (!map1.containsKey(word) || map1.get(word) == 0) continue;

            if (word.equals(curr)) {
                // Symmetric word like "aa", "bb"
                if (map1.get(word) % 2 == 0) {
                    count += map1.get(word);
                    map1.put(word, 0);
                } else {
                    count += map1.get(word) - 1;
                    map1.put(word, 1);
                    if (added == 0) {
                        count += 1;
                        added = 1;
                        map1.put(word, 0);
                    }
                }
            } else if (map1.containsKey(curr) && map1.get(curr) > 0) {
                // Asymmetric pair like "ab" + "ba"
                int pairCount = Math.min(map1.get(word), map1.get(curr));
                count += pairCount * 2;
                map1.put(word, map1.get(word) - pairCount);
                map1.put(curr, map1.get(curr) - pairCount);
            }
        }

        return count * 2;
    }
}
