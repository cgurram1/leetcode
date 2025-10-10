class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int k = 0; k < levelSize; k++) {
                char[] currentWord = queue.poll().toCharArray();
                for (int i = 0; i < currentWord.length; i++) {
                    char originalChar = currentWord[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        currentWord[i] = c;
                        String newWord = new String(currentWord);
                        if (set.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return level + 1;
                            }
                            queue.add(newWord);
                            set.remove(newWord);
                        }
                    }
                    currentWord[i] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}
