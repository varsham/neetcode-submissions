class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;

        HashSet<Character> charSet = new HashSet<>();

        // populate the char set
        for (char c : s.toCharArray()) {
            charSet.add(c);
        }

        for (char c : charSet) {
            int count = 0, l = 0;
            for (int r = 0; r < s.length(); r++) {
                // count the number of characters equal to a specific char
                if (s.charAt(r) == c) count++;

                while ((r - l + 1) - count > k) {
                    if (s.charAt(l) == c) count--;
                    l++;
                }

                result = Math.max(result, r - l + 1);
            
            }

            
        }

        return result;
    }

    
}