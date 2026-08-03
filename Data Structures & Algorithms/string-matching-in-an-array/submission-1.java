class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // loop through the list of words to check for substrings
            for (String w : words) {
                if (w.equals(word)) continue; // don't check the same word
                if (w.contains(word)) set.add(word);
            }
        }

        return new ArrayList<>(set);
    }
}