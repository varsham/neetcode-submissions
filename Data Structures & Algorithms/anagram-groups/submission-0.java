class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // hash table: representing every character
        // create a hash map to return
        Map<String, List<String>> set = new HashMap<>();

        for (String s : strs) {
            // create a frequency array
            int[] freq = new int[26];

            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            String key = Arrays.toString(freq);
            set.putIfAbsent(key, new ArrayList<>());
            set.get(key).add(s);
        }

        return new ArrayList<>(set.values());
    }
}
