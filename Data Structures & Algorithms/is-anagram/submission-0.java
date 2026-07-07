class Solution {
    public boolean isAnagram(String s, String t) {
        // use one array to track frequency
        
        // check lengths
        if (s.length() != t.length()) return false;

        // create frequency array
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 97]++;
            freq[t.charAt(i) - 97]--;
        }

        for (int val : freq) {
            if (val != 0) return false;
        }
        return true;
    }
}
