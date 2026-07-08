class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // use a hash table

        // key: String (sorted string)
        // values: associated anagrams
        Map<String, List<String>> set = new HashMap<>();

        for (String s : strs) {
            // create hash table
            int[] freq = new int[26];

            // populate hash table
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            // convert the frequency to a string to use as a key
            String key = Arrays.toString(freq);

            // check if the key is already present in set
            set.putIfAbsent(key, new ArrayList<>());
            set.get(key).add(s);
        }

        return new ArrayList<>(set.values());
    }
}
